package com.meli.galaxias.server.core.solarSystem;

import java.util.List;

import com.meli.galaxias.server.core.service.model.ISolarSystem;

public  class SolarSystem implements ISolarSystem{
	private String name;
	private Sun sun;
	protected List<Planet> planets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	protected SolarSystem (String name){
		this.name = name;
		sun = new Sun();
	}
	public Sun getSun() {
		return sun;
	}
	public void setSimlateDay(double numberDay) {
		for (Planet p:planets){
			p.moveToDay(numberDay);
		}
		
	}
	public String getCode() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
