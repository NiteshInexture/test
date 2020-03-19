package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.RegisterPojo;
import com.service.ImplRegister;
import com.service.IntfRegister;

public class ForgetPassword extends HttpServlet{
	
	RegisterPojo registerPojo;
	
	private static final long serialVersionUID = 1L;
	
	protected String pwd;
	IntfRegister intfRegister;
	
	@Override
	public void init() throws ServletException {
		
		intfRegister = new ImplRegister();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		registerPojo = new RegisterPojo();
		registerPojo.setEmail(req.getParameter("email"));
		intfRegister.forgetPassword(registerPojo);
		req.setAttribute("message", registerPojo.getPassword());
		req.getRequestDispatcher("forget_password.jsp").forward(req, resp);
	}
}