package com.exmpleSpringboot.Spring.boot.controllertest;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exmpleSpringboot.Spring.boot.Model.Employee;
import com.exmpleSpringboot.Spring.boot.UserDao.EmpDaoImplement;
import com.exmpleSpringboot.Spring.boot.userservice.EmployeeService;
import com.exmpleSpringboot.Spring.boot.websecqrity.JwtUsernameAndPasswordAuthenticationFilter;

import io.micrometer.core.instrument.util.StringUtils;

@Controller

public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(EmpDaoImplement.class);

	@Autowired
	private EmployeeService empservice;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String loginController() {
		logger.info("first time hit the get method*****************");

		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String loginController1(
			
			@RequestParam("useremail") String useremail,
			@RequestParam("userpassword") String userpassword , Model model) {
		logger.info( "this is useremail"+useremail );
		logger.info(" this password"+userpassword);
			
			
			
			


		
		
		

		return "employee_list";
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public ModelAndView getAllemployee() {

		ModelAndView model = new ModelAndView();
		ArrayList<Employee> list = empservice.getAllEmployees();
		logger.info("");

		model.addObject("employee_list", list);
		model.setViewName("employee_list");

		return model;

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(Employee e, @PathVariable Integer id) {
		ModelAndView model = new ModelAndView();

		Employee employee = empservice.updateEmployee(e);
		model.addObject("employeeForm", employee);

		model.setViewName("employee_form");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		ModelAndView model = new ModelAndView();

		Employee employee = new Employee();
		model.addObject("employeeForm", employee);

		model.setViewName("employee_form");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("employeeForm") Employee employee) {
		if (employee.getEmpid() != null) {

			empservice.updateEmployee(employee);
		}

		else {
			empservice.addEmployee(employee);
		}

		return new ModelAndView("redirect:/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("id") int id) {
		empservice.deleteEmployee(id);

		return new ModelAndView("redirect:/list");
	}


}
