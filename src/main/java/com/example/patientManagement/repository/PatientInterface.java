package com.example.patientManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patientManagement.entity.Patient;

@Repository
public interface PatientInterface extends JpaRepository<Patient, Integer> {
	
	public Patient findByPatientName(String name);
	
	public List<Patient> findByConsultingDoc(String consultingDoc);
	
}
