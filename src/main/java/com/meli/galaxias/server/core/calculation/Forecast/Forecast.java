package com.meli.galaxias.server.core.calculation.Forecast;

import java.util.List;

import com.meli.galaxias.server.core.calculation.Forecast.model.ICalculoForecast;
import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.job.ICalculo;

public class Forecast implements ICalculo {

	public void execute(ICalculable galaxy, int i) {
		galaxy.setSimlateDay(i);
		List<ICalculoForecast> calculos = getRegistryCalculos();
		
	}

	private List<ICalculoForecast> getRegistryCalculos() {

		return null;
	}

}
