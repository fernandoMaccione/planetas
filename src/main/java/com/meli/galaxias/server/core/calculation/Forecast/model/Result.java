package com.meli.galaxias.server.core.calculation.Forecast.model;

public class Result {
	public static final String CLIMA_SEQUIA = "Sequia";
	public static final String CLIMA_OPTIMO = "Optimo";
	public static final String CLIMA_LLUVIA_INTENSA = "Lluvia Intensa";
	public static final String CLIMA_LLUVIA = "Lluvia";
	public static final String CLIMA_SOL = "No Lluvia";
	
	private boolean match;
	private long day;
	private String message;
	public boolean isMatch() {
		return match;
	}
	public void setMatch(boolean match) {
		this.match = match;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getDay() {
		return day;
	}
	public void setDay(long day) {
		this.day = day;
	}
	
}
