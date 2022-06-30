package com.exmpleSpringboot.Spring.boot.websecqrity;



import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exmpleSpringboot.Spring.boot.userservice.UserDetailesrServicedaoimp;
import com.exmpleSpringboot.Spring.boot.userservice.EmployeeService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;
@Configuration
public class JwtTokenVerfer  extends OncePerRequestFilter{

	

   private  UserDetailesrServicedaoimp appUserService;
    @Autowired
	public JwtTokenVerfer(UserDetailesrServicedaoimp appUserService) {
	
		this.appUserService=appUserService;
	}
    
   
    @Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    	String requestURI = request.getRequestURI();
		logger.info("request uri is " + requestURI);
		if("/login".equals(requestURI)) {
			return "/login".equals(requestURI);
		}
		if("/views/login.jsp".equals(requestURI)) {
			return "/views/login.jsp".equals(requestURI);
		}
		return false;
	}
    
         @Override 
         protected void doFilterInternal(HttpServletRequest request,
          HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {
 
		
		  HttpSession authorizationHeader = request.getSession(); 
		
		  String a =(String)authorizationHeader.getAttribute("authorization");
			logger.info( " this is print the a of value "+ a );
        	  if(Strings.isNotBlank(a)|| !a.startsWith("Bearer")) {
        	  filterChain.doFilter(request, response);
        			  return;
        	  } 
          
          
        	  			String  token = a.replace("Bearer ","");
        	      		try {
				   	      String secretKey="asdfasdfasdfafaewfawefawefaedfasdfadafdfagwergavwerar";
					      Jws<Claims> claimsjws= Jwts.parser()
					    		  .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
					    		  .parseClaimsJws(token);
					      
					      		Claims body = claimsjws.getBody();
					      		String username = body.getSubject();
					   					      		
					      		ArrayList<Map<String, String>> authorities = (ArrayList<Map<String,String>>) body.get("authorities");
//			
					      		Set<SimpleGrantedAuthority> simpleGrantedAuthority = authorities.stream()
					      	 .map(m->new SimpleGrantedAuthority(m.get("authority"))).collect(Collectors.toSet());
					          Authentication authentication=new UsernamePasswordAuthenticationToken(username,null,simpleGrantedAuthority);
					         SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				  catch (Exception e) {
					
				}

  
  }}
 
	

