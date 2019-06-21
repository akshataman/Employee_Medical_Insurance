
package com.cg.eis.bean;

import com.cg.eis.service.EmployeeServiceImpl;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String designation;
	private String insuranceScheme;
	
		
	public Employee() {
		super();
	}
	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	
	
	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}
	public Employee(int id, String name, double sal, String designation,String insuranceScheme) {
		super();
		this.id = id;
		this.name = name;
		this.salary = sal;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ ", insuranceScheme=" + insuranceScheme + "]";
	}
	

}