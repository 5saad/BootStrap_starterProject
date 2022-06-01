package com.qa.starterproject.config;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
	
	@Bean
	public String serverStart() {
		return "Server started at: " + LocalTime.now();
	}
	
	@Bean
	@Primary
	public String test() {
		return "this is a test";
	}
	
	@Bean
	public ModelMapper mapToDTO() {
		return new ModelMapper();
	}

}
