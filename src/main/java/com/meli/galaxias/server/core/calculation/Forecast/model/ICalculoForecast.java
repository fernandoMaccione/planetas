package com.meli.galaxias.server.core.calculation.Forecast.model;

import com.meli.galaxias.server.core.job.ICalculable;

public interface ICalculoForecast {
	public Result execute (ICalculable galaxi, long day, Result anterior);
	public boolean excluirOtros();
	public Result getFinalResult();
}
