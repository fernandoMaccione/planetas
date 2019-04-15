package com.meli.galaxias.server.core.model;

public abstract class Planet extends CelestialBody{

	private double gredeesPerDay;
	private double radio;

	public Planet(String code, int gredees, int radio){
		super(code);
		this.gredeesPerDay = gredees;
		this.radio = radio;
	}
	
	public double getGredeesPerDay() {
		return gredeesPerDay;
	}
	public void setGredeesPerDay(double gredeesPerDay) {
		this.gredeesPerDay = gredeesPerDay;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}

	public void setDay(double numberDay) {		
		double gredees = gredeesPerDay * numberDay;
		double x = Math.sin(gredees) * radio;
		double y = Math.cos(gredees) * radio;
		getPosition().setLocation(x, y);
	}	
}
