package com.exmpleSpringboot.Spring.boot.websecqrity;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.exmpleSpringboot.Spring.boot.Model.Employee;
import com.exmpleSpringboot.Spring.boot.userservice.UserDetailesrServicedaoimp;
import com.exmpleSpringboot.Spring.boot.userservice.EmployeeService;

import sun.security.util.Password;

@Configuration
@EnableAutoConfiguration
public class WebSecqurity extends WebSecurityConfigurerAdapter {
@Autowired
private JwtTokenVerfer jwtToken;
	    public static final Logger logger = LoggerFactory.getLogger(WebSecqurity.class);
	    private final PasswordEncoder passwordEncoder;
	    private final UserDetailesrServicedaoimp appUserService;
	    @Autowired
	    public WebSecqurity(PasswordEncoder passwordEncoder, UserDetailesrServicedaoimp appUserService) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.appUserService = appUserService;
	}

	   @Bean
	   public DaoAuthenticationProvider daoAuthenticationprovider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(appUserService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	             protected void configure(HttpSecurity http1) throws Exception {
		         http1.csrf()
		         .disable()
		         .sessionManagement()
		         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		         .and()
				.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
				.addFilterAfter(new JwtTokenVerfer(appUserService),JwtUsernameAndPasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(  "/login","/**")
				.permitAll()
				.antMatchers("/admin")
				.hasRole("Admin")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.permitAll()
				.and()
				.logout();
			}
	           @Override
	           protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		       auth.authenticationProvider(daoAuthenticationprovider());
		       
		     
		       }
	

}
