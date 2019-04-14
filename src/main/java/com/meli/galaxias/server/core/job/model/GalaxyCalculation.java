package com.meli.galaxias.server.core.job.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.job.ICalculo;

public class GalaxyCalculation {
	private ICalculable galaxy;
	private List<ICalculo> calculo;
	private int firtDay;
	private int lastDay;
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
	public ICalculable getGalaxy() {
		return galaxy;
	}
	public void setGalaxy(ICalculable galaxy) {
		this.galaxy = galaxy;
	}
	public List<ICalculo> getCalculo() {
		return calculo;
	}
	public void setCalculo(List<ICalculo> calculo) {
		this.calculo = calculo;
	}
	
	public HashMap<String, List<CalculationPredictionDTO>> executeProcess() {		
		
		HashMap<String, List<CalculationPredictionDTO>> result = new HashMap<String, List<CalculationPredictionDTO>> ();
		for (ICalculo calculo:calculo){	
			for (int i =firtDay; i<=lastDay; i++){
				CalculationPredictionDTO resutlDto = calculo.execute(galaxy, i);
				addCalculo(resutlDto, result);
			}
			addCalculo (calculo.getFinalResult(galaxy), result);
		}
		
		return result;
	}
	
	private void addCalculo(List<CalculationPredictionDTO> finalResult, HashMap<String, List<CalculationPredictionDTO>> result) {
		for (CalculationPredictionDTO r:finalResult){
			addCalculo (r, result);
		}
	}
	private void addCalculo(CalculationPredictionDTO r, HashMap<String, List<CalculationPredictionDTO>> result) {
		/**
		 * La idea de este metodo es que vaya agrupando el resultado de un calculo de un dia y en un periodo de tiempo
		 */
		if (result.containsKey(r.getCodeCalculate())){
			List<CalculationPredictionDTO> cResults = result.get(r.getCodeCalculate());
			CalculationPredictionDTO last = (cResults.size()<1?null:cResults.get(cResults.size()-1));
			if (last != null && last.getResult().equals(r.getResult())){ //Si el resultado del calculo fue el mismo, entonces lo sumo como un perido de tiempo
				last.setLastDay(r.getDay());
			}else{
				r.setLastDay(r.getDay());
				cResults.add(r);
			}
		}else{
			List<CalculationPredictionDTO>cResults = new ArrayList<CalculationPredictionDTO>();
			result.put(r.getCodeCalculate(), cResults);
			cResults.add(r);
		} 
	}

}
