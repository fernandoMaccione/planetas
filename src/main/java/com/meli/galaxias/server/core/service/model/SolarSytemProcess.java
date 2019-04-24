package com.meli.galaxias.server.core.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.meli.galaxias.common.dao.CalculationPredictionDAO;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.exception.NotFoundException;
import com.meli.galaxias.server.core.exception.ServiceException;
/*
 * En esta clase se define lo que es un "proceso".
 * En un proceso se dice sobre que sistema solar se van a realizar los calculos (ISolarSystem), en que periodo de tiempo y que calculos hay que efectuarle
 * Se encarga de realizar la ejecución de los mismo y mantener los resultados para su posterior consulta. Ya sea en cache o base de datos.
 * ICalculate, es un tipo de calculo a efectuar. Puede ser Forecast (como el que plantea el ejercio) o cualquier otro tipo que implemente la interfaz.
 * 
 *  Ya que los resultados son uno por dia por calculo, la clase se va a encargar de agruparlos para ir formando los periodos de tiempo.
 */
public class SolarSytemProcess {
	private long idProcess;
	private ISolarSystem sSolar;
	private List<ICalculate> calculate;
	private int firtDay;
	private int lastDay;
	protected HashMap<String, List<CalculationPredictionDTO>> result;
	public int getFirtDay() {
		return firtDay;
	}
	public void setFirtDay(int firtDay) {
		this.firtDay = firtDay;
	}
	public int getLastDay() {
		return lastDay;
	}
	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}
	public ISolarSystem getGalaxy() {
		return sSolar;
	}
	public void setGalaxy(ISolarSystem galaxy) {
		this.sSolar = galaxy;
	}
	public List<ICalculate> getCalculate() {
		return calculate;
	}
	public void setCalculate(List<ICalculate> calculo) {
		this.calculate = calculo;
	}
	
	public void executeProcess() throws ServiceException {		
		
		result = new HashMap<String, List<CalculationPredictionDTO>> ();
		//Itereo cada calculo dado de alta.
		for (ICalculate calculo:calculate){ 
			//Chequeo si ya no lo tengo almacenado en la base
			List<CalculationPredictionDTO> calculations = CalculationPredictionDAO.getCalculation(idProcess, calculo.getCode());
			if (calculations == null || calculations.isEmpty()){
				//Si no vino nada de la base, los genero y los guardo.
				calculations = generate(calculo);				
				CalculationPredictionDAO.save(calculations);
			}
			result.put(calculo.getCode(), calculations);
		}		
	}
	
	public List<CalculationPredictionDTO> getResult(String codeCal){
		return result.get(codeCal);
	}
	
	private List<CalculationPredictionDTO> generate(ICalculate cal) throws ServiceException {		
		
		List<CalculationPredictionDTO> res = new ArrayList<CalculationPredictionDTO>();
		//Itero por cada día y ejecuto el calculo.
		for (int i =firtDay; i<=lastDay; i++){
			System.out.println("Calculando dia: " + String.valueOf(i));
			CalculationPredictionDTO resutlDto = cal.execute(sSolar, i);
			resutlDto.setIdProcess(idProcess);
			if (resutlDto.getResult() == null)
				throw new ServiceException("The calculation " + cal.getCode() + ", return null at day: " + String.valueOf(i));
			
			addCalculation(resutlDto, res);
		}
		//Existen calculos que recien tienen disponible su resultado, al finalizar el enalisis de todo el periodo (ej: maxima lluva)
		addCalculation (cal.getFinalResult(sSolar), res);		
		
		return res;
	}
	
	private void addCalculation(List<CalculationPredictionDTO> finalResult, List<CalculationPredictionDTO> result) {
		for (CalculationPredictionDTO r:finalResult){
			addCalculation (r, result);
		}
	}
	protected void addCalculation(CalculationPredictionDTO dto, List<CalculationPredictionDTO> cResults) {
		
		/**
		 * La idea de este metodo es que vaya agrupando el resultado de un calculo de un dia en un periodo de tiempo
		 */
		
		CalculationPredictionDTO last = (cResults.size()<1?null:cResults.get(cResults.size()-1));
		if (last != null && last.getResult().equals(dto.getResult())){ //Si el resultado del calculo fue el mismo, entonces lo sumo como un perido de tiempo
			last.setLastDay(dto.getDay());
		}else{
			dto.setLastDay(dto.getDay());
			cResults.add(dto);
		}
	}
	
	public List<CalculationPredictionDTO> getPrediction(String codeCal, String filter){
		List<CalculationPredictionDTO> list = result.get(codeCal);
		List<CalculationPredictionDTO> listFilter = list.parallelStream().filter(t -> t.getResult() == filter)
				.collect(Collectors.toList());
		return listFilter;
	}
	
	public CalculationPredictionDTO getOnePrediction(String codeCal, String filter) throws NotFoundException{
		List<CalculationPredictionDTO> list = result.get(codeCal);
		CalculationPredictionDTO dto = list.parallelStream().filter(t -> t.getResult() == filter)
				.findFirst()
				.orElse(null);
		if (dto == null){
			throw new NotFoundException("Not Found prediction for filter: " + filter);
		}
		return dto;
	}
	
	public CalculationPredictionDTO getByDay(String codeCal, int day) throws NotFoundException{
		List<CalculationPredictionDTO> list = result.get(codeCal);
		CalculationPredictionDTO dto = list.parallelStream().filter(t -> day >= t.getDay() && day <= t.getLastDay()  )
				.findFirst()
				.orElse(null);
		if (dto == null){
			throw new NotFoundException("Not Found prediction for day: " + String.valueOf(day));
		}
		return dto;
	}

	public Long countPeriod(String codeCal, String filter){
		List<CalculationPredictionDTO> list = result.get(codeCal);
		long count = list.parallelStream().filter(t -> t.getResult() == filter)
				.count();
		return count;
	}
}
