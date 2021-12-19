package com.venky.Employee.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.venky.Employee.Entity.EmployeeEntity;

public class JWTAuthentication extends OncePerRequestFilter {
	
	@Autowired
	private EmployeeEntity employeeEntity;
	@Autowired
	private JWTToken jwtToken;
	
	
		public  JWTAuthentication(EmployeeEntity employeeEntity,JWTToken jwtToken ){
			this.employeeEntity=employeeEntity;
			this.jwtToken = jwtToken;
			
			
		}
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  authToken=jwtToken.getAuthHeaderFromHeader(request);
		if(null!=authToken) {
			String userName = jwtToken.getUsernameFromToken(authToken);
			if(null!=userName) {
//				UserDetails userDetails = user
			}
			
		}
		
	}

}
