package com.meli.galaxias.server.core.calculation.Forecast.model;

public class Result {
	private boolean match;
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
}
