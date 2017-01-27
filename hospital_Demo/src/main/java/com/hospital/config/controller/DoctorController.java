package com.hospital.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.config.entities.Doctor;
import com.hospital.config.entities.Patient;

@RestController
public class DoctorController {
	
	@Autowired
	Doctor doctor;
	
	/*@RequestMapping(method=RequestMethod.GET, path="/patient/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Patient PatientByID(@PathVariable("id") int pid){
		Patient patient = doctor.find(pid);
		return patient;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/patient", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Patient> findAll(){
		System.out.println("Hello ");
		
				List<Patient> list=service.findAll();
				return list;
	}*/
	
	@RequestMapping(value ="/doctor", method = RequestMethod.POST)
	public void create(@RequestBody Patient patient )
	{
		
		doctor.insertDoctor(doctor);
		
	}
	
	/*@RequestMapping(method=RequestMethod.PUT, path="/patient/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@PathVariable("id") int pid, @RequestBody Patient patient)
	{
		service.update(patient);
		
	}
	@RequestMapping(value ="/patient/{id}", method =RequestMethod.DELETE)
	public void delete(@PathVariable("id") int pid)
	{
		Patient patient1 = service.find(pid);
		service.delete(patient1);
	}*/

}
	
	

}
