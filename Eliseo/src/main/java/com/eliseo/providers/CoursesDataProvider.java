package com.eliseo.providers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseo.daos.CoursesDAO;
import com.eliseo.entitties.Cours;

@Service
public class CoursesDataProvider {

	private CoursesDAO coursesDAO;
	
	@Autowired
	public CoursesDataProvider(CoursesDAO coursesDAO) {
		this.coursesDAO = coursesDAO;
	}
	
	public Cours save(Cours cours) {
		return coursesDAO.save(cours);
	}

	public Optional<List<Cours>> getAll(){
		return Optional.ofNullable(coursesDAO.findAll());
	}
	
}
