package com.eliseo.config;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreTimeConfig {
	
	@Value( "${store.time.open}" )
	private String openTime;
	
	@Value( "${store.time.close}" )
	private String closeTime;
	
	public LocalTime getOpenTime() {
		return LocalTime.parse(openTime);
	}
	
	public LocalTime getCloseTime() {
		return LocalTime.parse(closeTime);
	}
}
