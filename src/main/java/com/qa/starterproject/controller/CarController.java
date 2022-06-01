package com.qa.starterproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.domain.Car;
import com.qa.starterproject.dto.CarDto;
import com.qa.starterproject.serviceDto.CarServiceDto;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

	private CarServiceDto service;

	public CarController(CarServiceDto service) {
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<CarDto> create(@RequestBody Car car) {
		return new ResponseEntity<CarDto>(this.service.create(car), HttpStatus.CREATED);
	}

	// read
	@GetMapping("/readAll")
	public ResponseEntity<List<CarDto>> read() {
		return new ResponseEntity<List<CarDto>>(this.service.readAll(), HttpStatus.OK);
	}

	// read ID
	@GetMapping("/read/{id}")
	public ResponseEntity<CarDto> readId(@PathVariable Long id) throws Exception {
		return new ResponseEntity<CarDto>(this.service.readId(id), HttpStatus.OK);
	}

	// find by make
	@GetMapping("/make/{str}")
	public ResponseEntity<List<CarDto>> findByMake(@PathVariable String str) {
		return new ResponseEntity<List<CarDto>>(this.service.findByMake(str), HttpStatus.OK);
	}
	
	// show less than 
		@GetMapping("/lessthan/{num}")
		public ResponseEntity<List<CarDto>> lessThan(@PathVariable int num) {
			return new ResponseEntity<List<CarDto>>(this.service.lessThan(num), HttpStatus.OK);
		}

	// update
	@PutMapping("/update/{id}")
	public ResponseEntity<CarDto> update(@PathVariable Long id, @RequestBody Car car) throws Exception {
		return new ResponseEntity<CarDto>(this.service.update(id, car), HttpStatus.ACCEPTED);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
