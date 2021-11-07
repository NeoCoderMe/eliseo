package com.eliseo.mocks;

import static com.eliseo.constant.AppConstants.TimeZones.MEXICO_CITY_ZONE;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.eliseo.dtos.CoursDTO;
import com.eliseo.dtos.CoursDetailsDTO;
import com.eliseo.entitties.Cours;
import com.eliseo.enums.FoodType;

public final class CoursMock {
	
	private CoursMock() {
		
	}
	
	public static Cours getCoursInstance() {
		var cours = new Cours();
		cours.setDescription("Description");
		cours.setFoodType(FoodType.ITALIAN);
		cours.setId(123l);
		cours.setLastUpdate(LocalDateTime.now( MEXICO_CITY_ZONE) );
		cours.setName("Eliseo");
		cours.setPrice(BigDecimal.valueOf(13.33));
		return cours;
	}
	
	public static List<Cours> getCoursListInstance() {
		List<Cours> cours = new ArrayList<>();
		cours.add(getCoursInstance());
		cours.add(getCoursInstance());
		return cours;
	}
	
	public static CoursDTO getCoursDTOInstance() {
		return CoursDTO.builder().withDescription("Description")
		.withFoodType(FoodType.ITALIAN).withId(123l)
		.withLastUpdate( LocalDateTime.now(MEXICO_CITY_ZONE) )
		.withName("Eliseo")
		.withPrice(BigDecimal.valueOf(13.33))
		.build();
	}
	
	public static List<CoursDTO> getCoursDTOListInstance() {
		List<CoursDTO> cours = new ArrayList<>();
		cours.add(getCoursDTOInstance());
		cours.add(getCoursDTOInstance());
		return cours;
	}
	
	public static List<CoursDetailsDTO> getCoursDetailsDTOListInstance(){
		List<CoursDetailsDTO> result = new ArrayList<>();
		CoursDetailsDTO course = new CoursDetailsDTO();
		course.setCoursId(1753l);
		course.setQuantity(5l);
		//CoursDetailsDTO(coursId, quantity)
		result.add( new CoursDetailsDTO(2124l, 3l));
		result.add( course);
		return result;
	}
}
