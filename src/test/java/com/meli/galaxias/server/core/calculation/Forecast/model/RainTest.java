package com.meli.galaxias.server.core.calculation.Forecast.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.SolarSystem;

public class RainTest {
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
		
		Rain calc = new Rain();
		ss.setSimlateDay(2);
		Result r= calc.execute(ss, 2, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_SOL));

		ss.setSimlateDay(18);
		r= calc.execute(ss, 18, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_LLUVIA));
		
		ss.setSimlateDay(18);
		r= calc.execute(ss, 18, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_LLUVIA));
		
		ss.setSimlateDay(135);
		r= calc.execute(ss, 135, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_LLUVIA));
		
		ss.setSimlateDay(156);
		r= calc.execute(ss, 156, null);
		assertTrue(r.getMessage().equals(Result.CLIMA_SOL));
	}
}
