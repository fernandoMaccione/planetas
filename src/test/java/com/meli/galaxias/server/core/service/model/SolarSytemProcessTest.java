package com.meli.galaxias.server.core.service.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.exception.NotFoundException;

public class SolarSytemProcessTest {
	
	@Test
	public void addCalculationTest(){
		SolarSytemProcess process = new SolarSytemProcess();
		
		List<CalculationPredictionDTO> groupResult = new ArrayList<>();	
		process.result= new HashMap<String, List<CalculationPredictionDTO>> ();
		process.result.put("FORECAST", groupResult);
		
		CalculationPredictionDTO result = new CalculationPredictionDTO();		
		result.setResult("X");
		result.setDay(1);		
		process.addCalculation(result, groupResult);
		
		assertTrue(result.getLastDay() == 1);
		assertTrue(groupResult.size()==1);
		
		CalculationPredictionDTO result1 = new CalculationPredictionDTO();
		result1.setResult("X");
		result1.setDay(2);		
		process.addCalculation(result1, groupResult);
		
		assertTrue(result.getLastDay() == 2);
		assertTrue(groupResult.size()==1);
		
		CalculationPredictionDTO result2 = new CalculationPredictionDTO();
		result2.setResult("X");
		result2.setDay(13);		
		process.addCalculation(result2, groupResult);
		
		assertTrue(result.getLastDay() == 13);
		assertTrue(groupResult.size()==1);
		
		CalculationPredictionDTO result3 = new CalculationPredictionDTO();
		result3.setResult("otro resultado");
		result3.setDay(14);		
		process.addCalculation(result3, groupResult);
		
		assertTrue(result.getLastDay() == 13); //debe permanecer igual
		assertTrue(groupResult.size()==2); 
		
		assertTrue(result3.getLastDay() == 14);
	}
	
	@Test
	public void getPredictionTest(){
		SolarSytemProcess process = getProcessForTest();
		
		for (CalculationPredictionDTO r: process.getPrediction("FORECAST", "SOLEADO")){
			assertTrue(r.getResult().equals("SOLEADO"));
		}
	}
	
	@Test
	public void getByDayTest() throws NotFoundException{
		SolarSytemProcess process = getProcessForTest();
		
		assertTrue(process.getByDay("FORECAST", 13).getResult().equals("LLUVIA"));
		assertTrue(process.getByDay("FORECAST", 40).getResult().equals("SOLEADO"));
		assertTrue(process.getByDay("FORECAST", 1).getResult().equals("SOLEADO"));
		assertTrue(process.getByDay("FORECAST", 31).getResult().equals("TORMENTA"));
	}
	
	@Test
	public void countPeriodTest(){
		SolarSytemProcess process = getProcessForTest();
		
		assertTrue(process.countPeriod("FORECAST", "LLUVIA").intValue() == 1);
		assertTrue(process.countPeriod("FORECAST", "SOLEADO").intValue() == 3);
		assertTrue(process.countPeriod("FORECAST", "TORMENTA").intValue() == 1);
	}

	private SolarSytemProcess getProcessForTest() {
		SolarSytemProcess process = new SolarSytemProcess();
		List<CalculationPredictionDTO> groupResult = new ArrayList<>();	
		process.result= new HashMap<String, List<CalculationPredictionDTO>> ();
		process.result.put("FORECAST", groupResult);
		
		CalculationPredictionDTO result = new CalculationPredictionDTO();		
		result.setResult("SOLEADO");
		result.setDay(1);
		result.setLastDay(12);
		groupResult.add(result);
		
		result = new CalculationPredictionDTO();		
		result.setResult("LLUVIA");
		result.setDay(13);
		result.setLastDay(13);
		groupResult.add(result);
		
		result = new CalculationPredictionDTO();		
		result.setResult("SOLEADO");
		result.setDay(14);
		result.setLastDay(30);
		groupResult.add(result);
		
		result = new CalculationPredictionDTO();		
		result.setResult("TORMENTA");
		result.setDay(31);
		result.setLastDay(31);
		groupResult.add(result);
		
		result = new CalculationPredictionDTO();		
		result.setResult("SOLEADO");
		result.setDay(32);
		result.setLastDay(50);
		groupResult.add(result);
		return process;
	}
}
