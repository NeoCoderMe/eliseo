package com.eliseo.constant;

import java.time.ZoneId;

public final class AppConstants {

	public static final class Controllers{
		public static final String USER_CONTROLLER_ADD = "UsersController createUser method";
		public static final String USER_CONTROLLER_GET_ALL = "UsersController getAllUsers method";
		
		public static final String COURS_CONTROLLER_ADD = "CoursesController createCours method";
		public static final String COURS_CONTROLLER_GET_ALL = "CoursesController getAllCourses method";
		
		public static final String ORDERS_CONTROLLER_ADD = "OrdersController createOrder method";
		public static final String ORDERS_CONTROLLER_GET_ALL = "OrdersController getAllOrders method";
		
		
		private Controllers() {
			
		}
		
	}
	
	public static final class Exceptions{
		public static final String START_DATE_IS_AFTER_END_DATE_ERROR = "Start date cannot be after end date";
		public static final String STORE_HAS_NOT_OPEN_YET = "Store has not open yet";
		public static final String STORE_ALREADY_CLOSE = "Store already close";
		public static final String IT_IS_NECESSARY_TO_ORDER_AT_LEAST_2_COURSES = "it is necessary to order at least 2 courses";
		
		private Exceptions() {
			
		}
	}
	
	public static final class TimeZones{
		
		private TimeZones() {
			
		}
		
		public static final ZoneId  MEXICO_CITY_ZONE =ZoneId.of("America/Mexico_City");
	}
	
	private AppConstants() {
		
	}
	
}
