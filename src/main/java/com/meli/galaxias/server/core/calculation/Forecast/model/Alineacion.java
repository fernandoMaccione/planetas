package com.meli.galaxias.server.core.calculation.Forecast.model;

import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.model.CelestialBody;

public class Alineacion implements ICalculoForecast {


	public Result execute(ICalculable galaxi, long day, Result anterior) {
		boolean alineados = false;
		Result resultado = new Result();
		for (int i = 0; i < galaxi.getPlanets().size() - 2; i++){
			alineados = calculoRecta (galaxi.getPlanets().get(i), galaxi.getPlanets().get(i + 1),galaxi.getPlanets().get(i + 2));
		}
		if (alineados){
			resultado.setMatch(true);
			boolean conElSol = calculoRecta (galaxi.getSun(), galaxi.getPlanets().get(0),galaxi.getPlanets().get(1));
			if (conElSol){
				resultado.setMessage("Clima Optimo");
			}else{
				resultado.setMessage("Sequia");
			}
		}
		return resultado;
	}

	private boolean calculoRecta (CelestialBody c1, CelestialBody c2, CelestialBody c3){
		double proporcionX = (c2.getPosition().getX() - c1.getPosition().getX()) / (c3.getPosition().getX() - c2.getPosition().getX());
		double proporcionY = (c2.getPosition().getY() - c1.getPosition().getY()) / (c3.getPosition().getY() - c2.getPosition().getY());
		System.out.println("Eje X: " + String.valueOf(proporcionX) + " Eje Y: "+ String.valueOf(proporcionY));
		return proporcionX == proporcionY;
	}

	public boolean excluirOtros() {

		return true; //Si en este calculo se detectan que estan alineados, no tiene sentido realizar los demas.
	}

	public Result getFinalResult() {

		return null;
	}

}
