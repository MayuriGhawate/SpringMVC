package com.hospital.config.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.config.entities.Patient;
import com.hospital.config.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImplementation implements PatientService {

	
	@Autowired
	PatientRepository repo;
	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Patient find(int pid) {
		
		return repo.find(pid);
	}

	@Override
	public void create(Patient patient) {
	System.out.println("XYZ");
		repo.create(patient);
	}

	@Override
	public void update(Patient patient) {
	repo.update(patient);
		
	}

	@Override
	public void delete(Patient patient1) {
		repo.delete(patient1);
		
	}

	

}
