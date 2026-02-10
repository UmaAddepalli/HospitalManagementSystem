package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.exception.InvalidDoctorException;
import com.hms.model.Doctor;
import com.hms.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor getDoctorById(Integer id) {
		return doctorRepository.findById(id).orElseThrow(() -> new InvalidDoctorException("Doctor not found with id: " + id));
	}

	public List<Doctor> getAllDoctors() {
		 List<Doctor> doctors = doctorRepository.findAll();
		 if (doctors.isEmpty()) {
			 throw new InvalidDoctorException("No doctors found");
		 }
		 return doctors;
	}

	public Doctor updateDoctor(Doctor doctor, Integer id) {
		 Doctor doc = doctorRepository.findById(id).orElseThrow(() -> new InvalidDoctorException("Doctor not found with id: " + id));
		 doc.setName(doctor.getName());
		 doc.setSpecialization(doctor.getSpecialization());
		 doc.setEmail(doctor.getEmail());
		 doc.setAge(doctor.getAge());
		 doc.setMobileNumber(doctor.getMobileNumber());
		 doc.setGender(doctor.getGender());
		 doctorRepository.save(doc);
		return doc;
	}

	public void deleteDoctor(Integer id) {
		doctorRepository.findById(id).orElseThrow(() -> new InvalidDoctorException("Doctor not found with id: " + id));
		doctorRepository.deleteById(id);
	}
}
