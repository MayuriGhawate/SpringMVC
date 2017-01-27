package com.hospital.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.config.entities.Patient;
import com.hospital.config.service.PatientService;


@RestController
public class PatientController {
	
	@Autowired
	PatientService service;
	@RequestMapping(method=RequestMethod.GET, path="/patient/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Patient PatientByID(@PathVariable("id") int pid){
		Patient patient = service.find(pid);
		return patient;
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/patient", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Patient> findAll(){
		System.out.println("Hello ");
		
				List<Patient> list=service.findAll();
				return list;
	}
	@RequestMapping(value ="/patient", method = RequestMethod.POST)
	public void create(@RequestBody Patient patient )
	{
		
		service.create(patient);
		
	}
	@RequestMapping(method=RequestMethod.PUT, path="/patient/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@PathVariable("id") int pid, @RequestBody Patient patient)
	{
		service.update(patient);
		
	}
	@RequestMapping(value ="/patient/{id}", method =RequestMethod.DELETE)
	public void delete(@PathVariable("id") int pid)
	{
		Patient patient1 = service.find(pid);
		service.delete(patient1);
	}

}

	


