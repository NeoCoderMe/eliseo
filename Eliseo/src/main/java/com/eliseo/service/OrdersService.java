package com.eliseo.service;

import static com.eliseo.validation.OrdersValidations.validateStartDateIsBeforeEndDate;
import static com.eliseo.validation.OrdersValidations.validateStoreAlreadyOpen;
import static com.eliseo.validation.OrdersValidations.validateStoreHasNotAlreadyClose;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eliseo.config.StoreTimeConfig;
import com.eliseo.dtos.OrderRequestDTO;
import com.eliseo.dtos.OrderResponseDTO;
import com.eliseo.entitties.Order;
import com.eliseo.providers.OrdersDataProvider;
import com.eliseo.transformers.DatesTransformer;
import com.eliseo.transformers.OrderTransformer;

@Service
@Transactional
public class OrdersService {

	private OrdersDataProvider ordersDataProvider;
	private StoreTimeConfig storeTimeConfig;
	
	@Autowired
	public OrdersService(OrdersDataProvider ordersDataProvider, StoreTimeConfig storeTimeConfig) {
		this.ordersDataProvider = ordersDataProvider;
		this.storeTimeConfig = storeTimeConfig;
	}
	
	public OrderResponseDTO createOrder(OrderRequestDTO orderDTO) {
		//validations
		validateStoreAlreadyOpen( storeTimeConfig.getOpenTime() );
		validateStoreHasNotAlreadyClose( storeTimeConfig.getCloseTime() );
		
		var order = OrderTransformer.toOrder(orderDTO);
		order = ordersDataProvider.createOrder(order);
		return OrderTransformer.toOrderResponseDTO(order);
	} 
	
	public Optional<List<OrderResponseDTO>> getOrders(String start, String end){
		LocalDate startDate = DatesTransformer.dateTime(start);
		LocalDate endDate = DatesTransformer.dateTime(end);
		
		validateStartDateIsBeforeEndDate(startDate, endDate);
		
		Optional<List<Order>> orders= ordersDataProvider.getOrders(startDate, endDate);
		if (orders.isPresent()) {
			return OrderTransformer.transformToOrdersDTOList(orders.get());
		}
		
		return Optional.empty();
	}
}
