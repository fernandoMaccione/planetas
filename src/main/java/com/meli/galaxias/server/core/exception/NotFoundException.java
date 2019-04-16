package com.meli.galaxias.server.core.exception;

public class NotFoundException extends ServiceException{
	private static final long serialVersionUID = -5773524537528409473L;

	public NotFoundException (String message){
		super(message);
	}
}
