package com.qa.starterproject.dto;

import java.util.List;

import com.qa.starterproject.domain.Car;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverDto {
	
	private Long id;
	private double hands;
	private double feet;
	private List<Car> cars;

}
