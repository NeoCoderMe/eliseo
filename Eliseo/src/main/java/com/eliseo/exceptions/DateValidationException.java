package com.eliseo.exceptions;

public class DateValidationException extends RuntimeException{

	private static final long serialVersionUID = 3874248150773399105L;

	public DateValidationException(String message) {
		super(message);
	}
}
