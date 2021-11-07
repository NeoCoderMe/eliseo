package com.eliseo.mocks;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.eliseo.dtos.OrderRequestDTO;
import com.eliseo.dtos.OrderResponseDTO;
import com.eliseo.entitties.Order;

public final class OrdersMock {
	
	private OrdersMock() {
		
	}
	
	public static OrderResponseDTO getOrderResponseDTOInstance() {
		return OrderResponseDTO.builder()
				.withComment("Comments")
				.withCoursesDTO(CoursMock.getCoursDTOListInstance())
				.withCreated(LocalDateTime.now())
				.withId(123l)
				.withLastUpdate(LocalDateTime.now())
				.withTotal(BigDecimal.valueOf(13.1))
				.withUserDTO(UsersMock.getUserDTOInstance())
				.build();
	}
	
	public static OrderRequestDTO getOrderRequestDTOInstance() {
		return OrderRequestDTO.builder()
				.withComment("Comments")
				.withCoursDetailsDTO(CoursMock.getCoursDetailsDTOListInstance())
				.withCreated(LocalDateTime.now())
				.withLastUpdate(LocalDateTime.now())
				.withUserDTO(UsersMock.getUserDTOInstance())
				.build();
	}
	
	public static Order getOrderInstance() {
		var order = new Order();
		order.setComment("Comments");
		order.setCourses(CoursMock.getCoursListInstance());
		order.setCreated( LocalDateTime.now());
		order.setId(123l);
		order.setLastUpdate(LocalDateTime.now());
		order.setUser(UsersMock.getUserInstance());
		return order;
	}
	
	public static List<Order> getOrderListInstance() {
		List<Order> orders = new ArrayList<>();
		orders.add(getOrderInstance());
		orders.add(getOrderInstance());
		return orders;
	}
}
