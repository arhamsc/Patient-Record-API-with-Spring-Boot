package com.example.patientManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.patientManagement.entity.Patient;
import com.example.patientManagement.services.PatientServices;

@RestController
public class PatientControllers {
	
	@Autowired
	private PatientServices patientServices;
	
	@GetMapping("/patients")
	public List<Patient>  getAllPatients() {
		return patientServices.getAllPatients();
	}
	
	@GetMapping("/patients/byFields")
	public Patient getPatientByName(@RequestParam String name) {
		return patientServices.getPatientByName(name);
	}
	
	@GetMapping("/patients/byDisease")
	public List<Patient> getPatientsByDisease(@RequestParam String disease) {
		return patientServices.getPatientsByDiseases(disease);
	}
	
	@GetMapping("/patients/byConsultingDoc") 
	public List<Patient> getPatientsByConsultingDoc(@RequestParam String consultingDoc) {
		return patientServices.getPatientByConsultingDoc(consultingDoc);
	}
	
	@GetMapping("patients/getAllDiseases")
	public List<String> getAllDiseases() {
		return patientServices.getAllDiseases();
	}
	
	@PostMapping("/patients")
	public Patient admitPatient(@RequestBody Patient patient) {
		return patientServices.admitPatient(patient);
	}
	
	@PutMapping("/patients/{patientId}")
	public Patient updatePatientRecord(@RequestBody Patient patient, @PathVariable int patientId) {
			return patientServices.updatePatient(patient, patientId);
	}
	
	@DeleteMapping("/patients/{patientId}")
	public String disChargePatient(@PathVariable int patientId) {
		patientServices.dischargePatient(patientId);
		return "Patient Discharged";
	}
	
}
