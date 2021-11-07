package com.eliseo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eliseo.dtos.CoursDTO;
import com.eliseo.entitties.Cours;
import com.eliseo.providers.CoursesDataProvider;
import com.eliseo.transformers.CoursTransformer;

@Service
@Transactional
public class CoursesService {

	private CoursesDataProvider coursesDataProvider;
	 
	@Autowired
	public CoursesService(CoursesDataProvider coursesDataProvider) {
		this.coursesDataProvider = coursesDataProvider;
	}
	
	public CoursDTO createCours(CoursDTO coursDTO) {
		var cours = CoursTransformer.toCours(coursDTO);
		cours= coursesDataProvider.save(cours);
		return CoursTransformer.toCoursDTO(cours);
	}
	
	public Optional<List<Cours>> getAll(){
		return coursesDataProvider.getAll();
	}

}
