package com.qa.starterproject.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Driver {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "hands")
	private double hands;
	
	@Column(length = 2)
	private double feet;
	
	@OneToMany(mappedBy = "driver")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Car> cars = new ArrayList<>();
	
}
