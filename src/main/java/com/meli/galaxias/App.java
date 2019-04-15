package com.meli.galaxias;

import com.meli.galaxias.common.Config;
import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.core.job.ServiceCalculation;
import com.meli.galaxias.server.core.job.model.SolarSytemProcess;

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
        System.out.println( "Iniciando ya iniciado..." );
        SolarSytemProcess process = task.getSolarSystem(Config.GALAXIA_LEJANA);
        for (CalculationPredictionDTO result:process.getResult("FORECAST")){
        	System.out.println("del dia: " + String.valueOf(result.getDay()) + ", al dia: "
        			+ String.valueOf(result.getLastDay() + " estado clima: " + result.getResult()));
        }
        
    }
}
