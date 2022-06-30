package com.exmpleSpringboot.Spring.boot.UserDao;

import java.awt.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exmpleSpringboot.Spring.boot.Model.Employee;
import com.exmpleSpringboot.Spring.boot.Model.EmployeeRowmn;
@Transactional
@Repository

public class EmpDaoImplement implements EmpDaoInterface{
	
	private static final Logger logger = LoggerFactory.getLogger(EmpDaoImplement.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public ArrayList<Employee> getAllEmployees() {
		
		  String query = "SELECT * from user";
		  RowMapper<Employee> rowMapper = new EmployeeRowmn();
		  ArrayList<Employee> list = (ArrayList<Employee>)jdbcTemplate.query(query, rowMapper);
		  
		  return list;
		
		
	
	}

	@Override
	public Employee finEmployeeById(int id) {
		String query="select * from user where empid=?";
		RowMapper< Employee>rowmapper=new  BeanPropertyRowMapper<Employee>(Employee.class);
		  Employee employee = jdbcTemplate.queryForObject(query, rowmapper, id);
	
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		logger.info("employee password is " + employee.getUserpassword());
		
			  String query = "INSERT INTO user(empid,firstname,lastname, useremail,userpassword,role) VALUES( ?,?,?,?,?,?)";
			  jdbcTemplate.update(query, employee.getRole(),employee.getEmpid(), employee.getFirstname(),employee.getLastname(),employee.getUseremail(),employee.getUserpassword());
		
	}


	@Override
	public void updateEmployee(Employee employee) {
		
		
		  String query= "UPDATE user SET firstname=?,lastname=?, useremail=?, userpassword=? WHERE empid=?";
		  jdbcTemplate.update(query,employee.getRole(),employee.getEmpid(),employee.getFirstname(),employee.getLastname(),employee.getUseremail(),employee.getUserpassword());
		  

		  
	
	
		
	}

	@Override
	public void deleteEmployee(int id) {
		String query="delete from user where empid=?";
		 jdbcTemplate.update(query, id);
	
		
	}
	
	public Employee finEmployeeByUsername(String email) {
		String query="select * from user where useremail=?";
		RowMapper< Employee>rowmapper=new  BeanPropertyRowMapper<Employee>(Employee.class);
		  Employee employee = jdbcTemplate.queryForObject(query, rowmapper, email);
		return employee;
	}

	public String token(String username, String userpassword) {
	String query="select *  from user where username And userpassword(?,?) ";
	return query;
	}

	
		
	
}
