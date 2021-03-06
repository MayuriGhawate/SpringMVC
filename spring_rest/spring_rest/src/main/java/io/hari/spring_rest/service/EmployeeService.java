package io.hari.spring_rest.service;

import java.util.List;

import io.hari.spring_rest.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee find(String id);
	public Employee create(Employee emp);
	public Employee update(String id, Employee emp);
	public void delete(String id);
	
	
	
}
