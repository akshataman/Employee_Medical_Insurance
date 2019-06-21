
package com.cg.eis.pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceImpl;
import com.cg.eis.service.*;
public class MainPage {

	public static void main(String[] args) throws IOException {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	while(true) {	
		System.out.println("Menu");
		System.out.println("===========================================");
		System.out.println("1.Add Employee");
		System.out.println("2.Delete Employee");
		System.out.println("3.PrintEmployeeDetails");
		System.out.println("4.Find Insurance Scheme");
		System.out.println("5.Find and Print Account");
		System.out.println("6.Exit");
		System.out.println("Enter your choice...");
		System.out.println("===========================================");
		
		String choice = br.readLine();
		
		switch(choice)
		{
		case "1": int id= 0; String name ="";double sal = 0L;String desg="";
					System.out.println("Enter Employee ID:");
					while(true) {
								String id1 = br.readLine();
								boolean ch1 = Validator.validateData(id1, Validator.idPattern);
								if(ch1==true) {
									try{
										id = Integer.parseInt(id1);
										break;
										}
									catch(NumberFormatException e)
									{
										System.out.println("Enter ID again!");
									}
												}
									
								else
									{
										System.out.println("Please enter ID in digits only! :");
									}
								}
					System.out.println("Enter Employee name:");
					while(true)
					{
						String id1=br.readLine();
						boolean ch1 = Validator.validateData(id1, Validator.namePattern);
						if(ch1==true)
						{
							try {
								name=id1;
								break;
							}catch(Exception e)
							{
								System.out.println("Enter valid name:");
							}
						}
						else
						{
							System.out.println("Enter Name:");
						}
					}
					System.out.println("Enter Salary:");
					while(true)
					{
						String id1 = br.readLine();
						boolean ch1 = Validator.validateData(id1, Validator.salPattern);
						if(ch1 == true)
						{
							try {
								sal = Double.parseDouble(id1);
								break;
								}
							catch(Exception e)
							{
								System.out.println("Enter Salary Again!");
							}
						}
						else
						{
							System.out.println("Enter Salary:");
						}
						
					}
					System.out.println("Enter Designation:");
					while(true)
					{
						String id1 = br.readLine();
						boolean ch1 = Validator.compareData(id1);
						if(ch1 == true)
						{
							try {
								desg = id1;
								break;
							}
							catch(Exception e){
								System.out.println("Try again!");
							}
						}
						else
						{
							System.out.println("Enter Designation:");
						}
					}
					Employee emp = new Employee(id,name,sal,desg,null);
					String sch = service.getScheme(desg,sal);
					emp.setInsuranceScheme(sch);
					service.addEmployee(emp);
					System.out.println("Employee Added Successfully.!");
					
			break;
			
		case "2":System.out.println("Enter ID of the employee to be removed:");
					int id2;
					while(true) {
						String id1 = br.readLine();
						boolean ch1 = Validator.validateData(id1, Validator.idPattern);
						if(ch1 == true)
						{
							try {
								id2 = Integer.parseInt(id1);
								break;
							}
							catch(Exception e){
								System.out.println("Enter Id once again...");
							}
						}
						else
						{
							System.out.println("Enter Id of the Employee:");
						}
								}
					boolean b1 = service.removeEmployee(id2);
					if(b1)
					{
						System.out.println("Deleted Successfully!");
					}
					else
					{
						System.out.println("Try Again.Enter valid(present) id!");
					}
					break;
					
		case "3":Map<Integer,Employee> accmap=service.getAllAccount();
					Collection<Employee> vc = accmap.values();
					List<Employee> acclist=new ArrayList<Employee>(vc);
					if(acclist.size() == 0)
					{
						System.out.println("No Employees added!");
					}
					else {
						for(Employee e: acclist)
							{
								service.printStatement(e);
							}
					}
						break;
						
		case "4":System.out.println("Please enter designation:");
					while(true)
						{
						String id1 = br.readLine();
						boolean ch1 = Validator.compareData(id1);
						if(ch1 == true)
							{
								try {
									desg = id1;
									break;
								}
								catch(Exception e){
									System.out.println("Try again!");
								}
							}
						else
						{
							System.out.println("Enter Designation:");
						}
						}
					System.out.println("Enter Salary:");
					while(true)
					{
						String id1 = br.readLine();
						boolean ch1 = Validator.validateData(id1, Validator.salPattern);
						if(ch1 == true)
						{
							try {
								sal = Double.parseDouble(id1);
								break;
								}
							catch(Exception e)
							{
								System.out.println("Enter Salary Again!");
							}
						}
						else
						{
							System.out.println("Enter Salary:");
						}
						
					}
					System.out.println("The Insurance Scheme for you is :"+service.getScheme(desg,sal));
					
					
			break;
			
		case "5":System.out.println("Enter ID of the employee :");
					int id3;
						while(true) {
							String id1 = br.readLine();
							boolean ch1 = Validator.validateData(id1, Validator.idPattern);
							if(ch1 == true)
							{
								try {
									id3 = Integer.parseInt(id1);
									break;
									}
								catch(Exception e){
									System.out.println("Enter Id once again...");
								}
							}
							else
							{
								System.out.println("Enter Id of the Employee:");
							}
									}
			Employee e = service.findEmployee(id3);	
			if(e!=null)
			{
				System.out.println("Account Found!");
				service.printStatement(e);
			}
			else
			{
				System.out.println("Not Found!");
			}
			break;
			
		case "6":System.exit(0);
			break;
		
		default: System.out.println("Invalid Option please try again!");
		}

		
	}

	}

}