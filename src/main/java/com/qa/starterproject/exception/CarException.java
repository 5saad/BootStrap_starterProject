package com.qa.starterproject.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car does not exist")
public class CarException extends EntityNotFoundException {

	private static final long serialVersionUID = 1986216999263310510L;


}
