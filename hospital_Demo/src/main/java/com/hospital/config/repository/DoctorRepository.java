package com.hospital.config.repository;

import java.util.List;

import com.hospital.config.entities.Patient;

public interface DoctorRepository {
	public List<Patient> findAll();
	public Patient find(int pid);
	public Patient findby(String firstName);
	public void create(Patient lastName);
	public void update(Patient pid);
	public void delete(Patient patient1);

}
