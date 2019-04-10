package com.meli.galaxias.server.core.job.model;

import java.util.List;

import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.job.ICalculo;

public class GalaxyCalculation {
	private ICalculable galaxy;
	private List<ICalculo> calculo;
	private int firtDay;
	private int lastDay;
	public int getFirtDay() {
		return firtDay;
	}
	public void setFirtDay(int firtDay) {
		this.firtDay = firtDay;
	}
	public int getLastDay() {
		return lastDay;
	}
	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}
	public ICalculable getGalaxy() {
		return galaxy;
	}
	public void setGalaxy(ICalculable galaxy) {
		this.galaxy = galaxy;
	}
	public List<ICalculo> getCalculo() {
		return calculo;
	}
	public void setCalculo(List<ICalculo> calculo) {
		this.calculo = calculo;
	}
}
