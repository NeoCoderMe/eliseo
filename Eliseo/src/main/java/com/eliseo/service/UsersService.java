package com.eliseo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eliseo.dtos.UserDTO;
import com.eliseo.entitties.User;
import com.eliseo.providers.UsersDataProvider;
import com.eliseo.transformers.UserTransformer;

@Service
@Transactional
public class UsersService {

	private UsersDataProvider usersDataProvider;
	
	@Autowired
	public UsersService(UsersDataProvider usersDataProvider) {
		this.usersDataProvider = usersDataProvider;
	}
	
	public UserDTO createUser(UserDTO userDTO) {
		var user = UserTransformer.toUser(userDTO);
		user = usersDataProvider.createUser(user);
		return UserTransformer.toUserDTO(user);
	}

	public Optional<List<UserDTO>> getUsers() {
		Optional<List<User>> users = usersDataProvider.getUsers();
		if (users.isPresent()) {
			return UserTransformer.transformToUsersDTOList(users.get());		
		}
		return Optional.empty();
	}
	
}
