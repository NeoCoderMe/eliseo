package com.eliseo.dtos;

import org.springframework.http.HttpStatus;

public class GenericResponseDTO<T> {

	private String id;
	
	private int statusCode;
	
	private String statusName;
	
	private String message;
	
	private T details;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getDetails() {
		return details;
	}
	public void setDetails(T details) {
		this.details = details;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public static <T> GenericResponseDTO<T> build( HttpStatus status, String message, T details){
		GenericResponseDTO<T> generiResponseDTO = new GenericResponseDTO<>();
		generiResponseDTO.setStatusCode(status.value());
		generiResponseDTO.setStatusName(status.name());
		generiResponseDTO.setMessage(message);
		generiResponseDTO.setDetails(details);
		return generiResponseDTO;
	}
	
}
