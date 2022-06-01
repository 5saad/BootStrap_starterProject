package com.qa.starterproject.serviceDto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.starterproject.domain.Driver;
import com.qa.starterproject.dto.DriverDto;
import com.qa.starterproject.exception.DriverException;
import com.qa.starterproject.repo.DriverRepo;

@Service
public class DriverServiceDto {
	
	private ModelMapper mapper;

	private DriverRepo repo;

	public DriverServiceDto(DriverRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private DriverDto mapToDto(Driver driver) {
		return this.mapper.map(driver, DriverDto.class);
	}

	// create DTO
	public DriverDto create(Driver driver) {
		return this.mapToDto(this.repo.save(driver));
	}



	// read DTO
	public List<DriverDto> readAll() {
			return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
		}


	
	// read by id DTO
	public DriverDto readId(Long id) throws DriverException {
		return this.mapToDto(this.repo.findById(id).orElseThrow(DriverException::new));
	}

	
	// update DTO
	public DriverDto update(Long id, Driver driver) throws DriverException {
		Driver exists = this.repo.findById(id).orElseThrow(DriverException::new);
		exists.setHands(driver.getHands());
		exists.setFeet(driver.getFeet());
		return this.mapToDto(this.repo.saveAndFlush(exists));
	}



	// delete
	public boolean delete(Long id) throws DriverException {
		this.repo.findById(id).orElseThrow(DriverException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}


}
