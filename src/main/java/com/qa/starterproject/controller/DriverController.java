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

import com.qa.starterproject.domain.Driver;
import com.qa.starterproject.dto.DriverDto;
import com.qa.starterproject.serviceDto.DriverServiceDto;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

	private DriverServiceDto service;

	public DriverController(DriverServiceDto service) {
		this.service = service;
	}

	// create
	@PostMapping("/create")
	public ResponseEntity<DriverDto> create(@RequestBody Driver driver) {
		return new ResponseEntity<DriverDto>(this.service.create(driver), HttpStatus.CREATED);
	}

	// read
	@GetMapping("/readAll")
	public ResponseEntity<List<DriverDto>> read() {
		return new ResponseEntity<List<DriverDto>>(this.service.readAll(), HttpStatus.OK);
	}

	// read ID
	@GetMapping("/read/{id}")
	public ResponseEntity<DriverDto> readId(@PathVariable Long id) throws Exception {
		return new ResponseEntity<DriverDto>(this.service.readId(id), HttpStatus.OK);
	}


	// update
	@PutMapping("/update/{id}")
	public ResponseEntity<DriverDto> update(@PathVariable Long id, @RequestBody Driver driver) throws Exception {
		return new ResponseEntity<DriverDto>(this.service.update(id, driver), HttpStatus.ACCEPTED);
	}

	// delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
