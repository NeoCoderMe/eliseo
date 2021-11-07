package com.eliseo.transformers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.eliseo.dtos.CoursDTO;
import com.eliseo.entitties.Cours;
import com.eliseo.mocks.CoursMock;

class CoursTransformerTest {

	private static List<Cours> courses;
	
	private static Cours cours;
	
	private static CoursDTO coursDTO;
	
	@BeforeAll
	static void setUp() {
		cours = CoursMock.getCoursInstance();
		coursDTO = CoursMock.getCoursDTOInstance();
		courses = CoursMock.getCoursListInstance();
				
	}
	
	@Test
	void testToCours() {
		Cours coursResult =CoursTransformer.toCours(coursDTO);
		assertEquals( "Description",  coursResult.getDescription());
		assertEquals( "ITALIAN",  coursResult.getFoodType().toString());
		assertEquals( "Eliseo",  coursResult.getName());
		assertEquals( 13.33 ,  coursResult.getPrice().doubleValue(), 1);
	}

	@Test
	void testToCoursDTO() {
		CoursDTO coursResult =CoursTransformer.toCoursDTO(cours);
		assertEquals( "Description",  coursResult.getDescription());
		assertEquals( "ITALIAN",  coursResult.getFoodType().toString());
		assertEquals( 123l, (long) coursResult.getId());
		assertEquals( "Eliseo",  coursResult.getName());
		assertNotNull(coursResult.getLastUpdate());
		assertEquals( 13.33 ,  coursResult.getPrice().doubleValue(), 1);
	}

	@Test
	void testToCoursesListDTO() {
		List<CoursDTO> coursesResult = CoursTransformer.toCoursesListDTO(courses);
		coursesResult.forEach( coursResult->{
			assertEquals( "Description",  coursResult.getDescription());
			assertEquals( "ITALIAN", coursResult.getFoodType().toString());
			assertEquals( 123l, (long) coursResult.getId());
			assertEquals( "Eliseo",  coursResult.getName());
			assertEquals( 13.33 ,  coursResult.getPrice().doubleValue(), 1);
		});
	}

}
