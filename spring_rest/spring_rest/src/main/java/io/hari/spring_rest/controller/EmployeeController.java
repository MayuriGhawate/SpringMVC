package io.hari.spring_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.hari.spring_rest.entity.Employee;
import io.hari.spring_rest.service.EmployeeService;
import io.hari.spring_rest.service.EmployeeServiceImp;

@Controller 			// meta annotation works similar to component annotations//
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImp service;
	@RequestMapping(method=RequestMethod.GET, path="/employees", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Employee> findAll(){
		return service.findAll();
		
	}
	@RequestMapping(method=RequestMethod.GET, path="/employees/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee find(@PathVariable("id") String empid)
	{
		return service.find(empid);
		
	}
	@RequestMapping(method=RequestMethod.POST, path="/employees",produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee create(@RequestBody Employee emp )
	{
		return service.create(emp);
		
	}
	@RequestMapping(method=RequestMethod.PUT, path="/employees/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Employee update(@PathVariable("id") String empid, @RequestBody Employee emp)
	{
		return service.update(empid, emp);
		
	}
	@RequestMapping(method=RequestMethod.DELETE, path="/employees/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String empid)
	{
		service.delete(empid);
	}

}
