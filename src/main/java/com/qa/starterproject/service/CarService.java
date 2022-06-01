package com.qa.starterproject.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.starterproject.domain.Car;
import com.qa.starterproject.exception.CarException;
import com.qa.starterproject.repo.CarRepo;

@Service
public class CarService {

	private CarRepo repo;

	public CarService(CarRepo repo, ModelMapper mapper) {
		this.repo = repo;

	}

	// create
	public Car create(Car car) {
		return this.repo.saveAndFlush(car);
	}

	// read
	public List<Car> readAll() {
		return this.repo.findAll();
	}

	// read by id
	public Car readId(Long id) throws CarException {
		return this.repo.findById(id).orElseThrow(CarException::new);
	}

	// update
	public Car update(Long id, Car car) throws CarException {
		Car exists = this.repo.findById(id).orElseThrow(CarException::new);
		exists.setMake(car.getMake());
		exists.setWheels(car.getWheels());
		exists.setCost(car.getCost());
		return this.repo.saveAndFlush(exists);
	}

	// find by make
	public List<Car> findByMake(String str) {
		return this.repo.findByMake(str);
	}

	// cost less than
	public List<Car> lessThan(int num) {
		return this.repo.lessThan(num);
	}

}
