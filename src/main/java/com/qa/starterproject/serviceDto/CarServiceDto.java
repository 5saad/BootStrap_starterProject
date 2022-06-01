package com.qa.starterproject.serviceDto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.starterproject.domain.Car;
import com.qa.starterproject.dto.CarDto;
import com.qa.starterproject.exception.CarException;
import com.qa.starterproject.repo.CarRepo;

@Service
public class CarServiceDto {
	
	private ModelMapper mapper;

	private CarRepo repo;

	public CarServiceDto(CarRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private CarDto mapToDto(Car car) {
		return this.mapper.map(car, CarDto.class);
	}

	// create DTO
	public CarDto create(Car car) {
		return this.mapToDto(this.repo.save(car));
	}



	// read DTO
	public List<CarDto> readAll() {
			return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
		}


	
	// read by id DTO
	public CarDto readId(Long id) throws CarException {
		return this.mapToDto(this.repo.findById(id).orElseThrow(CarException::new));
	}

	
	// update DTO
	public CarDto update(Long id, Car car) throws CarException {
		Car exists = this.repo.findById(id).orElseThrow(CarException::new);
		exists.setMake(car.getMake());
		exists.setWheels(car.getWheels());
		exists.setCost(car.getCost());
		exists.setPlateNumber(car.getPlateNumber());
		return this.mapToDto(this.repo.saveAndFlush(exists));
	}



	// delete
	public boolean delete(Long id) throws CarException {
		this.repo.findById(id).orElseThrow(CarException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// find by make DTO
		public List<CarDto> findByMake(String str) {
			return this.repo.findByMake(str).stream().map(this::mapToDto).collect(Collectors.toList());
		}
		
		// cost less than
		public List<CarDto> lessThan(int num) {
			return this.repo.lessThan(num).stream().map(this::mapToDto).collect(Collectors.toList());
		}

}
