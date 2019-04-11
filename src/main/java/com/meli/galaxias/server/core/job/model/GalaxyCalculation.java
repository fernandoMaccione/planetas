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
		
		for (int i =firtDay; i<=lastDay; i++){
			galaxy.setSimlateDay(i);
			for (ICalculo calculo:calculo){
				CalculationPredictionDTO resutlDto = calculo.execute(galaxy, i);
				addCalculo(resutlDto, result);
			}
		}
		
		return result;
	}
	
	private void addCalculo(CalculationPredictionDTO r, HashMap<String, List<CalculationPredictionDTO>> result) {
		if (result.containsKey(r.getCodeCalculate())){
			List<CalculationPredictionDTO> cResults = result.get(r.getCodeCalculate());
			CalculationPredictionDTO last = cResults.get(cResults.size());
			if (last.getResult().equals(r.getResult())){ //Si el resultado del calculo fue el mismo, entonces lo sumo como un perido de tiempo
				last.setLastDay(r.getDay());
			}else{
				cResults.add(r);
			}
		}else{
			List<CalculationPredictionDTO>cResults = new ArrayList<CalculationPredictionDTO>();
			result.put(r.getCodeCalculate(), cResults);
			cResults.add(r);
		} 
	}

}
