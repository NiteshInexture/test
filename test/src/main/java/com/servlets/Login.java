package com.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comman.CommanUtility;
import com.pojo.RegisterPojo;
import com.service.ImplRegister;
import com.service.IntfAddress;
import com.service.IntfRegister;

public class Login extends HttpServlet{
	
	CommanUtility comman;
	IntfAddress intfAddress;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RegisterPojo registerPojo;
	protected IntfRegister intfRegister;
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		intfRegister = new ImplRegister();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		registerPojo=(RegisterPojo) req.getAttribute("pojo");
		String role=registerPojo.getRole();
		if(role.equals("admin")) {
			 session.setAttribute("role", "admin");
			 resp.sendRedirect("admin/home.jsp"); 
		}else{
			session.setAttribute("userId", registerPojo.getRegisterId());
			session.setAttribute("role", "user");
			resp.sendRedirect("UserForm.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("hello");
	}
	
	@Override
	public void destroy() {
		intfRegister = null;
	}
}
