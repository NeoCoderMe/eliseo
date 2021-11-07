package com.eliseo.transformers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.eliseo.dtos.UserDTO;
import com.eliseo.entitties.User;
import com.eliseo.mocks.UsersMock;

class UserTransformerTest {

	private static List<User> users;
	
	private static User user;
	
	private static UserDTO userDTO;
	
	@BeforeAll
	static void setUp() {
		users = UsersMock.getUserListInstance();
		user = UsersMock.getUserInstance();
		userDTO = UsersMock.getUserDTOInstance();
	}
	
	@Test
	void testToUserDTO() {
		UserDTO userResult = UserTransformer.toUserDTO(user);
		assertEquals( "Address", userResult.getAddress());
		assertEquals( "email" , userResult.getEmail() );
		assertEquals( 1343l , (long) userResult.getId() );
		assertEquals( "89765654335434" , userResult.getPhone() );
	}

	@Test
	void testToUser() {
		User userResult =UserTransformer.toUser(userDTO);
		assertEquals( "Address", userResult.getAddress());
		assertEquals( "email" , userResult.getEmail() );
		assertEquals( 1343l , (long) userResult.getId() );
		assertEquals( "89765654335434" , userResult.getPhone() );
	}

	@Test
	void testTransformToUsersDTOList() {
		Optional<List<UserDTO>> result = UserTransformer.transformToUsersDTOList(users);
		assertTrue(result.isPresent());
		result.get().forEach( userResult->{
			assertEquals( "Address", userResult.getAddress());
			assertEquals( "email" , userResult.getEmail() );
			assertEquals( 1343l , (long) userResult.getId() );
			assertEquals( "89765654335434" , userResult.getPhone() );
		});
	}

}
