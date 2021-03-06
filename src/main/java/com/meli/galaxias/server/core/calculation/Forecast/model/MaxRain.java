package com.meli.galaxias.server.core.calculation.Forecast.model;

import java.util.List;

import com.meli.galaxias.server.core.exception.ForecastExecption;
import com.meli.galaxias.server.core.exception.MaxRainExecption;
import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.Point;
import com.meli.galaxias.server.core.service.model.ISolarSystem;

public class MaxRain implements ICalculateForecast{
	double maxPerimeter;
	long day;
	
	public MaxRain(){
		maxPerimeter = 0;
		day = 0;
	}
	
	public Result execute(ISolarSystem galaxi, long day, Result anterior) throws ForecastExecption {
		
		if (anterior.isMatch()){//este calculo requiere que el calculo anterior que se ejecuta sea PeriodoLuvia
			if (galaxi.getPlanets().size()<3)
				throw new MaxRainExecption("Do not execute this calculator with minus three planet.");
			double perimeter=0;
			List<Planet> planetas = galaxi.getPlanets();
			for (int i = 0; i< planetas.size() - 1; i++){
				perimeter = perimeter + distance(planetas.get(i).getPosition(), planetas.get(i+1).getPosition());
			}
			//calculo la distancia entre el primer y ultimo planeta
			perimeter = perimeter + distance(planetas.get(0).getPosition(), planetas.get(planetas.size()-1).getPosition());
			if (perimeter > maxPerimeter){
				maxPerimeter = perimeter;
				this.day = day;
			}
		}
		
		return null;
	}

	public boolean excludeOther() {
		return false;
	}
	
	
	
	protected double distance (Point p1, Point p2){
		double cuadradoX = Math.pow(p2.getX() - p1.getX(),2);
		double cuadradoY = Math.pow(p2.getY() - p1.getY(),2);
		return Math.sqrt(cuadradoX + cuadradoY);
	}

	public Result getFinalResult() {
		Result result = new Result();
		result.setMatch(true);
		result.setDay(day);
		result.setMessage(Result.CLIMA_LLUVIA_INTENSA);
		return result;
	}

}
