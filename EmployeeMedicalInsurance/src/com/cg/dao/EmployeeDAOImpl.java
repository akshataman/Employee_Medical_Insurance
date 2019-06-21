package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.eis.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	static Map<Integer,Employee> hsmp = new HashMap<Integer,Employee>();

	@Override
	public boolean addEmployee(Employee e) {
		hsmp.put(e.getId(), e);
		return true;
	}

	@Override
	public boolean deleteEmployee(int l) {
		hsmp.remove(l);
		return true;
	}

	@Override
	public Employee findEmployee(int l) {
		Employee emp = hsmp.get(l);
		return emp;
	}

	@Override
	public Map<Integer, Employee> printEmpDetails() {
		// TODO Auto-generated method stub
		return hsmp;
	}

}