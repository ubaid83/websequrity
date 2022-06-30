package com.exmpleSpringboot.Spring.boot.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exmpleSpringboot.Spring.boot.Model.Employee;
import com.exmpleSpringboot.Spring.boot.UserDao.EmpDaoImplement;
import com.exmpleSpringboot.Spring.boot.UserDao.UserDetailsImpl;
@Service
public class UserDetailesrServicedaoimp implements UserDetailsService {
	
	

	public static final Logger logger=LoggerFactory.getLogger(UserDetailesrServicedaoimp.class);
	
	@Autowired
	private EmpDaoImplement empDaoImplement;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = empDaoImplement.finEmployeeByUsername(username);
		logger.info("emp is " + emp);
		logger.info("this user name of databases_________________***************************************"+username);
		if(emp==null) {
			throw new UsernameNotFoundException("user404");
		}
		logger.info("hereeee....");
		return new UserDetailsImpl(emp.getUseremail(),emp.getUserpassword(),emp.getRole(),emp.getFirstname(),emp.getLastname());

	}
	

}
