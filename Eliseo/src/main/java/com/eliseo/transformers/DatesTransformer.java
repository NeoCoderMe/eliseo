package com.eliseo.transformers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DatesTransformer {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private DatesTransformer() {
		
	}
	
	/**
	 * Throws: DateTimeParseException
	 * @param datePlainText dd-MM-yyyy
	 * @return the parsed local date, not null
	 */
	public static LocalDate dateTime(String datePlainText) {
		 return LocalDate.parse(datePlainText, formatter);
	}
	
}
