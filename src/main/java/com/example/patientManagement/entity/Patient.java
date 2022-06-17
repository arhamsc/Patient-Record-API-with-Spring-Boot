package com.example.patientManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient_Record")

public class Patient {
	
	@Id
	@GeneratedValue
	private int patientId;
	
	private String patientName;
	private String[] diseases;
	private String consultingDoc;
	private String hospital;

}
