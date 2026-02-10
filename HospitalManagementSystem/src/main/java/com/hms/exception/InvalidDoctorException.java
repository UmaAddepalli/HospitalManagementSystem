package com.hms.exception;

public class InvalidDoctorException extends RuntimeException {
	String message;

	public InvalidDoctorException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
