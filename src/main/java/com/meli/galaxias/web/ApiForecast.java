package com.meli.galaxias.web;
import static spark.Spark.get;

import com.google.gson.JsonObject;
import com.meli.galaxias.server.core.job.ServiceCalculation;
import com.meli.galaxias.web.model.ForecastByDay;
import com.meli.galaxias.web.model.Process;

import spark.Request;
import spark.Response;

public class ApiForecast {
	public static void registerServer(ServiceCalculation task){
		get("/clima/:dia", (req, res) -> procesarGet(req, res, new ForecastByDay(null)));
		
	}
	
	private static Object procesarGet(Request req, Response res, Process proceso){
	//	LogTimeMethod logMethod = new LogTimeMethod();
		try {
			JsonObject json = new JsonObject();
			String errores = "";
			try{			
				proceso.get(req, res, json);
				
			
			}catch (Exception e) {
				//EntidadException ex = new EntidadException(e.getMessage(),e);
				errores = e.getLocalizedMessage();
				json.addProperty("error", errores);
				//LogSRV.Log(ex, LogCTE.LEVEL_TRACE);
			}
			
			return json.toString();
		} finally {
			//logMethod.finish();
		}
	}
}
