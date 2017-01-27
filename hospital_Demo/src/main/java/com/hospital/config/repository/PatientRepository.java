package com.hospital.config.repository;

import java.util.List;
import com.hospital.config.entities.Patient;


public interface PatientRepository {
	public List<Patient> findAll();
	public Patient find(int pid);
	public void insertDoctor(Patient patient);
	public void update(Patient patient);
	public void delete(Patient patient1);

}
