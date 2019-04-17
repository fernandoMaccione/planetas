package com.meli.galaxias;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.calculation.Forecast.Forecast;
import com.meli.galaxias.server.core.calculation.Forecast.model.Result;
import com.meli.galaxias.server.core.exception.ServiceException;
import com.meli.galaxias.server.core.service.ServiceCalculation;
import com.meli.galaxias.server.core.service.model.SolarSytemProcess;
import com.meli.galaxias.web.Api;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
            System.out.println( "Iniciando proceso..." );
            ServiceCalculation.getInstance();
            System.out.println( "Proceso ya iniciado..." );
            
            testService();
            
            //Levanto el server
            Api.registerServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	private static void testService() throws ServiceException {
        ServiceCalculation task = ServiceCalculation.getInstance();
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
		
	}
}
