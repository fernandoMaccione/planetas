package com.meli.galaxias.server.core.service.model;

import java.util.ArrayList;
import java.util.List;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.galaxiaLejana.GalaxiaLejana;

public class FactoryGalaxyCalculation {
	/*
	 * La idea es que en otra version, los procesos se persistan en algun lado y que esta clase me devuelva el proceso vigente. Es decir,
	 * ahora se esta calculando del dia 0 a 10 años, pero tranquilamente bien se debería de poder dar de alta un nuevo proceso en algún lado,
	 * que predisca otro periodo ejemplo, del año 10 al año 20.
	 * 
	 * POr ahora esto se encarga de construirme un proceso para calcular el Forecast en la "Galaxia lejana" del ejercicio.
	 */
	public static List<SolarSytemProcess> calculationRegistred(){
		//dummy
		List<SolarSytemProcess> colCG = new ArrayList<SolarSytemProcess>();
		
		SolarSytemProcess gc = new SolarSytemProcess();
		gc.setFirtDay(Config.FIRTS_DAY);
		gc.setLastDay(Config.LAST_DAY);
		ISolarSystem galaxy = new GalaxiaLejana();
		gc.setGalaxy(galaxy);
		
		List<ICalculate> calculations = new ArrayList<ICalculate>();
		calculations.add(new Forecast());
		gc.setCalculate(calculations);
		colCG.add(gc);
		
		
		return colCG;
	}
}
