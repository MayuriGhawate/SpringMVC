package com.hospital.config.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hospital.config.entities.Patient;

@Repository
public class PatientRepositoryImpl implements PatientRepository{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<com.hospital.config.entities.Patient> findAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Patient> list=em.createQuery("From Patient").getResultList();
		return list;
	}

	@Override
	public com.hospital.config.entities.Patient find(int pid) {
		return em.find(Patient.class, pid);
	
	}

	@Override
	public com.hospital.config.entities.Patient findby(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(com.hospital.config.entities.Patient patient) {
     em.persist(patient);
		
	}

	@Override
	public void update(com.hospital.config.entities.Patient patient) {
	    em.merge(patient);
		
	}

	@Override
	public void delete(Patient patient1) {
		
		Patient p = em.merge(patient1);
		em.remove(p);
	}

}
