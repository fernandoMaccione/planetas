package com.meli.galaxias.server.core.calculation.Forecast;

import java.util.List;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.model.ICalculoForecast;
import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.job.ICalculo;

public class Forecast implements ICalculo {

	public CalculationPredictionDTO execute(ICalculable galaxy, int i) {
		List<ICalculoForecast> calculos = getRegistryCalculos();
		
		
		return null;
	}

	private List<ICalculoForecast> getRegistryCalculos() {

		return null;
	}

	public String getCode() {
		return "FORECAST";
	}

}
