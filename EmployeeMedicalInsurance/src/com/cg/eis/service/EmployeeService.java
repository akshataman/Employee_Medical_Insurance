package com.cg.eis.service;

import java.util.Map;

import com.cg.dao.EmployeeDAOImpl;
import com.cg.eis.bean.Employee;

public interface EmployeeService {
	EmployeeDAOImpl dao = new EmployeeDAOImpl();
	//public Employee selectInsurance(Employee e);
	public boolean addEmployee(Employee e);
	public boolean removeEmployee(int l);
	public Employee findEmployee(int id);

	public default void printStatement(Employee e)
	{
		System.out.println("======================================");
		System.out.println("Employee Name:"+e.getName());
		System.out.println("Employee Id:"+e.getId());
		System.out.println("Employee salary:"+e.getSalary());
		System.out.println("Employee Designation:"+e.getDesignation());
		System.out.println("Employee Allocated Insurance Scheme:"+e.getInsuranceScheme());
		System.out.println("======================================");
	}
	public Map<Integer, Employee> getAllAccount();

}