package com.meli.galaxias.server.core.job;

import java.util.HashMap;
import java.util.List;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.job.model.FactoryGalaxyCalculation;
import com.meli.galaxias.server.core.job.model.GalaxyCalculation;

public class TaskExecutor implements Runnable{
/**
 * La idea de esta clase, es que no solo sirva para la previsión del tiempo, sino de que que en 
 * un futuro los habitantes de los planetas, puedan llegar a requerir algun otro tipo de analisis de su mismo sistema solar, 
 * o porque no, de otros?
 */
	private List<GalaxyCalculation> galaxyCalculations;
	
	public TaskExecutor(){
		galaxyCalculations = FactoryGalaxyCalculation.calculationRegistred();
	}

	public void run() {		
		
		for (GalaxyCalculation galaxy:galaxyCalculations){
			HashMap<String, List<CalculationPredictionDTO>> result = galaxy.executeProcess();
			//saveCalculation(result);
		}
	
	}

	private void saveCalculation(HashMap<String, List<CalculationPredictionDTO>> result) {
		for (List<CalculationPredictionDTO> listaCalculos:result.values()){
			for (CalculationPredictionDTO dto:listaCalculos){
				System.out.println("Dia inicial: " + String.valueOf(dto.getDay()) + 
						" Ultimo dia: " + String.valueOf(dto.getLastDay()) + " resultado: " + dto.getResult());
			}
		}
		
	}


}
