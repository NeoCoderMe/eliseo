package com.eliseo.controllers;

import static com.eliseo.constant.AppConstants.Controllers.ORDERS_CONTROLLER_ADD;
import static com.eliseo.constant.AppConstants.Controllers.ORDERS_CONTROLLER_GET_ALL;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eliseo.dtos.GenericResponseDTO;
import com.eliseo.dtos.OrderRequestDTO;
import com.eliseo.dtos.OrderResponseDTO;
import com.eliseo.service.OrdersService;

@Validated
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseControllerResponses{
	
	private OrdersService ordersService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);
	
	@Autowired
	public OrdersController(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@PostMapping("/")
	public ResponseEntity<GenericResponseDTO<OrderResponseDTO>> createOrder(OrderRequestDTO orderDTO) {
		LOGGER.debug(ORDERS_CONTROLLER_ADD);
		
		OrderResponseDTO order= ordersService.createOrder(orderDTO);
		return buildCreatedResponse(order);
	} 
	
	@GetMapping("/")
	public ResponseEntity<GenericResponseDTO<List<OrderResponseDTO>>> getOrders(@RequestParam(name="start-date") String startDate, @RequestParam(name="end-date") String endDate){
		LOGGER.debug(ORDERS_CONTROLLER_GET_ALL);
		
		Optional<List<OrderResponseDTO>> orders= ordersService.getOrders(startDate, endDate);
		if (orders.isPresent()) {
			return buildOkResponse(orders.get());
		}
		
		return buildNoContentResponse(Collections.emptyList());
	}
}
