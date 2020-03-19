package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.pojo.RegisterPojo;
import com.service.ImplRegister;
import com.service.IntfRegister;

public class FilterLogin implements Filter {

	IntfRegister intfRegister;
	RegisterPojo registerPojo;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		intfRegister = new ImplRegister();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		registerPojo = new RegisterPojo();
		registerPojo.setEmail(request.getParameter("email"));
		try {
			intfRegister.login(registerPojo);
		}catch(Exception e) {}
		
		if(registerPojo.getPassword() == null){
			
			request.setAttribute("message", "Wrong Email Address");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} else if(registerPojo.getPassword().equals(request.getParameter("password")) && registerPojo.getRole().equals("admin")){
			
			request.setAttribute("pojo", registerPojo);
			chain.doFilter(request, response);
			
		} else if (registerPojo.getPassword().equals(request.getParameter("password")) && registerPojo.getRole().equals("user")){
			
			request.setAttribute("pojo", registerPojo);
			chain.doFilter(request, response);
			
		} else {
			
			request.setAttribute("message", "Wrong Password Or EmailId");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	@Override
	public void destroy() {
		intfRegister=null;
	}
	
}
