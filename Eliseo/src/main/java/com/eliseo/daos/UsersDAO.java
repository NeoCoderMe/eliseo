package com.eliseo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliseo.entitties.User;

@Repository
public interface UsersDAO extends JpaRepository<User, Long> {

}
