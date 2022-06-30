package com.exmpleSpringboot.Spring.boot.controllertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exmpleSpringboot.Spring.boot.UserDao.UserDetailsImpl;
import com.exmpleSpringboot.Spring.boot.userservice.EmployeeService;
import com.exmpleSpringboot.Spring.boot.userservice.UserDetailesrServicedaoimp;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private final UserDetailesrServicedaoimp userDetailesrServicedaoimp ;
	@Autowired
	public AdminController(UserDetailesrServicedaoimp userDetailesrServicedaoimp) {
		this.userDetailesrServicedaoimp=userDetailesrServicedaoimp;
	
	}
	
	@GetMapping("/adminprofile")
	public String homeprofile(Model model , Authentication authentication) {
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		
		
		
		
		
		
		
		
		
		return null;
		
		
	}
	
	
	
	
	
	
	
	

}
