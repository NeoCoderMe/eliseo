package com.eliseo.mocks;

import java.util.ArrayList;
import java.util.List;

import com.eliseo.dtos.UserDTO;
import com.eliseo.entitties.User;

public final class UsersMock {
	private UsersMock() {
		
	}
	
	public static User getUserInstance() {
		var user = new User();
		user.setAddress("Address");
		user.setEmail("email");
		user.setId(1343l);
		user.setPhone("89765654335434");
		return user;
	}
	
	public static List<User> getUserListInstance(){
		List<User> users = new ArrayList<>();
		users.add(getUserInstance());
		users.add(getUserInstance());
		return users;
	}
	
	public static UserDTO getUserDTOInstance() {
		return UserDTO.builder()
		.withAddress("Address")
		.withEmail("email")
		.withId(1343l)
		.withPhone("89765654335434")
		.build();
	}
	
	public static List<UserDTO> getUserDTOListInstance(){
		List<UserDTO> users = new ArrayList<>();
		users.add(getUserDTOInstance());
		users.add(getUserDTOInstance());
		return users;
	}
}
