package com.hms.exception;

public class InvalidPatientException extends RuntimeException {
	String message;

	public InvalidPatientException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}
