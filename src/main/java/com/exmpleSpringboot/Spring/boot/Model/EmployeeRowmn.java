package com.exmpleSpringboot.Spring.boot.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowmn implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpid(rs.getInt("empid"));
		
		emp.setFirstname("firstname");
		emp.setLastname("lastname");

		emp.setUseremail(rs.getString("useremail"));
		emp.setUserpassword("userpassword");

		return emp;
	}

}
