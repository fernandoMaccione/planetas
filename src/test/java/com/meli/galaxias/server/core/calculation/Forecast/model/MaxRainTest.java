package com.meli.galaxias.server.core.calculation.Forecast.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.meli.galaxias.server.core.exception.ForecastExecption;
import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.Point;
import com.meli.galaxias.server.core.solarSystem.SolarSystem;

public class MaxRainTest {
	@Test
	public void testCalculate() throws ForecastExecption{
		Planet x = new Planet("x", 1, 100);
		Planet z = new Planet("z", -5, 200);
		Planet y = new Planet("z", 10, 400);
		
		List<Planet> planets = new ArrayList<>();
		planets.add(x);
		planets.add(z);
		planets.add(y);
		SolarSystem ss = new SolarSystem("Via Lactea");
		ss.setPlanets(planets);
		
		Rain calcRain = new Rain();
		MaxRain maxRain = new MaxRain();

		ss.setSimlateDay(18);
		Result r= calcRain.execute(ss, 18, null);
		maxRain.execute(ss, 18, r);
		assertTrue(maxRain.maxPerimeter == 1193.003868681401);
		
		ss.setSimlateDay(135);
		r= calcRain.execute(ss, 135, null);
		maxRain.execute(ss, 135, r);
		assertTrue(maxRain.maxPerimeter == 1259.1854945581476);
		
		ss.setSimlateDay(19);
		r= calcRain.execute(ss, 19, null);
		maxRain.execute(ss, 19, r);
		assertTrue(maxRain.maxPerimeter == 1259.1854945581476);
		
	}
	@Test
	public void testDistance() throws ForecastExecption{
		MaxRain maxRain = new MaxRain();
		assertTrue(maxRain.distance(new Point(3,0), new Point(6,0)) == 3);		
		assertTrue(maxRain.distance(new Point(0,4.98), new Point(0,11.56)) == 6.58);
		assertTrue(maxRain.distance(new Point(0,4.98), new Point(10.56,11.56)) == 12.442266674525184);
	}
}
