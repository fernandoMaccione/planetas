package com.meli.galaxias.web.model;

import com.google.gson.JsonObject;
import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.job.ServiceCalculation;
import com.meli.galaxias.server.core.job.model.SolarSytemProcess;

import spark.Request;
import spark.Response;

public class ForecastByDay implements Process {
	private ServiceCalculation service;
	
	public ForecastByDay(ServiceCalculation service){
		this.service = ServiceCalculation.getInstance();
	}
	
	@Override
	public Object get(Request req, Response res, JsonObject json) throws Exception {
		Integer dia = Integer.parseInt(req.params("dia")); 
		SolarSytemProcess galaxiaLejana = service.getSolarSystem(Config.GALAXIA_LEJANA);
		CalculationPredictionDTO prediction = galaxiaLejana.getByDay(Forecast.CODE, dia);
		json.addProperty("dia", dia);
		json.addProperty("clima", prediction.getResult());
		return null;
	}

	@Override
	public Object post(Request req, Response res, JsonObject json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Request req, Response res, JsonObject json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delete(Request req, Response res, JsonObject json) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
