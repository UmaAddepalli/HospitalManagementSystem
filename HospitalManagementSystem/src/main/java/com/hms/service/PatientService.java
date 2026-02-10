package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.exception.InvalidPatientException;
import com.hms.model.Doctor;
import com.hms.model.Patient;
import com.hms.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public Patient getPatientById(Integer id) {
		return patientRepository.findById(id).orElseThrow(() -> new InvalidPatientException("Patient not found with id: " + id));
	}

	public List<Patient> getAllPatients() {
		 List<Patient> patients = patientRepository.findAll();
		 if (patients.isEmpty()) {
			 throw new InvalidPatientException("No patients found");
		 }
		 return patients;
	}

	public Patient updatePatient(Patient patient, Integer id) {
		 Patient pat = patientRepository.findById(id).orElseThrow(() -> new InvalidPatientException("Patient not found with id: " + id));
		 pat.setName(patient.getName());
		 pat.setAge(patient.getAge());
		 pat.setGender(patient.getGender());
		 pat.setMobileNumber(patient.getMobileNumber());
		 pat.setDisease(patient.getDisease());
		 pat.setFee(patient.getFee());
		 pat.setDoctor(patient.getDoctor());
		 patientRepository.save(pat);
		 return pat;
	}

	public void deletePatient(Integer id) {
		if(patientRepository.existsById(id)) {
			patientRepository.deleteById(id);
		} else {
			throw new InvalidPatientException("Patient not found with id: " + id);
		}
	}
}
