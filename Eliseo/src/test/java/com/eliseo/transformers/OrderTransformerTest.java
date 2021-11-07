package com.eliseo.transformers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.eliseo.dtos.OrderRequestDTO;
import com.eliseo.dtos.OrderResponseDTO;
import com.eliseo.entitties.Order;
import com.eliseo.mocks.OrdersMock;

class OrderTransformerTest {

	private static Order order;
	
	private static OrderRequestDTO orderRequest;
	
	private static OrderResponseDTO orderResponseDTO;
	
	@BeforeAll
	static void setUp() {
		order = OrdersMock.getOrderInstance();
		orderRequest = OrdersMock.getOrderRequestDTOInstance();
		orderResponseDTO = OrdersMock.getOrderResponseDTOInstance();
	}
	
	@Test
	void testToOrderOrderResponseDTO() {
		OrderResponseDTO response =OrderTransformer.toOrderResponseDTO(order);
		assertEquals("Comments" , response.getComment());
		assertEquals( 123l , (long) response.getId());
		assertNotNull( response.getUserDTO());
		assertNotNull( response.getCreated());
		assertNotNull( response.getLastUpdate());
		assertFalse( response.getCoursesDTO().isEmpty());
	}

	@Test
	void testOrderRequestToOrder() {
		Order order =OrderTransformer.toOrder(orderRequest);
		assertEquals("Comments" , order.getComment());
		assertNotNull( order.getUser());
		assertNotNull( order.getCreated());
		assertNotNull( order.getLastUpdate());
		assertFalse( order.getCourses().isEmpty());
	}

	@Test
	void testOrderResponseToOrder() {
		Order order =OrderTransformer.toOrder(orderResponseDTO);
		assertEquals("Comments" , order.getComment());
		assertNotNull( order.getUser());
		assertNotNull( order.getCreated());
		assertNotNull( order.getLastUpdate());
		assertFalse( order.getCourses().isEmpty());
	}

}
