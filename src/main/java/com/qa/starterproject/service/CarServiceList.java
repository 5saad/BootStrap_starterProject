package com.qa.starterproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.starterproject.domain.Car;

@Service
public class CarServiceList {

	public List<Car> cars = new ArrayList<>();

	public Car create(Car Car) {
		this.cars.add(Car);
		return this.cars.get(this.cars.size() - 1);
	}

	public List<Car> readAll() {
		return this.cars;
	}

//	public Car readId(int id) {
//		return this.cars.get(id);
//	}

	public Car update(int id, Car Car) {
		this.cars.remove(id);
		this.cars.add(id-1, Car);
		return this.cars.get(id);
	}

	public boolean delete(int id) {
		return this.cars.remove(id-1) != null;
	}

}
