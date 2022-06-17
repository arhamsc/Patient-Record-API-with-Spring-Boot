package com.example.patientManagement.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patientManagement.entity.Patient;
import com.example.patientManagement.repository.PatientInterface;

@Service
public class PatientServices {
	@Autowired
	private PatientInterface patientInterface;

	// Admitting a Patient Service - Saves the patient Record to the database
	public Patient admitPatient(Patient patient) {
		return patientInterface.save(patient);
	}

	// Fetches all the patients from the record
	public List<Patient> getAllPatients() {
		return patientInterface.findAll();
	}

	// Find patients by diseases
	public List<Patient> getPatientsByDiseases(String disease) {
		ArrayList<Patient> foundPatients = new ArrayList<Patient>();

		List<Patient> patients = patientInterface.findAll();
		patients.forEach(patient -> {
			ArrayList<String> dis = new ArrayList<String>(Arrays.asList(patient.getDiseases()));
			if (dis.contains(disease)) {
				foundPatients.add(patient);
			}
		});
		return foundPatients;
	}

	// Get patients by consulting docs
	public List<Patient> getPatientByConsultingDoc(String consultingDoc) {
		return patientInterface.findByConsultingDoc(consultingDoc);
	}

	// Get all the diseases list
	public List<String> getAllDiseases() {
		HashSet<String> diseases = new HashSet<String>();

		List<Patient> patients = patientInterface.findAll();
		patients.forEach(patient -> {
			for (String disease : patient.getDiseases()) {
				diseases.add(disease);
			}
		});
		
		List<String> list= new ArrayList<String>(diseases);
		return list;
	}

	// Updates the patient records
	public Patient updatePatient(Patient patient, int patientId) {
		return patientInterface.findById(patientId).map(pat -> {
			pat.setConsultingDoc(patient.getConsultingDoc());
			pat.setDiseases(patient.getDiseases());
			pat.setHospital(patient.getHospital());
			pat.setPatientName(patient.getPatientName());
			return patientInterface.save(pat);
		}).orElseGet(null);
	}

	// Discharges the patient - deletes the patient record
	public void dischargePatient(int patientId) {
		patientInterface.deleteById(patientId);
	}

	// EXTRA METHODS
	public Patient getPatientByName(String name) {
		return patientInterface.findByPatientName(name);
	}
}
