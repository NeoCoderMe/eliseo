package com.eliseo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliseo.entitties.Cours;

@Repository
public interface CoursesDAO extends JpaRepository<Cours, Long> {

}
