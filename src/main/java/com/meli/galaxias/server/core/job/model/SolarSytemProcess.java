package com.meli.galaxias.server.core.job.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.meli.galaxias.common.CalculationPredictionDAO;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.job.ISolarSystem;
import com.meli.galaxias.server.core.job.ICalculo;

public class SolarSytemProcess {
	private long idProcess;
	private ISolarSystem sSolar;
	private List<ICalculo> calculo;
	private int firtDay;
	private int lastDay;
	private HashMap<String, List<CalculationPredictionDTO>> result;
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
	public List<ICalculo> getCalculo() {
		return calculo;
	}
	public void setCalculo(List<ICalculo> calculo) {
		this.calculo = calculo;
	}
	
	public void executeProcess() {		
		
		result = new HashMap<String, List<CalculationPredictionDTO>> ();
		for (ICalculo calculo:calculo){
			//Chequeo si ya no lo tengo almacenado en la base
			List<CalculationPredictionDTO> calculos = CalculationPredictionDAO.getCalculation(idProcess, calculo.getCode());
			if (calculos == null){
				//Si no vino nada de la base, los genero y los guardo.
				calculos = generate(calculo);				
				CalculationPredictionDAO.save(calculos);
			}
			result.put(calculo.getCode(), calculos);
		}		
	}
	
	public List<CalculationPredictionDTO> getResult(String codeCal){
		return result.get(codeCal);
	}
	
	private List<CalculationPredictionDTO> generate(ICalculo calculo) {		
		
		List<CalculationPredictionDTO> res = new ArrayList<CalculationPredictionDTO>();
		
		for (int i =firtDay; i<=lastDay; i++){
			CalculationPredictionDTO resutlDto = calculo.execute(sSolar, i);
			resutlDto.setIdProcess(idProcess);
			addCalculo(resutlDto, res);
		}
		//Existen calculos que recien tienen disponible su resultado, al finalizar el enalisis de todo el periodo (ej: maxima lluva)
		addCalculo (calculo.getFinalResult(sSolar), res);		
		
		return res;
	}
	
	private void addCalculo(List<CalculationPredictionDTO> finalResult, List<CalculationPredictionDTO> result) {
		for (CalculationPredictionDTO r:finalResult){
			addCalculo (r, result);
		}
	}
	private void addCalculo(CalculationPredictionDTO r, List<CalculationPredictionDTO> cResults) {
		/**
		 * La idea de este metodo es que vaya agrupando el resultado de un calculo de un dia en un periodo de tiempo
		 */

		CalculationPredictionDTO last = (cResults.size()<1?null:cResults.get(cResults.size()-1));
		if (last != null && last.getResult().equals(r.getResult())){ //Si el resultado del calculo fue el mismo, entonces lo sumo como un perido de tiempo
			last.setLastDay(r.getDay());
		}else{
			r.setLastDay(r.getDay());
			cResults.add(r);
		}
		 
	}
	

}
