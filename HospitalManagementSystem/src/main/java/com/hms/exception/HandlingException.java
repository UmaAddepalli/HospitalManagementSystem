package com.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import com.hms.model.Doctor;

@ControllerAdvice
public class HandlingException {
	@ExceptionHandler(value = InvalidDoctorException.class)
	public ResponseEntity<String> doctorException(InvalidDoctorException doctor) {
		return new ResponseEntity<String>(doctor.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = InvalidPatientException.class)
	public ResponseEntity<String> patientException(InvalidPatientException patient) {
		return new ResponseEntity<String>(patient.getMessage(), HttpStatus.NOT_FOUND);
	}
}
