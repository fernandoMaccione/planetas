package com.meli.galaxias.server.core.service;

import java.util.HashMap;
import java.util.List;

import com.meli.galaxias.server.core.exception.NotFoundException;
import com.meli.galaxias.server.core.exception.ServiceException;
import com.meli.galaxias.server.core.service.model.FactoryGalaxyCalculation;
import com.meli.galaxias.server.core.service.model.SolarSytemProcess;

public class ServiceCalculation {
/**
 * La idea de este servicio, es que no solo sirva para la previsión del tiempo, sino de que que en 
 * un futuro los habitantes de los planetas, puedan llegar a requerir algun otro tipo de analisis de su mismo sistema solar, 
 * o porque no, de otros?
 * Lo que hace es levantar los procesos registrados, clase "SolarSytemProcess". 
 * En procesos es la relación de un sistema solar con los tipo calculos (ICalculate) que hayan que realizarle en un peiodo de tiempo
 *  
 */ 
	
	private static ServiceCalculation instance;
	private ServiceCalculation() throws ServiceException{
		initialize();
	}
	public static  ServiceCalculation getInstance() throws ServiceException{
		if (instance == null){
			synchronized(ServiceCalculation.class){
				instance = new ServiceCalculation();
			}
		}
		return instance;
	}
	
	private HashMap<String, SolarSytemProcess> cacheProcess;
	private void initialize() throws ServiceException{
		cacheProcess = new HashMap<String, SolarSytemProcess>();
		
		List<SolarSytemProcess> sProcess = FactoryGalaxyCalculation.calculationRegistred();
		
		/*
		 * itero los los sistemas solares registrados con sus calculos asociados, y los agrego al cache
		 * para que esten disponibles al momento de alguna consulta 
		 */
		
		for(SolarSytemProcess sistema:sProcess){
			sistema.executeProcess();
			cacheProcess.put(sistema.getGalaxy().getCode(), sistema);
		}
	}
	
	public SolarSytemProcess getSolarSystem(String code) throws NotFoundException{
		if (cacheProcess.containsKey(code)){
			return cacheProcess.get(code);
		}else{
			throw new NotFoundException("Solar System; " + code + " not exist. ");
		}
	}
	
}
