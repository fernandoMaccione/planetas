package com.meli.galaxias.server.core.job;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;

public interface ICalculo {
	public CalculationPredictionDTO execute(ICalculable galaxy, int i);
	public String getCode ();
}
