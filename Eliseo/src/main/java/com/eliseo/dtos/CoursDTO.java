package com.eliseo.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.eliseo.enums.FoodType;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CoursDTO {
	
	@JsonIgnore
	private Long id;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private FoodType foodType;
	
	private LocalDateTime lastUpdate;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	private CoursDTO(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.price = builder.price;
		this.foodType = builder.foodType;
		this.lastUpdate = builder.lastUpdate;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	
	public static final class Builder{
		
		private Long id;
		
		private String name;
		
		private String description;
		
		private BigDecimal price;
		
		private FoodType foodType;
		
		private LocalDateTime lastUpdate;
		
		private Builder() {
			
		}
		
		public Builder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}
		
		public Builder withPrice(BigDecimal price) {
			this.price = price;
			return this;
		}
		
		public Builder withFoodType(FoodType foodType) {
			this.foodType = foodType;
			return this;
		}
		
		public Builder withLastUpdate(LocalDateTime lastUpdate) {
			this.lastUpdate = lastUpdate;
			return this;
		}
		
		public CoursDTO build() {
			return new CoursDTO(this);
		}
	}
	
}
