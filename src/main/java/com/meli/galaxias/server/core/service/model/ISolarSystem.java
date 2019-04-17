package com.meli.galaxias.server.core.service.model;

import java.util.List;

import com.meli.galaxias.server.core.solarSystem.Planet;
import com.meli.galaxias.server.core.solarSystem.Sun;

public interface ISolarSystem {
	public Sun getSun();
	public List<Planet> getPlanets();
	public void setSimlateDay(double numberDay);
	public String getCode();
}
