package com.meli.galaxias.server.core.solarSystem;

import static org.junit.Assert.*;

import org.junit.Test;


public class PlanetTest {
	@Test
	public void testPosition(){
		Planet pX = new Planet();
		pX.setGredeesPerDay(1);
		pX.setRadio(100);
		
		pX.moveToDay(0); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == 100);
		
		pX.moveToDay(90); 
		assertTrue(pX.getPosition().getX() == 100);
		assertTrue(pX.getPosition().getY() == 0);
		
		pX.moveToDay(180); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == -100);
		
		pX.moveToDay(360); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == 100);
	
		
		pX.moveToDay(45);
		assertTrue(pX.getPosition().getX() == 70.710678118655);
		assertTrue(pX.getPosition().getY() == 70.710678118655);
		
		pX.moveToDay(160); 
		assertTrue(pX.getPosition().getX() == 34.202014332567);
		assertTrue(pX.getPosition().getY() == -93.969262078591);
	}
	
	@Test
	public void testNegatePosition(){
		Planet pX = new Planet();
		pX.setGredeesPerDay(-5);
		pX.setRadio(100);
		
		pX.moveToDay(0); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == 100);
		
		pX.moveToDay(90); 
		assertTrue(pX.getPosition().getX() == -100);
		assertTrue(pX.getPosition().getY() == 0);
		
		pX.moveToDay(180); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == -100);
		
		pX.moveToDay(360); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == 100);
			
		pX.moveToDay(45);
		assertTrue(pX.getPosition().getX() == 70.710678118655);
		assertTrue(pX.getPosition().getY() == -70.710678118655);
		
		pX.moveToDay(160); 
		assertTrue(pX.getPosition().getX() == -98.480775301221);
		assertTrue(pX.getPosition().getY() == 17.364817766693);
	}
}
