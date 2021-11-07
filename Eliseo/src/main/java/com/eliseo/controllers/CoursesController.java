package com.eliseo.controllers;

import static com.eliseo.constant.AppConstants.Controllers.COURS_CONTROLLER_ADD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliseo.dtos.CoursDTO;
import com.eliseo.dtos.GenericResponseDTO;
import com.eliseo.service.CoursesService;

@Validated
@RestController
@RequestMapping("/courses")
public class CoursesController extends BaseControllerResponses{

	private CoursesService coursesService;
	private static final Logger LOGGER = LoggerFactory.getLogger(CoursesController.class);
	
	@Autowired
	public CoursesController(CoursesService coursesService) {
		this.coursesService = coursesService;
	}
	
	@PostMapping("/")
	public ResponseEntity<GenericResponseDTO<CoursDTO>> createCours(@Validated @RequestBody CoursDTO coursDTO){
		LOGGER.debug(COURS_CONTROLLER_ADD);
		
		CoursDTO cours = coursesService.createCours(coursDTO);
		return buildCreatedResponse(cours);
	} 
}
