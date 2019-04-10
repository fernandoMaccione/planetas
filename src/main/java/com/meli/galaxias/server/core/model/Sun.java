package com.meli.galaxias.server.core.model;

import java.awt.Point;

public class Sun extends CelestialBody{
	
	public Sun() {
		super("Sun");
		this.setPosition(new Point(0, 0));
	}
}
