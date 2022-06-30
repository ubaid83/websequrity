package com.exmpleSpringboot.Spring.boot.userservice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exmpleSpringboot.Spring.boot.Model.Employee;
import com.exmpleSpringboot.Spring.boot.UserDao.EmpDaoImplement;
@Service

public class EmployeeService implements EmployyeeServiceInterface {
	@Autowired
	private EmpDaoImplement empDaoImplement;
	

	@Override
	public ArrayList<Employee> getAllEmployees() {
		
		return empDaoImplement.getAllEmployees();
	}

	@Override
	public Employee finEmployeeById(int id) {
		
		return empDaoImplement.finEmployeeById(id);
		
	}

	@Override
	public void addEmployee(Employee employee) {
		empDaoImplement.addEmployee(employee);
	
	}

	public Employee updateEmployee(Employee employee) {
			empDaoImplement.updateEmployee(employee);
		return employee;
		
	}
	
	
	

	@Override
	public void deleteEmployee(int id) {
		empDaoImplement.deleteEmployee(id);
	
		
	}

	public String token(String username, String userpassword) {
		return empDaoImplement.token(username,userpassword);

		
	}


	

}
