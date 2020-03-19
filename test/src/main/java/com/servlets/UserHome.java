package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comman.CommanUtility;
import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;
import com.service.ImplAddress;
import com.service.ImplRegister;
import com.service.IntfAddress;
import com.service.IntfRegister;

public class UserHome extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	RegisterPojo registerPojo;
	HttpSession session;
	IntfRegister intfRegister;
	IntfAddress intfAddress;
	ResultSet result;
	ResultSet resultAddress;
	CommanUtility comman;
	
	@Override
	public void init() throws ServletException {
		intfRegister = new ImplRegister();
		intfAddress =new ImplAddress();
		comman = new CommanUtility();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id;
		HttpSession session=req.getSession();
		registerPojo=new RegisterPojo();
		try {
			id=Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
			id=0;
		}
		
		if(id != 0 ) {
			registerPojo.setRegisterId(id);
		}
		else if(session.getAttribute("userId")!="")
			registerPojo.setRegisterId((int) session.getAttribute("userId"));
		
		result = intfRegister.showData(registerPojo);
		List<RegisterPojo> row=comman.bindData(result);
		
		resultAddress = intfAddress.getAddress(registerPojo);
		List<AddressPojo> rows = comman.bindDataAddress(resultAddress);

		/**
		 * 
		 * Stores User Data and Send to User Form
		 */
		session.setAttribute("UserDataRecord", row);
		session.setAttribute("UserDataAddressRecord", rows);
		
		/**
		 * when use logged in it will Redirect to UserForm.jsp
		 */
		if(session.getAttribute("userId")!="")
			resp.sendRedirect("UserForm.jsp");
			//req.getRequestDispatcher("user/home.jsp").forward(req, resp);
//		else
//			req.getRequestDispatcher("AdminHome").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
