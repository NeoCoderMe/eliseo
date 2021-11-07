package com.eliseo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com"})
public class EliseoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EliseoApplication.class, args);
	}

}
