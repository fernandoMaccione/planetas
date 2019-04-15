package com.meli.galaxias.common.dto;

public class CalculationPredictionDTO {
	private String codeCalculate;
	private String codeGalaxy;
	private long idProcess;
	private long day;
	private long lastDay;
	private String result;
	
	public long getIdProcess() {
		return idProcess;
	}
	public void setIdProcess(long idProcess) {
		this.idProcess = idProcess;
	}
	public String getCodeCalculate() {
		return codeCalculate;
	}
	public void setCodeCalculate(String codeCalculate) {
		this.codeCalculate = codeCalculate;
	}
	public String getCodeGalaxy() {
		return codeGalaxy;
	}
	public void setCodeGalaxy(String codeGalaxy) {
		this.codeGalaxy = codeGalaxy;
	}
	public long getDay() {
		return day;
	}
	public void setDay(long firstDay) {
		this.day = firstDay;
	}
	public long getLastDay() {
		return lastDay;
	}
	public void setLastDay(long lastDay) {
		this.lastDay = lastDay;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
