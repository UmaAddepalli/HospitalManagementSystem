package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.model.Doctor;
import com.hms.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		Doctor doc = doctorService.saveDoctor(doctor);
		return new ResponseEntity<Doctor>(doc, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) {
		Doctor doc = doctorService.getDoctorById(id);
		return new ResponseEntity<Doctor>(doc, HttpStatus.FOUND);
	}
	
	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Integer id) {
		Doctor doc = doctorService.updateDoctor(doctor, id);
		return new ResponseEntity<Doctor>(doc, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Integer id) {
		doctorService.deleteDoctor(id);
		return new ResponseEntity<String>("Doctor deleted successfully", HttpStatus.FOUND);
	}
}