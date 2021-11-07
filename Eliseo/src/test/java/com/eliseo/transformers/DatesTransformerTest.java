package com.eliseo.transformers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class DatesTransformerTest {

	@Test
	void testDateTime() {
		LocalDate date =DatesTransformer.dateTime("19-09-2021");
		assertEquals("2021-09-19", date.toString());
	}

}
