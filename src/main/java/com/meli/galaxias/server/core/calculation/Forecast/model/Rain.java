package com.meli.galaxias.server.core.calculation.Forecast.model;

import java.awt.Polygon;

import com.meli.galaxias.server.core.job.model.ISolarSystem;
import com.meli.galaxias.server.core.model.Planet;
import com.meli.galaxias.server.core.model.Point;

public class Rain implements ICalculateForecast {

	public Result execute(ISolarSystem galaxi, long day, Result anterior) {
		Polygon poligono = new Polygon();
		for (Planet planeta:galaxi.getPlanets()){
			Point punto = planeta.getPosition();
			poligono.addPoint((int)punto.getX(), (int)punto.getY());
		}
		
		boolean esLLuvia = poligono.contains(galaxi.getSun().getPosition().getX(), galaxi.getSun().getPosition().getY());
		
		Result resultado = new Result();
		if (esLLuvia){
			resultado.setMatch(true);
			resultado.setMessage(Result.CLIMA_LLUVIA);
		}else{
			resultado.setMatch(false);
			resultado.setMessage(Result.CLIMA_SOL);
		}
			
		return resultado;
	}

	public boolean excluirOtros() {
		return false;
	}

	public Result getFinalResult() {
		return null;
	}
}
