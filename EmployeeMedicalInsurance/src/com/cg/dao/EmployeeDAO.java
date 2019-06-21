package com.cg.dao;

import java.util.Map;

import com.cg.eis.bean.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee e);
	public boolean deleteEmployee(int l);
	public Employee findEmployee(int l);
	public Map<Integer,Employee> printEmpDetails();

}