package com.eliseo.config;

import java.time.format.DateTimeParseException;
import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eliseo.dtos.GenericResponseDTO;
import com.eliseo.exceptions.BusinessValidationException;
import com.eliseo.exceptions.DateValidationException;

@ControllerAdvice
public class ControllerExceptionMapping extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {DateValidationException.class})
	protected ResponseEntity<Object> handleDateValidationException(DateValidationException ex, WebRequest request){
		return formatException(ex, null, HttpStatus.BAD_REQUEST,  request);
	}
	
	@ExceptionHandler(value = {DateTimeParseException.class})
	protected ResponseEntity<Object> handleDateTimeParseException(DateTimeParseException ex, WebRequest request){
		return formatException(ex, null, HttpStatus.BAD_REQUEST,  request);
	}
	
	@ExceptionHandler(value = {BusinessValidationException.class})
	protected ResponseEntity<Object> handleBusinessValidationException(BusinessValidationException ex, WebRequest request){
		return formatException(ex, null, HttpStatus.BAD_REQUEST,  request);
	}
	
	private ResponseEntity<Object> formatException(Exception ex, Object body,  HttpStatus status, WebRequest request){
		final String message = status.is5xxServerError() || Objects.isNull(body)? ex.getLocalizedMessage(): null;
		return handleExceptionInternal(ex, GenericResponseDTO.build(status, message, body), new HttpHeaders(),  status,  request);
	}
}
