package com.meli.galaxias.server.core.calculation.Forecast.model;

import com.meli.galaxias.server.core.service.model.ISolarSystem;
import com.meli.galaxias.server.core.solarSystem.CelestialBody;

public class Aligned implements ICalculateForecast {


	public Result execute(ISolarSystem galaxi, long day, Result anterior) {
		boolean alined = false;
		Result result = new Result();
		for (int i = 0; i < galaxi.getPlanets().size() - 2; i++){
			alined = calculateStraight (galaxi.getPlanets().get(i), galaxi.getPlanets().get(i + 1),galaxi.getPlanets().get(i + 2));
		}
		if (alined){
			result.setMatch(true);
			boolean conElSol = calculateStraight (galaxi.getSun(), galaxi.getPlanets().get(0),galaxi.getPlanets().get(1));
			if (conElSol){
				result.setMessage(Result.CLIMA_OPTIMO);
				//System.out.println("Clima Optimo dia; " + String.valueOf(day));
			}else{
				result.setMessage(Result.CLIMA_SEQUIA);
				//System.out.println("Sequia dia; " + String.valueOf(day));
			}
		}
		return result;
	}

	private boolean calculateStraight (CelestialBody c1, CelestialBody c2, CelestialBody c3){
		double tangecteEnC1 = 0;
		if ((c2.getPosition().getX() - c1.getPosition().getX())!=0)
			tangecteEnC1 = (c2.getPosition().getY() - c1.getPosition().getY()) / (c2.getPosition().getX() - c1.getPosition().getX());
		
		double tangenteEnC2 = 0;
		if ((c3.getPosition().getX() - c2.getPosition().getX()) !=0)
			tangenteEnC2 = (c3.getPosition().getY() - c2.getPosition().getY()) / (c3.getPosition().getX() - c2.getPosition().getX());
		tangecteEnC1 = Math.round(tangecteEnC1 * 100000d)/100000d; 
		tangenteEnC2 = Math.round(tangenteEnC2 * 100000d)/100000d;
		
		//System.out.println("Eje X: " + String.valueOf(tangecteEnC1) + " Eje Y: "+ String.valueOf(tangenteEnC2));
		
		return tangecteEnC1 == tangenteEnC2;
	}

	public boolean excludeOther() {

		return true; //Si en este calculo se detectan que estan alineados, no tiene sentido realizar los demas.
	}

	public Result getFinalResult() {

		return null;
	}

}
