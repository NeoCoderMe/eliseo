package com.eliseo.entitties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class User {

	@Id
	@Column(nullable =  false)
	private Long id;
	
	@Column(nullable =  false)
	private String email;
	
	@Column(nullable =  false)
	private String address;
	
	@Column(nullable =  false)
	private String phone;
	
	public User() {
		
	}
	
	public User(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
