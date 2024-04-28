package com.test.safeway.controllers.exceptions;

import com.test.safeway.services.exceptions.InsufficientFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.safeway.services.exceptions.CompanyNotFoundException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<String> handleCompanyNotFound(CompanyNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleCompanyNotFound(NoSuchElementException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<String> handleAccountForbidden(InsufficientFundsException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
	}
}
