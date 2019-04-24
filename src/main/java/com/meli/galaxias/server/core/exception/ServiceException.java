package com.meli.galaxias.server.core.exception;

public class ServiceException extends Exception{
	private static final long serialVersionUID = 6216502531120690433L;
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message, Exception e){
		super(message,e);
	}
}
