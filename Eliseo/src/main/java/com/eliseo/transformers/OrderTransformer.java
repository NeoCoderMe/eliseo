package com.eliseo.transformers;

import static com.eliseo.constant.AppConstants.TimeZones.MEXICO_CITY_ZONE;
import static com.eliseo.transformers.CoursTransformer.toCoursesListDTO;
import static com.eliseo.transformers.UserTransformer.toUserDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.eliseo.dtos.OrderRequestDTO;
import com.eliseo.dtos.OrderResponseDTO;
import com.eliseo.entitties.Cours;
import com.eliseo.entitties.Order;

public final class OrderTransformer {
	
	private OrderTransformer() {
		
	}
	
	public static Order toOrder(OrderResponseDTO orderDTO) {
		var order = new Order();
		order.setComment(orderDTO.getComment());
		order.setCourses( transformToCoursesList(orderDTO)  );
		order.setCreated( orderDTO.getCreated());
		order.setLastUpdate( LocalDateTime.now(MEXICO_CITY_ZONE) );
		order.setUserId( orderDTO.getUserDTO().getId() );
		return order;
	}
	
	public static Order toOrder(OrderRequestDTO orderDTO) {
		var order = new Order();
		order.setComment(orderDTO.getComment());
		order.setCourses( transformToCoursesList(orderDTO)  );
		order.setCreated( orderDTO.getCreated() );
		order.setLastUpdate( orderDTO.getLastUpdate() );
		order.setUserId( orderDTO.getUserDTO().getId() );
		return order;
	}
	
	public static OrderResponseDTO toOrderResponseDTO(Order order) {
		return OrderResponseDTO.builder()
				.withComment( order.getComment() )
				.withCoursesDTO( toCoursesListDTO(order.getCourses()) )
				.withCreated( order.getCreated())
				.withId(order.getId())
				.withLastUpdate( LocalDateTime.now(MEXICO_CITY_ZONE) )
				.withTotal( calculateTotalCourses(order.getCourses()) )
				.withUserDTO( toUserDTO(order.getUser()) )
				.build();
	}
	
	public static Optional<List<OrderResponseDTO>> transformToOrdersDTOList(List<Order> orders){
		List<OrderResponseDTO> ordersDTO = Collections.emptyList();
		
		if (!orders.isEmpty()) {
			ordersDTO = orders.stream().map(OrderTransformer::toOrderResponseDTO).collect(Collectors.toList());
		}
		return Optional.of(ordersDTO);
	}
	
	
	
	private static List<Cours> transformToCoursesList(OrderRequestDTO orderRequestDTO) {
		return orderRequestDTO.getCoursDetailsDTO().stream().map(order -> new Cours(order.getCoursId())  ).collect(Collectors.toList());
	}
	
	private static List<Cours> transformToCoursesList(OrderResponseDTO orderResponseDTO) {
		return orderResponseDTO.getCoursesDTO().stream().map(order -> new Cours(order.getId())  ).collect(Collectors.toList());
	}
	
	private static BigDecimal calculateTotalCourses(List<Cours> coursDTO) {
		return coursDTO.stream().map(Cours::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
