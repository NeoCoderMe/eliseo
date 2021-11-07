package com.eliseo.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDTO {

	private Long id;
	
	private UserDTO userDTO;
	
	private List<CoursDTO> coursesDTO;

	private BigDecimal total;
	
	private String comment;
	
	private LocalDateTime created;
	
	private LocalDateTime lastUpdate;

	
	public OrderResponseDTO(Builder builder) {
		this.id = builder.id;
		this.userDTO = builder.userDTO;
		this.coursesDTO = builder.coursesDTO;
		this.total = builder.total;
		this.comment = builder.comment;
		this.created = builder.created;
		this.lastUpdate = builder.lastUpdate;
	}

	public Long getId() {
		return id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public List<CoursDTO> getCoursesDTO() {
		return coursesDTO;
	}

	public BigDecimal getTotal() {
		return total;
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
		private Long id;
		
		private UserDTO userDTO;
		
		private List<CoursDTO> coursesDTO;

		private BigDecimal total;
		
		private String comment;
		
		private LocalDateTime created;
		
		private LocalDateTime lastUpdate;
		
		private Builder() {
			
		}
		
		public Builder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder withUserDTO(final UserDTO userDTO) {
			this.userDTO = userDTO;
			return this;
		}
		
		public Builder withCoursesDTO(final List<CoursDTO> coursDTO) {
			this.coursesDTO = coursDTO;
			return this;
		}
		
		public Builder withTotal(BigDecimal total) {
			this.total = total;
			return this;
		}
		
		public Builder withComment(String comment) {
			this.comment = comment;
			return this;
		}
		
		public Builder withCreated(LocalDateTime created) {
			this.created = created;
			return this;
		}
		
		public Builder withLastUpdate(LocalDateTime lastUpdate) {
			this.lastUpdate = lastUpdate;
			return this;
		}
		
		public OrderResponseDTO build() {
			return new OrderResponseDTO(this);
		}
	}
}
