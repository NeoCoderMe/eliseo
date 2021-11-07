package com.eliseo.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDTO {

	private UserDTO userDTO;
	
	private List<CoursDetailsDTO> coursDetailsDTO;

	private String comment;
	
	private LocalDateTime created;
	
	private LocalDateTime lastUpdate;

	
	private OrderRequestDTO(Builder builder) {
		this.userDTO = builder.userDTO;
		this.coursDetailsDTO = builder.coursDetailsDTO;
		this.comment = builder.comment;
		this.created = builder.created;
		this.lastUpdate = builder.lastUpdate;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public List<CoursDetailsDTO> getCoursDetailsDTO() {
		return coursDetailsDTO;
	}

	public String getComment() {
		return comment;
	}

	public LocalDateTime getCreated() {
		return created;
	}


	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder{
		private UserDTO userDTO;
		
		private List<CoursDetailsDTO> coursDetailsDTO;

		private String comment;
		
		private LocalDateTime created;
		
		private LocalDateTime lastUpdate;
		
		private Builder() {
			
		}
		
		public Builder withUserDTO(final UserDTO withUserDTO) {
			this.userDTO = withUserDTO;
			return this;
		}
		
		public Builder withCoursDetailsDTO(final List<CoursDetailsDTO> withCoursDetailsDTO) {
			this.coursDetailsDTO = withCoursDetailsDTO;
			return this;
		}
		
		public Builder withComment(String withComment) {
			this.comment = withComment;
			return this;
		}
		
		public Builder withCreated(LocalDateTime withCreated) {
			this.created = withCreated;
			return this;
		}
		
		public Builder withLastUpdate(LocalDateTime withLastUpdate) {
			this.lastUpdate = withLastUpdate;
			return this;
		}
		
		public OrderRequestDTO build() {
			return new OrderRequestDTO(this);
		}
	}
}
