package com.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ImplRegister;
import com.service.IntfRegister;

@WebServlet("/CheckEmailExist")
public class CheckEmailExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	IntfRegister intfRegister;
	@Override
	public void init() throws ServletException {
		intfRegister = new ImplRegister();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		int no=intfRegister.checkMail(email);
		if(no > 0)
		{	
			response.setContentType("text/plain");
			response.getWriter().write("Email Id Already Exist");
		}
	}
}
