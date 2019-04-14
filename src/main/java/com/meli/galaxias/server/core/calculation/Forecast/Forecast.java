package com.meli.galaxias.server.core.calculation.Forecast;

import java.util.ArrayList;
import java.util.List;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.model.Alineacion;
import com.meli.galaxias.server.core.calculation.Forecast.model.ICalculoForecast;
import com.meli.galaxias.server.core.calculation.Forecast.model.MaximaLluvia;
import com.meli.galaxias.server.core.calculation.Forecast.model.PeriodoLluvia;
import com.meli.galaxias.server.core.calculation.Forecast.model.Result;
import com.meli.galaxias.server.core.job.ICalculable;
import com.meli.galaxias.server.core.job.ICalculo;

public class Forecast implements ICalculo {
	private List<ICalculoForecast> calculos;
	
	public Forecast(){
		registryCalculos();
	}
	
	public CalculationPredictionDTO execute(ICalculable galaxy, int day) {
		galaxy.setSimlateDay(day);
		
		Result result= null; 
		for (ICalculoForecast calculo:calculos){
			Result aux = calculo.execute(galaxy, day, result);
			if (aux != null)
				result = aux;
			if (result.isMatch() && calculo.excluirOtros()){ //
				break;
			}
		}
		
		CalculationPredictionDTO dto = new CalculationPredictionDTO();
		dto.setCodeCalculate(this.getCode());
		dto.setCodeGalaxy(galaxy.getCode());
		dto.setDay(day);
		dto.setResult(result.getMessage());
		
		return dto;
	}

	private void registryCalculos() {
		calculos = new ArrayList<ICalculoForecast>();
		calculos.add(new Alineacion());
		calculos.add(new PeriodoLluvia());
		calculos.add(new MaximaLluvia());
	}

	public String getCode() {
		return "FORECAST";
	}

	public List<CalculationPredictionDTO> getFinalResult(ICalculable galaxy) {
		List<CalculationPredictionDTO> resultados = new ArrayList<CalculationPredictionDTO>();
		for (ICalculoForecast calculo:calculos){
			Result r = calculo.getFinalResult();
			if (r != null){
				CalculationPredictionDTO dto = new CalculationPredictionDTO();
				dto.setDay(r.getDay());
				dto.setCodeCalculate(this.getCode());
				dto.setCodeGalaxy(galaxy.getCode());
				dto.setResult(r.getMessage());
				resultados.add(dto);
			}
		}
		return resultados;
	}

}
