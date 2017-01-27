package com.xml.project12Model;

public class Employee {
	
	private String empName;
	private String empDesc;
	
	public Employee(String empName,String empDesc){
		this.empName=empName;
		this.empDesc=empDesc;
		
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesc() {
		return empDesc;
	}
	public void setEmpDesc(String empDesc) {
		this.empDesc = empDesc;
	}

}
