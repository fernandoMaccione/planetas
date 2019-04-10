package com.meli.galaxias.server.core.job;

import java.util.HashMap;

import com.meli.galaxias.server.core.model.Planet;
import com.meli.galaxias.server.core.model.Sun;

public interface ICalculable {
	public Sun getSun();
	public HashMap<String, Planet> getPlanets();
	public void setSimlateDay(long numberDay);
}
