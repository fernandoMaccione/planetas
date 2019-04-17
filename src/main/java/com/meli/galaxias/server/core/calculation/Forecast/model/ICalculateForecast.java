package com.meli.galaxias.server.core.calculation.Forecast.model;

import com.meli.galaxias.server.core.exception.ForecastExecption;
import com.meli.galaxias.server.core.service.model.ISolarSystem;

public interface ICalculateForecast {
	public Result execute (ISolarSystem galaxi, long day, Result anterior) throws ForecastExecption;
	public boolean excludeOther();
	public Result getFinalResult();
}
