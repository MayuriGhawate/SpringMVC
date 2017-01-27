package io.hari.spring_rest.repository;

import java.util.List;

import io.hari.spring_rest.entity.Employee;

public interface EmployeeRepository {

	public List<Employee> findAll();
	public Employee find(String id);
	public Employee findby(String email);
	public Employee create(Employee emp);
	public Employee update(Employee emp);
	public void delete(Employee emp);
}
