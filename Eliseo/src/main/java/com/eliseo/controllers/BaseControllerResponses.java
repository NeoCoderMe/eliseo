package com.eliseo.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eliseo.dtos.GenericResponseDTO;

public abstract class BaseControllerResponses  {
	
	private static final String SUCCESS = "Success";
	private static final String ERROR = "Error";
	private static final String CREATED = "Created";
	private static final String NO_CONTENT = "No Content";
	
	
	protected <T> ResponseEntity<GenericResponseDTO<T>> buildNoContentResponse(T data){
		return buildResponse(HttpStatus.NO_CONTENT, NO_CONTENT, data);
	}
	
	protected ResponseEntity<GenericResponseDTO<Void>> buildNoContentResponse(){
		return buildResponse(HttpStatus.NO_CONTENT, NO_CONTENT, null);
	}
	
	protected ResponseEntity<GenericResponseDTO<Void>> buildTooManyRequest(){
		return buildResponse(HttpStatus.TOO_MANY_REQUESTS, ERROR, null);
	}
	
	protected <T> ResponseEntity<GenericResponseDTO<T>> forBiddenRequest(T data){
		return buildResponse(HttpStatus.FORBIDDEN, ERROR, data);
	}
	
	protected <T> ResponseEntity<GenericResponseDTO<T>> buildTooManyRequest(T data){
		return buildResponse(HttpStatus.TOO_MANY_REQUESTS, ERROR, data);
	}
	
	protected <T> ResponseEntity<GenericResponseDTO<T>> buildOkResponse(T data){
		return buildResponse(HttpStatus.OK, SUCCESS, data);
	}
	
	protected <T> ResponseEntity<GenericResponseDTO<T>> buildCreatedResponse(T data){
		return buildResponse(HttpStatus.CREATED, CREATED, data);
	}
	
	protected <T> ResponseEntity<GenericResponseDTO<T>> buildBadRequest(T data){
		return buildResponse(HttpStatus.BAD_REQUEST, ERROR, data);
	}
	
	protected <T extends Collection<?>> ResponseEntity<GenericResponseDTO<T>> buildOkResponse(T data){
		return buildResponse(HttpStatus.OK, SUCCESS, data);
	}
	
	private <T> ResponseEntity<GenericResponseDTO<T>> buildResponse(HttpStatus status, String message, T data){
		return new ResponseEntity<>(GenericResponseDTO.build(status, message, data), status);
	}

}
