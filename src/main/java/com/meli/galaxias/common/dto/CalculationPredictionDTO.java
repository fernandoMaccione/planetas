package com.meli.galaxias.common.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CalculationPredictionDTO {
	@Id
	@GeneratedValue
	private Long id;
	private String codeCalculate;
	private String codeGalaxy;
	private long idProcess;
	private long day;
	private long lastDay;
	private String result;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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
