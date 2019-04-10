package com.meli.galaxias.server.core.model;

import java.awt.Point;

public class CelestialBody {
	private String code;
	private Point position;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point point) {
		this.position = point;
	}
	
	protected CelestialBody (String code){
		this.code = code;
	}
}
