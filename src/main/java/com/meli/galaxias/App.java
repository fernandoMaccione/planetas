package com.meli.galaxias;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.calculation.Forecast.model.Result;
import com.meli.galaxias.server.core.job.ServiceCalculation;
import com.meli.galaxias.server.core.job.model.SolarSytemProcess;
import com.meli.galaxias.web.ApiForecast;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Iniciando proceso..." );
        ServiceCalculation task = ServiceCalculation.getInstance();
        System.out.println( "Proceso ya iniciado..." );
        SolarSytemProcess process = task.getSolarSystem(Config.GALAXIA_LEJANA);

        for (CalculationPredictionDTO result:process.getResult(Forecast.CODE)){
        	System.out.println("del dia: " + String.valueOf(result.getDay()) + ", al dia: "
        			+ String.valueOf(result.getLastDay() + " estado clima: " + result.getResult()));
        }
        
        System.out.println("Cantidad de Periodos de Sequia: " + String.valueOf(process.countPeriod(Forecast.CODE, Result.CLIMA_SEQUIA)));
        System.out.println("Cantidad de Periodos de Lluvia: " + String.valueOf(process.countPeriod(Forecast.CODE, Result.CLIMA_LLUVIA)));
        CalculationPredictionDTO picoMaximo = process.getOnePrediction(Forecast.CODE, Result.CLIMA_LLUVIA_INTENSA);
        System.out.println("Dia de pico maximo de lluvia: "+ String.valueOf(picoMaximo.getDay()));
        System.out.println("Cantidad de Periodos de condiciones optimas: " + String.valueOf(process.countPeriod(Forecast.CODE, Result.CLIMA_OPTIMO)));
        
        ApiForecast.registerServer(task);
    }
}
