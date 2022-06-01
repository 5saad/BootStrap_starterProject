package com.qa.starterproject.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String make;
	private int wheels;
	private int cost;
	private String plateNumber;
	
	@ManyToOne(targetEntity = Driver.class)
	private Driver driver;

}
