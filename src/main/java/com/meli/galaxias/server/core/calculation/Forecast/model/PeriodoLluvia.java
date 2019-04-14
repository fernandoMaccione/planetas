package com.meli.galaxias.server.core.calculation.Forecast.model;

import java.awt.Point;
import java.awt.Polygon;

import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.model.Planet;

public class PeriodoLluvia implements ICalculoForecast {

	public Result execute(ICalculable galaxi, long day, Result anterior) {
		Polygon poligono = new Polygon();
		for (Planet planeta:galaxi.getPlanets()){
			Point punto = planeta.getPosition();
			poligono.addPoint((int)punto.getX(), (int)punto.getY());
		}
		
		boolean esLLuvia = poligono.contains(galaxi.getSun().getPosition());
		
		Result resultado = new Result();
		if (esLLuvia){
			resultado.setMatch(true);
			resultado.setMessage("Periodo de lluvia");
		}else{
			resultado.setMatch(false);
			resultado.setMessage("No hay lluvia");
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
