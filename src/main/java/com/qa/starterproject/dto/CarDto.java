package com.qa.starterproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CarDto {
	
	private Long id;
	private String make;
	private int wheels;
	private int cost;
		

}
