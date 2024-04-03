package com.test.safeway.services.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {super(message);
	}

}
