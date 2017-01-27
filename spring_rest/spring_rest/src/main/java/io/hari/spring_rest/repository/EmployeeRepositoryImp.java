package io.hari.spring_rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import io.hari.spring_rest.entity.Employee;

@Repository
public class EmployeeRepositoryImp implements EmployeeRepository{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Employee> findAll() {
		
		return null;
	}

	@Override
	public Employee find(String id) {
		
		return null;
	}
	public Employee findby(String email){
		return null;
	}

	@Override
	public Employee create(Employee emp) {
		
		return null;
	}

	@Override
	public Employee update(Employee emp) {
		
		return null;
	}

	@Override
	public void delete(Employee emp) {
		
		
	}

}
