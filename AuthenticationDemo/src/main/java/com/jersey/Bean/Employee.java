package com.jersey.Bean;

public class Employee {
	
	private Integer Id;
	private String name;
	
	public Employee(){}
	
	public Employee(Integer Id,String Name){
		this.Id=Id;
		this.name=name;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + "]";
	}
	

}
