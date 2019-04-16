package com.meli.galaxias.web.model.resources;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.calculation.Forecast.model.Result;
import com.meli.galaxias.server.core.job.ServiceCalculation;
import com.meli.galaxias.server.core.job.model.SolarSytemProcess;
import com.meli.galaxias.web.dto.PrediccionDTO;
import com.meli.galaxias.web.model.Process;

import spark.Request;
import spark.Response;

public class ForecastResource implements Process{

	@Override
	public Object get(Request req, Response res, JsonObject json) throws Exception {
		ServiceCalculation service= ServiceCalculation.getInstance();
		SolarSytemProcess process = service.getSolarSystem(Config.GALAXIA_LEJANA);
		
		List<PrediccionDTO> lPrediccion = new ArrayList<PrediccionDTO>();
		
		PrediccionDTO p = new PrediccionDTO();
		p.setPrediccion("Cantidad de Periodos de Sequia: ");
		p.setValue(String.valueOf(process.countPeriod(Forecast.CODE, Result.CLIMA_SEQUIA)));
		lPrediccion.add(p);
		
		p = new PrediccionDTO();
		p.setPrediccion("Cantidad de Periodos de Lluvia: ");
		p.setValue(String.valueOf(process.countPeriod(Forecast.CODE, Result.CLIMA_LLUVIA)));
		lPrediccion.add(p);
		
		p = new PrediccionDTO();
		p.setPrediccion("Dia de pico maximo de lluvia: ");
        CalculationPredictionDTO picoMaximo = process.getOnePrediction(Forecast.CODE, Result.CLIMA_LLUVIA_INTENSA);
		p.setValue(String.valueOf(picoMaximo.getDay()));
		lPrediccion.add(p);
		
		p = new PrediccionDTO();
		p.setPrediccion("Cantidad de Periodos de condiciones optimas: ");
		p.setValue(String.valueOf(process.countPeriod(Forecast.CODE, Result.CLIMA_OPTIMO)));
		lPrediccion.add(p);
        
        for (CalculationPredictionDTO result:process.getResult(Forecast.CODE)){
        	p = new PrediccionDTO();
        	p.setPrediccion("Dia " + String.valueOf(result.getDay()) + " al dia "+ String.valueOf(result.getLastDay()));
        	p.setValue(result.getResult());
        	lPrediccion.add(p);
        }
        
		return lPrediccion;
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
