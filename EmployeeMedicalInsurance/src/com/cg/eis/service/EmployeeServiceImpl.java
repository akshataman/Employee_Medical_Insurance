
package com.cg.eis.service;

import java.util.Map;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService{


	@Override
	public boolean addEmployee(Employee e) {
		return dao.addEmployee(e);
	}

	@Override
	public boolean removeEmployee(int l) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(l);
	}
	@Override
	public Map<Integer,Employee> getAllAccount() {
		return dao.printEmpDetails();
	}

	public String getScheme(String desg, double sal) {
		String insuranceScheme="";
		String tempDes = desg;
		if((sal>5000) && (sal<20000) && (tempDes.equals("System Associate")))
		{
			insuranceScheme = "Scheme C";
		}
		else if((sal>=20000) && (sal<40000 ) && (tempDes.equals("Programmer")))
		{
			insuranceScheme = "Scheme B";
		}
		else if((sal>=40000) && (tempDes.equals("Manager")))
		{
			insuranceScheme = "Scheme A";
		}
		else if((sal<=5000) && (tempDes.equals("Clerk")))
		{
			insuranceScheme = "No Scheme";
		}
		else
			insuranceScheme = "No Scheme";

		return insuranceScheme;
	}

	@Override
	public Employee findEmployee(int id) {
				return dao.findEmployee(id);
	}
	
}