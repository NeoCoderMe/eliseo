package com.eliseo.transformers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eliseo.dtos.UserDTO;
import com.eliseo.entitties.User;

public final class UserTransformer {

	private UserTransformer() {
		
	}
	
	public static UserDTO toUserDTO(User user) {
		return UserDTO.builder()
			.withAddress(user.getAddress())
			.withEmail(user.getEmail())
			.withId(user.getId())
			.withPhone(user.getPhone())
			.build();
	}
	
	public static User toUser(UserDTO user) {
		var userEntity = new User();
		userEntity.setAddress( user.getAddress() );
		userEntity.setEmail( user.getEmail() );
		userEntity.setId( user.getId() );
		userEntity.setPhone( user.getPhone() );
		return userEntity;
	}
	
	public static Optional<List<UserDTO>> transformToUsersDTOList(List<User> users){
		List<UserDTO> usersDTO = Collections.emptyList();
		
		if (!users.isEmpty()) {
			usersDTO = users.stream().map(UserTransformer::toUserDTO).collect(Collectors.toList());
		}
		return Optional.of(usersDTO);
	}
}
