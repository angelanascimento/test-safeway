package com.test.safeway.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.safeway.services.exceptions.CompanyNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<String> handleCompanyNotFound(CompanyNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
