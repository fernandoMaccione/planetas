package com.meli.galaxias.server.core.job;

import java.util.List;

import com.meli.galaxias.server.core.model.Planet;
import com.meli.galaxias.server.core.model.Sun;

public interface ICalculable {
	public Sun getSun();
	public List<Planet> getPlanets();
	public void setSimlateDay(double numberDay);
	public String getCode();
}
