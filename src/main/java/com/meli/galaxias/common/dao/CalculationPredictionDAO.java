package com.meli.galaxias.common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.meli.galaxias.common.dto.CalculationPredictionDTO;
import com.meli.galaxias.server.persist.DaoFactory;

public class CalculationPredictionDAO {
	public static List<CalculationPredictionDTO> getCalculation(long idProcess, String code){
		EntityManager manager = DaoFactory.getManager();
		Query query =  manager.createQuery(
	            "Select a From CalculationPredictionDTO a where a.idProcess = :idProcess and a.codeCalculate = :code", CalculationPredictionDTO.class);
		query.setParameter("idProcess", idProcess);
		query.setParameter("code", code);
		List<CalculationPredictionDTO> resultList = (List<CalculationPredictionDTO>) query.getResultList();
		manager.close();
		return resultList;
	}
	
	public static void save(List<CalculationPredictionDTO> result){
		EntityManager manager = DaoFactory.getManager();
		EntityTransaction tx = manager.getTransaction();
	    tx.begin();
		try {
			manager.getTransaction();
			for (CalculationPredictionDTO dto:result){
				save(dto, manager);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			new PersistenceException("Data base error", e);
		} finally {
			manager.close();
		}
	}
	
	public static void save(CalculationPredictionDTO result){
		EntityManager manager = DaoFactory.getManager();
		EntityTransaction tx = manager.getTransaction();
	    tx.begin();
		try {
			manager.getTransaction();
			save(result, manager);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			new PersistenceException("Data base error", e);
		} finally {
			manager.close();
		}
	}
	
	public static void save(CalculationPredictionDTO dto, EntityManager manager){
		manager.persist(dto);
	}
}
