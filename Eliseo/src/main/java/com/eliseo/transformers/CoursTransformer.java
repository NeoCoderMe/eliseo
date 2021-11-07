package com.eliseo.transformers;

import java.time.LocalDateTime;
import static com.eliseo.constant.AppConstants.TimeZones.MEXICO_CITY_ZONE;
import java.util.List;
import java.util.stream.Collectors;

import com.eliseo.dtos.CoursDTO;
import com.eliseo.entitties.Cours;

public final class CoursTransformer {

	private CoursTransformer() {
		
	}
	
	public static Cours toCours(CoursDTO coursDTO) {
		var cours = new Cours();
		cours.setDescription(coursDTO.getDescription());
		cours.setFoodType(coursDTO.getFoodType());
		cours.setLastUpdate( LocalDateTime.now(MEXICO_CITY_ZONE) );
		cours.setName(coursDTO.getName());
		cours.setPrice(coursDTO.getPrice());
		return cours;
	}
	
	public static CoursDTO toCoursDTO(Cours coursDTO) {
		return CoursDTO.builder().withDescription( coursDTO.getDescription() )
		.withFoodType(coursDTO.getFoodType())
		.withLastUpdate( LocalDateTime.now(MEXICO_CITY_ZONE) )
		.withName(coursDTO.getName())
		.withPrice(coursDTO.getPrice())
		.withId(coursDTO.getId())
		.build();
	}
	
	public static List<CoursDTO> toCoursesListDTO(List<Cours> coursDTO) {
		return coursDTO.stream().map(CoursTransformer::toCoursDTO).collect(Collectors.toList());
	}
}
