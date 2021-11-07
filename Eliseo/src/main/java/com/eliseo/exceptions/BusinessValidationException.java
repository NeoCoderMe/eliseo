package com.eliseo.exceptions;

public class BusinessValidationException extends RuntimeException {

	private static final long serialVersionUID = -1633922289333295439L;

	public BusinessValidationException(String message) {
		super(message);
	}
	
}