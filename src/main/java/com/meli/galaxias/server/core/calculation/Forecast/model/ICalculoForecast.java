package com.meli.galaxias.server.core.calculation.Forecast.model;

import com.meli.galaxias.server.core.job.ISolarSystem;

public interface ICalculoForecast {
	public Result execute (ISolarSystem galaxi, long day, Result anterior);
	public boolean excluirOtros();
	public Result getFinalResult();
}
