package com.meli.galaxias.server.core.calculation.Forecast.model;

import java.awt.Point;
import java.util.List;

import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.model.Planet;

public class MaximaLluvia implements ICalculoForecast{
	double perimetroMaximo;
	long day;
	
	public MaximaLluvia(){
		perimetroMaximo = 0;
		day = 0;
	}
	
	public Result execute(ICalculable galaxi, long day, Result anterior) {
		
		if (anterior.isMatch()){//este calculo requiere que el calculo anterior que se ejecuta sea PeriodoLuvia
			double perimetro=0;
			List<Planet> planetas = galaxi.getPlanets();
			for (int i = 0; i< planetas.size() - 1; i++){
				perimetro = perimetro + distancia(planetas.get(i).getPosition(), planetas.get(i+1).getPosition());
			}
			//calculo la distancia entre el primer y ultimo planeta
			perimetro = perimetro + distancia(planetas.get(0).getPosition(), planetas.get(planetas.size()-1).getPosition());
			if (perimetro > perimetroMaximo){
				perimetroMaximo = perimetro;
				this.day = day;
			}
		}
		
		return null;
	}

	public boolean excluirOtros() {
		return false;
	}
	
	
	
	private double distancia (Point p1, Point p2){
		double cuadradoX = Math.pow(p2.getX() - p1.getX(),2);
		double cuadradoY = Math.pow(p2.getY() - p1.getY(),2);
		return Math.sqrt(cuadradoX + cuadradoY);
	}

	public Result getFinalResult() {
		Result resultado = new Result();
		resultado.setMatch(true);
		resultado.setDay(day);
		resultado.setMessage("Maxima Lluvia" + String.valueOf(perimetroMaximo));
		return resultado;
	}

}
