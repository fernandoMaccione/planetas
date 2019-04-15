package com.meli.galaxias.server.core.job;

import java.util.List;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;

public interface ICalculo {
	public CalculationPredictionDTO execute(ISolarSystem galaxy, int day);
	public String getCode ();
	public List<CalculationPredictionDTO> getFinalResult(ISolarSystem galaxy);
}