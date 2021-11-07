package com.eliseo.providers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.eliseo.daos.UsersDAO;
import com.eliseo.entitties.User;

public class UsersDataProvider {

	private UsersDAO usersDAO;
	
	@Autowired
	public UsersDataProvider(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	public User createUser(User user) {
		return usersDAO.save(user);
	}

	public Optional<List<User>> getUsers() {
		return Optional.ofNullable(usersDAO.findAll());
	}

}
