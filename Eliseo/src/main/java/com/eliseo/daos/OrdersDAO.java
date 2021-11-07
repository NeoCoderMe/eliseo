package com.eliseo.daos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliseo.entitties.Order;

@Repository
public interface OrdersDAO extends JpaRepository<Order, Long> {

	Optional<List<Order>> findAllByCreatedGreaterThanEqualAndCreatedLessThanEqual(LocalDate start, LocalDate end);
}
