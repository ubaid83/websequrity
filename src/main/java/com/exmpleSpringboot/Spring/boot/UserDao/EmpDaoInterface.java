package com.exmpleSpringboot.Spring.boot.UserDao;

import java.awt.List;
import java.util.ArrayList;

import com.exmpleSpringboot.Spring.boot.Model.Employee;

public interface EmpDaoInterface

{
public  ArrayList<Employee>getAllEmployees();
 public Employee finEmployeeById(int id);

 public void addEmployee(Employee employee);
 
 public void updateEmployee(Employee employee);
 
 public void deleteEmployee(int id);


	
	
	
	
}
