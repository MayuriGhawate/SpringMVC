package com.hospital.config.service;

import java.util.List;

import com.hospital.config.entities.Patient;


public interface PatientService {
	
	public List<Patient> findAll();
	public Patient find(int pid);
	public void create(Patient patient);
	public void update(Patient patient);
	public void delete(Patient patient1);

}
