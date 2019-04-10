package com.meli.galaxias.server.core.job;

import java.util.List;

import com.meli.galaxias.server.core.job.model.FactoryGalaxyCalculation;
import com.meli.galaxias.server.core.job.model.GalaxyCalculation;

public class TaskExecutor implements Runnable{
/**
 * La idea de esta clase, es que no solo sirva para la previsión del tiempo, sino de que que en 
 * un futuro los habitantes de los planetas, puedan llegar a requerir algun otro tipo de analisis de su mismo sistema solar 
 * o porque no, de otros?
 */
	private List<GalaxyCalculation> galaxyCalculations;
	
	public TaskExecutor(){
		galaxyCalculations = FactoryGalaxyCalculation.calculationRegistred();
	}

	public void run() {
		
		
		for (GalaxyCalculation galaxia:galaxyCalculations){
			galaxyProcess(galaxia);
		}
			

		
	}

	private void galaxyProcess(GalaxyCalculation galaxia) {
		for (int i =galaxia.getFirtDay(); i<=galaxia.getLastDay(); i++){
			galaxia.getGalaxy().setSimlateDay(i);
			
			//calculo.execute(galaxia, i);
		}
		
	}
	

}
