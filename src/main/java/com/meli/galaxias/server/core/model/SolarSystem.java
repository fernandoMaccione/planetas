package com.meli.galaxias.server.core.model;

import java.util.HashMap;

import com.meli.galaxias.server.core.job.ICalculable;

public  class SolarSystem implements ICalculable{
	private String name;
	private Sun sun;
	protected HashMap<String, Planet> planets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Planet> getPlanets() {
		return planets;
	}
	public void setPlanets(HashMap<String, Planet> planets) {
		this.planets = planets;
	}

	protected SolarSystem (String name){
		this.name = name;
		sun = new Sun();
	}
	public Sun getSun() {
		return sun;
	}
	public void setSimlateDay(long numberDay) {
		for (Planet p:planets.values()){
			p.setDay(numberDay);
		}
		
	}
}
