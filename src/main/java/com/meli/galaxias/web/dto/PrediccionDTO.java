package com.meli.galaxias.web.dto;

import com.google.gson.annotations.SerializedName;

public class PrediccionDTO {
	@SerializedName("Prediccion")
	private String prediccion;
	@SerializedName("Resultado")
	private String value;
	public String getPrediccion() {
		return prediccion;
	}
	public void setPrediccion(String prediccion) {
		this.prediccion = prediccion;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
