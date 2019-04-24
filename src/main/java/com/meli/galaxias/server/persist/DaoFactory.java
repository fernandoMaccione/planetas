package com.meli.galaxias.server.persist;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.meli.galaxias.common.Config;

public class DaoFactory {
	private static EntityManagerFactory emf;
	
	private DaoFactory(){}
	
	public static EntityManager getManager(){
		if (emf == null){
			synchronized(DaoFactory.class){
				emf = Persistence
			            .createEntityManagerFactory(Config.PERSISTENCE_UNIT);
			}
		}
		
		EntityManager manager = emf.createEntityManager();
		return manager;
	}
	
	public static void close(){
		emf.close();
	}
}
