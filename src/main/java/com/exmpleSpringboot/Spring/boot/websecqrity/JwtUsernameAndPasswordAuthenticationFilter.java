package com.exmpleSpringboot.Spring.boot.websecqrity;

import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");

		logger.info("useremail is   JwtUsernameAndPasswordAuthenticationFilter1 " + useremail);
		logger.info("userpassword is JwtUsernameAndPasswordAuthenticationFilter2    " + userpassword);

		Authentication authentication = new UsernamePasswordAuthenticationToken(useremail, userpassword);
		return authenticationManager.authenticate(authentication);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		    String key = "asdfasdfasdfafaewfawefawefaedfasdfadafdfagwergavwerar";
		    logger.info("authResult.getName() is " + authResult.getName());
		
		
		
		
	         	String token = Jwts.builder().setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities()).setIssuedAt(new Date())
				.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
				.signWith(Keys.hmacShaKeyFor(key.getBytes())).compact();
	         	logger.info("token is " + token);

		
		     HttpSession session = request.getSession();
		  session.setAttribute("authorization", "Bearer " + token);
		  
		 
		// response.addHeader("authorization", "Bearer " + token);

	}

}
