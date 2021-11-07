package com.eliseo.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {

	@JsonIgnore
	private Long id;
	
	private String email;
	
	private String address;
	
	private String phone;
	
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	private UserDTO(Builder builder) {
		this.id = builder.id;
		this.email = builder.email; 
		this.address = builder.address;
		this.phone = builder.phone;
	}
	
	public static final class Builder{
		private Long id;
		
		private String email;
		
		private String address;
		
		private String phone;
		
		private Builder() {
			
		}
		
		public Builder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public Builder withPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public UserDTO build() {
			return new UserDTO(this);
		}
	}
}
