package com.eliseo.providers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eliseo.daos.OrdersDAO;
import com.eliseo.entitties.Order;

@Service
public class OrdersDataProvider {

	private OrdersDAO ordersDAO;
	
	@Autowired
	public OrdersDataProvider(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	
	public Order createOrder(Order order) {
		return ordersDAO.save(order);
	}
	
	public Optional<List<Order>> getOrders(LocalDate start, LocalDate end){
		return ordersDAO.findAllByCreatedGreaterThanEqualAndCreatedLessThanEqual(start, end);
	}
}
