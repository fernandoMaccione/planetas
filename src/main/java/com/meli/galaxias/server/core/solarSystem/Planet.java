package com.meli.galaxias.server.core.solarSystem;

public class Planet extends CelestialBody{

	private double gredeesPerDay;
	private double radio;

	public Planet (){
		
	}
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

	public void moveToDay(double numberDay) {		
		double gredees = (gredeesPerDay * numberDay) % 360;
	    if (gredeesPerDay < 0) {
	    	gredees = 360 + gredees;
	    }
	    double radian = Math.toRadians(gredees);

	    double y = Math.round(Math.cos(radian) * radio*1000000000000d)/1000000000000d;	
	    double x = Math.round(Math.sin(radian) * radio*1000000000000d)/1000000000000d;

		getPosition().setLocation(x, y);
	}	
}
