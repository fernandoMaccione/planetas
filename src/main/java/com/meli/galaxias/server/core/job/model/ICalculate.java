package com.meli.galaxias.server.core.job.model;

import java.util.List;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.exception.ServiceException;

public interface ICalculate {
	public CalculationPredictionDTO execute(ISolarSystem galaxy, int day) throws ServiceException;
	public String getCode ();
	public List<CalculationPredictionDTO> getFinalResult(ISolarSystem galaxy);
}