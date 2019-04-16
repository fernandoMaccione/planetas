package com.meli.galaxias.web;
import static spark.Spark.get;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.meli.galaxias.server.core.exception.NotFoundException;
import com.meli.galaxias.web.model.Process;
import com.meli.galaxias.web.model.resources.ForecastByDayResource;
import com.meli.galaxias.web.model.resources.ForecastResource;

import spark.Request;
import spark.Response;

public class Api {
	public static void registerServer(){
		get("/clima", (req, res) -> procesarGet(req, res, new ForecastByDayResource()));
		get("/predicciones", (req, res) -> procesarGet(req, res, new ForecastResource()));
	}
	
	private static Object procesarGet(Request req, Response res, Process proceso){
	//	LogTimeMethod logMethod = new LogTimeMethod();
		try {
			JsonObject json = new JsonObject();
			String errores = "";
			try{			
				
				Object r = proceso.get(req, res, json);
				Gson oGson = new Gson();
				json.add("Respuesta", oGson.toJsonTree(r));
	            res.status(200);
	            res.type("application/json");
			}catch (NotFoundException e) {
	            res.status(404);
	            res.type("application/json");
				errores = e.getLocalizedMessage();
				json.addProperty("error", errores);
				//LogSRV.Log(ex, LogCTE.LEVEL_TRACE);
			
			}catch (Exception e) {
	            res.status(500);
	            res.type("application/json");
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
