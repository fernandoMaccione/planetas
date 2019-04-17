package com.meli.galaxias.server.core.calculation.Forecast.model;

import java.awt.Polygon;

import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.Point;
import com.meli.galaxias.server.core.service.model.ISolarSystem;

public class Rain implements ICalculateForecast {

	public Result execute(ISolarSystem galaxi, long day, Result anterior) {
		Polygon polygon = new Polygon();
		for (Planet planeta:galaxi.getPlanets()){
			Point point = planeta.getPosition();
			polygon.addPoint((int)point.getX(), (int)point.getY());
		}
		
		boolean isRain = polygon.contains(galaxi.getSun().getPosition().getX(), galaxi.getSun().getPosition().getY());
		
		Result result = new Result();
		if (isRain){
			result.setMatch(true);
			result.setMessage(Result.CLIMA_LLUVIA);
		}else{
			result.setMatch(false);
			result.setMessage(Result.CLIMA_SOL);
		}
			
		return result;
	}

	public boolean excludeOther() {
		return false;
	}

	public Result getFinalResult() {
		return null;
	}
}
