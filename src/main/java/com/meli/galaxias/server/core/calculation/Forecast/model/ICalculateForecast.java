package com.meli.galaxias.server.core.calculation.Forecast.model;

import com.meli.galaxias.server.core.exception.ForecastExecption;
import com.meli.galaxias.server.core.job.model.ISolarSystem;

public interface ICalculateForecast {
	public Result execute (ISolarSystem galaxi, long day, Result anterior) throws ForecastExecption;
	public boolean excluirOtros();
	public Result getFinalResult();
}
