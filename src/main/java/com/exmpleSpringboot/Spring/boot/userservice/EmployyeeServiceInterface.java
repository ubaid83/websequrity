package com.exmpleSpringboot.Spring.boot.userservice;

import java.util.ArrayList;
import java.util.Optional;

import com.exmpleSpringboot.Spring.boot.Model.Employee;

public interface EmployyeeServiceInterface {
	public ArrayList<Employee> getAllEmployees();
	 
	 public Employee finEmployeeById(int id);
	 
	 public void addEmployee(Employee employee);
	 
	 public Employee updateEmployee(Employee employee);
	 
	 
	 public void deleteEmployee(int id);

	

}
