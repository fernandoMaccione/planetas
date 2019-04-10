package com.meli.galaxias.server.core.job.model;

import java.util.ArrayList;
import java.util.List;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.job.ICalculo;
import com.meli.galaxias.server.galaxiaLejana.GalaxiaLejana;

public class FactoryGalaxyCalculation {
	/*
	 * La idea es que en algun lado se relacionen las galaxias a las que se les necesita realizar algun tipo de analisis, 
	 * con los calculos disponibles.
	 */
	public static List<GalaxyCalculation> calculationRegistred(){
		//dummy
		List<GalaxyCalculation> colCG = new ArrayList<GalaxyCalculation>();
		
		GalaxyCalculation gc = new GalaxyCalculation();
		gc.setFirtDay(Config.FIRTS_DAY);
		gc.setLastDay(Config.LAST_DAY);
		ICalculable galaxy = new GalaxiaLejana();
		gc.setGalaxy(galaxy);
		
		List<ICalculo> calculations = new ArrayList<ICalculo>();
		calculations.add(new Forecast());
		colCG.add(gc);
		
		
		return colCG;
	}
}
