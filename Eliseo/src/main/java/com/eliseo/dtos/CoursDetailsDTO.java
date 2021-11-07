package com.eliseo.dtos;

public class CoursDetailsDTO {

	private Long coursId;
	
	private Long quantity;

	public CoursDetailsDTO() {
		
	}
	
	public CoursDetailsDTO(Long coursId, Long quantity) {
		this.coursId = coursId;
		this.quantity = quantity;
	}
	
	public Long getCoursId() {
		return coursId;
	}

	public void setCoursId(Long coursId) {
		this.coursId = coursId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
