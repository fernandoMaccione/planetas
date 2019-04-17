package com.meli.galaxias.web.dto;

import com.google.gson.annotations.SerializedName;

public class ForecastByDayDTO {
	@SerializedName("dia")
	private int day ;
	@SerializedName("clima")
	private String forecast; 
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

}
