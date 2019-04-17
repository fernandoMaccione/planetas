package com.meli.galaxias.server.core.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.calculation.Forecast.model.Result;
import com.meli.galaxias.server.core.exception.ServiceException;
import com.meli.galaxias.server.core.service.model.SolarSytemProcess;

public class ServiceCalculationTest {
	
	
	@Test
	public void getInstanceTest() throws ServiceException{
		ServiceCalculation service = ServiceCalculation.getInstance();
		
		assertTrue(service != null);
		
		/*Testeo los resultados del ejercio*/
		
		SolarSytemProcess process = service.getSolarSystem(Config.GALAXIA_LEJANA);
		assertTrue(process.countPeriod(Forecast.CODE, Result.CLIMA_LLUVIA).intValue() == 142);
		assertTrue(process.getOnePrediction(Forecast.CODE, Result.CLIMA_LLUVIA_INTENSA).getDay() == 2265);
		assertTrue(process.countPeriod(Forecast.CODE, Result.CLIMA_OPTIMO).intValue() == 61);
		assertTrue(process.countPeriod(Forecast.CODE, Result.CLIMA_SEQUIA).intValue() == 223);		
	}
}
