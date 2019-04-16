package com.meli.galaxias.server.core.calculation.Forecast;

import java.util.ArrayList;
import java.util.List;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.model.Aligned;
import com.meli.galaxias.server.core.calculation.Forecast.model.ICalculateForecast;
import com.meli.galaxias.server.core.calculation.Forecast.model.MaxRain;
import com.meli.galaxias.server.core.calculation.Forecast.model.Rain;
import com.meli.galaxias.server.core.calculation.Forecast.model.Result;
import com.meli.galaxias.server.core.exception.ForecastExecption;
import com.meli.galaxias.server.core.job.model.ICalculate;
import com.meli.galaxias.server.core.job.model.ISolarSystem;

public class Forecast implements ICalculate {
	public static final String CODE = "FORECAST";
	
	private List<ICalculateForecast> calculos;
	public Forecast(){
		registryCalculos();
	}
	
	public CalculationPredictionDTO execute(ISolarSystem galaxy, int day) throws ForecastExecption {
		
		Result result= null;
		boolean calculado = false;
		double precicion = (1/ (double)Config.PRECICION_CALCULE);
		for (double i = day; i<day+.95; i = i + precicion){
			galaxy.setSimlateDay(i);
			for (ICalculateForecast calculo:calculos){
				Result aux = calculo.execute(galaxy, day, result);
				if (aux != null)
					result = aux;
				if (result.isMatch() && calculo.excluirOtros()){ 
					calculado = true;
					break;
				}
			}
			if (calculado)
				break;
		}
		
		CalculationPredictionDTO dto = new CalculationPredictionDTO();
		dto.setCodeCalculate(this.getCode());
		dto.setCodeGalaxy(galaxy.getCode());
		dto.setDay(day);
		dto.setResult(result.getMessage());
		
		return dto;
	}

	private void registryCalculos() {
		calculos = new ArrayList<ICalculateForecast>();
		calculos.add(new Aligned());
		calculos.add(new Rain());
		calculos.add(new MaxRain());
	}

	public String getCode() {
		return CODE;
	}

	public List<CalculationPredictionDTO> getFinalResult(ISolarSystem galaxy) {
		List<CalculationPredictionDTO> resultados = new ArrayList<CalculationPredictionDTO>();
		for (ICalculateForecast calculo:calculos){
			Result r = calculo.getFinalResult();
			if (r != null){
				CalculationPredictionDTO dto = new CalculationPredictionDTO();
				dto.setDay(r.getDay());
				dto.setCodeCalculate(this.getCode());
				dto.setCodeGalaxy(galaxy.getCode());
				dto.setResult(r.getMessage());
				resultados.add(dto);
			}
		}
		return resultados;
	}

}
