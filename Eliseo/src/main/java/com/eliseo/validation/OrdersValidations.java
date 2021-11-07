package com.eliseo.validation;

import static com.eliseo.constant.AppConstants.Exceptions.IT_IS_NECESSARY_TO_ORDER_AT_LEAST_2_COURSES;
import static com.eliseo.constant.AppConstants.Exceptions.START_DATE_IS_AFTER_END_DATE_ERROR;
import static com.eliseo.constant.AppConstants.Exceptions.STORE_ALREADY_CLOSE;
import static com.eliseo.constant.AppConstants.Exceptions.STORE_HAS_NOT_OPEN_YET;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import com.eliseo.dtos.OrderRequestDTO;
import com.eliseo.exceptions.BusinessValidationException;
import com.eliseo.exceptions.DateValidationException;

public final class OrdersValidations {
	
	private OrdersValidations() {
		
	}
	
	public static void validateStartDateIsBeforeEndDate(LocalDate startDate, LocalDate endDate) {
		if (startDate.isAfter(endDate)) {
			throw new DateValidationException( START_DATE_IS_AFTER_END_DATE_ERROR );
		}
	}
	
	public static void validateStoreAlreadyOpen(LocalTime openTimeStore) {
		if (openTimeStore.isBefore( LocalTime.now(ZoneId.of("America/Mexico_City"))) ) {
			throw new DateValidationException( STORE_HAS_NOT_OPEN_YET );
		}
	}
	
	public static void validateStoreHasNotAlreadyClose(LocalTime closeTimeStore) {
		if (closeTimeStore.isBefore( LocalTime.now(ZoneId.of("America/Mexico_City"))) ) {
			throw new DateValidationException( STORE_ALREADY_CLOSE );
		}
	}
	
	public static void validateAtLeast2Orders(OrderRequestDTO orderDTO) {
		if (orderDTO.getCoursDetailsDTO().isEmpty() || orderDTO.getCoursDetailsDTO().size() < 2) {
			throw new BusinessValidationException(IT_IS_NECESSARY_TO_ORDER_AT_LEAST_2_COURSES);
		}
	}
	
}
