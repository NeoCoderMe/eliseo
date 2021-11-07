package com.eliseo.entitties;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eliseo.enums.FoodType;

@Entity
@Table(name ="courses") //platillo
public class Cours {

	@Id
	@Column(nullable =  false)
	private Long id;
	
	@Column(nullable =  false)
	private String name;
	
	@Column
	private String description;
	
	@Column(nullable =  false)
	private BigDecimal price;
	
	@Column(name="food-type",  nullable =  false)
	private FoodType foodType;
	
	@Column(nullable =  false)
	private LocalDateTime lastUpdate;
	
	public Cours() {
		
	}
	
	public Cours(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
