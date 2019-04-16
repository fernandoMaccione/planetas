package com.meli.galaxias.server.core.job.model;

import java.util.List;

import com.meli.galaxias.server.core.model.Planet;
import com.meli.galaxias.server.core.model.Sun;

public interface ISolarSystem {
	public Sun getSun();
	public List<Planet> getPlanets();
	public void setSimlateDay(double numberDay);
	public String getCode();
}
