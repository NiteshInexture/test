package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.AddressPojo;
import com.pojo.UserPojo;
import com.service.ServiceImplement;
import com.service.ServiceInterface;

/**
 * Servlet implementation class insert
 */
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceInterface serviceInterface;
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		serviceInterface = new ServiceImplement();
		UserPojo pojo =new UserPojo();
		pojo.setFirstName(req.getParameter("fname"));
		pojo.setLastName(req.getParameter("lname"));
		
		AddressPojo add=new AddressPojo();
		add.setCity(req.getParameter("city"));
		add.setState(req.getParameter("state"));
		
		AddressPojo add2=new AddressPojo();
		add2.setCity(req.getParameter("city1"));
		add2.setState(req.getParameter("state1"));
	
		ArrayList<AddressPojo> list=new ArrayList<AddressPojo>();    
		list.add(add);
		list.add(add2);
		
		pojo.setList(list);
		if(serviceInterface.saveData(pojo)) {
			resp.getWriter().print("Insert Success");
		}else {
			resp.getWriter().print("Failed To insert");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		serviceInterface = null;
	}
}


