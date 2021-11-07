package com.eliseo.controllers;

import static com.eliseo.constant.AppConstants.Controllers.USER_CONTROLLER_ADD;
import static com.eliseo.constant.AppConstants.Controllers.USER_CONTROLLER_GET_ALL;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliseo.dtos.GenericResponseDTO;
import com.eliseo.dtos.UserDTO;
import com.eliseo.service.UsersService;

@Validated
@RestController
@RequestMapping("/users")
public class UsersController extends BaseControllerResponses{

	private UsersService usersService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}
	
	//Alta usuario
	@PostMapping("/")
	public ResponseEntity<GenericResponseDTO<UserDTO>> createUser(@Validated @RequestBody UserDTO userDTO){
		LOGGER.debug(USER_CONTROLLER_ADD);
		
		UserDTO user = usersService.createUser(userDTO);
		return buildCreatedResponse(user);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<GenericResponseDTO<List<UserDTO>>> getUsers(){
		LOGGER.debug(USER_CONTROLLER_GET_ALL);
		
		Optional<List<UserDTO>> users = usersService.getUsers();
		if (users.isPresent()) {
			return buildOkResponse(users.get());
		}
		
		return buildNoContentResponse(Collections.emptyList());
	}
}
