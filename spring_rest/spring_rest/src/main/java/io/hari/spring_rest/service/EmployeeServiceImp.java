package io.hari.spring_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hari.spring_rest.entity.Employee;
import io.hari.spring_rest.exception.EmployeeAlreadyExistException;
import io.hari.spring_rest.exception.EmployeeNotFoundException;
import io.hari.spring_rest.repository.EmployeeRepository;
import io.hari.spring_rest.repository.EmployeeRepositoryImp;

@Service 
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	EmployeeRepositoryImp Repository;
	
	@Override
	public List<Employee> findAll() {
		
		return Repository.findAll();
	}

	@Override
	public Employee find(String id) {
		Employee existing=Repository.find(id);
		if(existing == null)
		{
			throw new EmployeeNotFoundException("Employee Not Found");
		}
		return Repository.find(id);
	}

	@Override
	@Transactional
	public Employee create(Employee emp) {
		Employee ifexist=Repository.findby(emp.getEmailId());
		if(ifexist != null)
		{
			throw new EmployeeAlreadyExistException("Employee with similar email already exists");
		}
		return Repository.create(emp);
	}

	@Override
	@Transactional
	public Employee update(String id, Employee emp) {
		Employee ifexist=Repository.find(id);
		if(ifexist != null)
		{
			throw new EmployeeNotFoundException("this employee is not registered");
		}
		return Repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String empid) {
		Employee ifexist=Repository.find(empid);
		if(ifexist != null)
		{
			throw new EmployeeNotFoundException("this employee is not registered");
		}
		Repository.delete(ifexist);
	}
	

}
