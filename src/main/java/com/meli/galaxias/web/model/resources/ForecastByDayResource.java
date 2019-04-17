package com.meli.galaxias.web.model.resources;

import com.google.gson.JsonObject;
import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.service.ServiceCalculation;
import com.meli.galaxias.server.core.service.model.SolarSytemProcess;
import com.meli.galaxias.web.dto.ForecastByDayDTO;
import com.meli.galaxias.web.model.Process;

import spark.Request;
import spark.Response;

public class ForecastByDayResource implements Process {
	public ForecastByDayResource(){
		
	}
	
	@Override
	public Object get(Request req, Response res, JsonObject json) throws Exception {
		ServiceCalculation service = ServiceCalculation.getInstance();
		Integer day = Integer.parseInt(req.queryParams("dia")); 
		SolarSytemProcess galaxiaLejana = service.getSolarSystem(Config.GALAXIA_LEJANA);
		CalculationPredictionDTO prediction = galaxiaLejana.getByDay(Forecast.CODE, day);
		ForecastByDayDTO response = new ForecastByDayDTO();
		response.setDay(day);
		response.setForecast(prediction.getResult());
		return response;
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
