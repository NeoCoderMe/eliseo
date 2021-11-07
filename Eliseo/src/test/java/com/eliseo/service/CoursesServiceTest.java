package com.eliseo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eliseo.dtos.CoursDTO;
import com.eliseo.entitties.Cours;
import com.eliseo.mocks.CoursMock;
import com.eliseo.providers.CoursesDataProvider;

@ExtendWith(MockitoExtension.class)
class CoursesServiceTest {

	private static CoursesService coursesService;
	private static CoursesDataProvider provider;
	
	@BeforeAll
	static void setUp() {
		provider = Mockito.mock(CoursesDataProvider.class);
		coursesService = new CoursesService(provider);
	}
	
	@Test
	void testCoursesService() {
		assertNotNull(coursesService);
		assertNotNull(provider);
	}

	@Test
	void testCreateCours() {
		when(provider.save(  any(Cours.class) )).thenReturn(CoursMock.getCoursInstance());
		CoursDTO coursResult = coursesService.createCours(CoursMock.getCoursDTOInstance());
		assertEquals( "Description",  coursResult.getDescription());
		assertEquals( "ITALIAN",  coursResult.getFoodType().toString());
		assertEquals( "Eliseo",  coursResult.getName());
		assertEquals( 13.33 ,  coursResult.getPrice().doubleValue(), 1);
	}

	@Test
	void testGetAll() {
		when(provider.getAll()).thenReturn( Optional.of( CoursMock.getCoursListInstance())  );
		Optional<List<Cours>> coursResultList = coursesService.getAll( );
		assertTrue(coursResultList.isPresent());
		
		coursResultList.get().forEach( coursResult ->{
			assertEquals( "Description",  coursResult.getDescription());
			assertEquals( "ITALIAN", coursResult.getFoodType().toString());
			assertEquals( 123l, (long) coursResult.getId());
			assertEquals( "Eliseo",  coursResult.getName());
			assertEquals( 13.33 ,  coursResult.getPrice().doubleValue(), 1);
		} );
	}

}
