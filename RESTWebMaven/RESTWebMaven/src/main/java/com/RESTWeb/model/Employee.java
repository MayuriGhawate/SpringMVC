package com.RESTWeb.model;

public class Employee {
	private int empId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	private String empName;
	public String getEmpName() {
		return empName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
