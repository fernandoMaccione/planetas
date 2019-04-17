package com.meli.galaxias.server.core.calculation.Forecast.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.SolarSystem;

public class AlinedTest {
	@Test
	public void testCalculate(){
		Planet x = new Planet("x", 1, 100);
		Planet z = new Planet("z", -5, 200);
		Planet y = new Planet("z", 10, 400);
		
		List<Planet> planets = new ArrayList<>();
		planets.add(x);
		planets.add(z);
		planets.add(y);
		SolarSystem ss = new SolarSystem("Via Lactea");
		ss.setPlanets(planets);
		
		Aligned calc = new Aligned();
		ss.setSimlateDay(0);
		Result r= calc.execute(ss, 9, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_OPTIMO));
		
		ss.setSimlateDay(21);
		r= calc.execute(ss, 21, null);
		assertTrue(!r.isMatch());
		
		ss.setSimlateDay(360);
		r= calc.execute(ss, 360, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_OPTIMO));
		
		ss.setSimlateDay(630);
		r= calc.execute(ss, 630, null);
		assertTrue(!r.isMatch());
		
	}
}
