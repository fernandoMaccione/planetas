package com.meli.galaxias.server.core.job.model;

import java.util.ArrayList;
import java.util.List;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.galaxiaLejana.GalaxiaLejana;

public class FactoryGalaxyCalculation {
	/*
	 * La idea es que en algun lado se relacionen las galaxias a las que se les necesita realizar algun tipo de analisis, 
	 * con los calculos disponibles.
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
		gc.setCalculo(calculations);
		colCG.add(gc);
		
		
		return colCG;
	}
}
