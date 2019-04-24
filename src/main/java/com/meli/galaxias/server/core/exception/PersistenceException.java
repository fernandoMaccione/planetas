package com.meli.galaxias.server.core.exception;

public class PersistenceException extends ServiceException{

	private static final long serialVersionUID = -2167548238974502653L;
	public PersistenceException(String message){
		super(message);
	}
	
	public PersistenceException(String message, Exception e){
		super(message, e);
	}
}
