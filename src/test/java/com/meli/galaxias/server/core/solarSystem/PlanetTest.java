package com.meli.galaxias.server.core.solarSystem;

import static org.junit.Assert.*;

import org.junit.Test;


public class PlanetTest {
	@Test
	public void testPosition(){
		Planet pX = new Planet();
		pX.setGredeesPerDay(-1);
		pX.setRadio(2000);
		
		pX.moveToDay(0); 
		assertTrue(pX.getPosition().getX() == 0);
		assertTrue(pX.getPosition().getY() == 2000);
		
		pX.moveToDay(0); 
		System.out.println(pX.getPosition().getX());
		System.out.println(pX.getPosition().getY());
		
		assertTrue(pX.getPosition().getX() == 100);
		System.out.println(pX.getPosition().getY());
		assertTrue(pX.getPosition().getY() == 0);
	}
}
