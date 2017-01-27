package com.xml.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.project12Model.Employee;

@RestController
public class EmployeeController {
	
	@RequestMapping("/")
	public String display(){
		return "Welcome ";
		
	}
	@RequestMapping("/descrip/{employeemessage}")
	public Employee employeemessage(@PathVariable String employeemessage){
		Employee e1 = new Employee(employeemessage,"welcome" +employeemessage);
		return e1;
	}
	

}
