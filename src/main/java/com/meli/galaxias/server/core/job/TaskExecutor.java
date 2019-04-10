package com.meli.galaxias.server.core.job;

import java.util.List;
import java.util.function.Predicate;

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
		
		for (GalaxyCalculation galaxy:galaxyCalculations){
			galaxyProcess(galaxy);
		}
	}

	private void galaxyProcess(GalaxyCalculation gc) {
		for (int i =gc.getFirtDay(); i<=gc.getLastDay(); i++){
			gc.getGalaxy().setSimlateDay(i);
			for (ICalculo calculo:gc.getCalculo()){
				calculo.execute(gc.getGalaxy(), i);
			}
		}
	}
}
