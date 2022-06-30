package com.exmpleSpringboot.Spring.boot.UserDao;

import java.awt.List;
import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.exmpleSpringboot.Spring.boot.Model.Employee;

public class UserDetailsImpl implements UserDetails {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);

	private Long id;
	private String useremail;
	private String userpassword;
	private String role;
	
	

	public UserDetailsImpl(String useremail, String userpassword, String role2, String firstname, String lastname) {
		logger.info("useremail is " + useremail);
		logger.info("userpassword is " + userpassword);
		this.useremail = useremail;
		this.userpassword=userpassword;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
		return Collections.singleton(authority);
	}

	@Override
	public String getPassword() {
		logger.info("userpassword is  ddd " + userpassword);
		return userpassword;
	}

	@Override
	public String getUsername() {
		logger.info("useremail is = " + useremail);
		return useremail;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
