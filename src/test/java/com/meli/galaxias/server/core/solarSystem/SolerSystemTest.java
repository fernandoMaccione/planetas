package com.meli.galaxias.server.core.solarSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class SolerSystemTest {
	@Test
	public void testPosition(){
		Planet x = new Planet("x", 1, 100);
		Planet z = new Planet("z", -5, 100);
		
		List<Planet> planets = new ArrayList<>();
		planets.add(x);
		planets.add(z);
		SolarSystem ss = new SolarSystem("Via Lactea");
		ss.setPlanets(planets);
		
		ss.setSimlateDay(0);
		assertTrue(x.getPosition().getX() == 0);
		assertTrue(x.getPosition().getY() == 100);
		
		assertTrue(z.getPosition().getX() == 0);
		assertTrue(z.getPosition().getY() == 100);
		
		ss.setSimlateDay(90); 
		assertTrue(x.getPosition().getX() == 100);
		assertTrue(x.getPosition().getY() == 0);
		
		assertTrue(z.getPosition().getX() == -100);
		assertTrue(z.getPosition().getY() == 0);
		
		ss.setSimlateDay(45); 
		assertTrue(x.getPosition().getX() == 70.710678118655);
		assertTrue(x.getPosition().getY() == 70.710678118655);
		assertTrue(z.getPosition().getX() == 70.710678118655);
		assertTrue(z.getPosition().getY() == -70.710678118655);
		
		ss.setSimlateDay(160); 
		assertTrue(x.getPosition().getX() == 34.202014332567);
		assertTrue(x.getPosition().getY() == -93.969262078591);
		assertTrue(z.getPosition().getX() == -98.480775301221);
		assertTrue(z.getPosition().getY() == 17.364817766693);
		
		
	}
}
