package com.servlets.admin;

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
public class EditUser extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IntfRegister intfRegister;
	IntfAddress intfAddress;
	RegisterPojo pojo;
	CommanUtility comman;
	ResultSet result;
	
	int id;
	@Override
	public void init() throws ServletException {
		comman=new CommanUtility();
		intfRegister = new ImplRegister();
		intfAddress = new ImplAddress();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pojo = new RegisterPojo();
		try {
		id = Integer.parseInt(req.getParameter("edit"));
		}catch(Exception e) {
			System.out.println(e);
		}
		pojo.setRegisterId(id);
		result=intfRegister.showData(pojo);
		List<RegisterPojo> row=comman.bindData(result);
		
		result=intfAddress.getAddress(pojo);
		
		List<AddressPojo> rows=comman.bindDataAddress(result);
		HttpSession session=req.getSession();
		session.setAttribute("retrieveId", id);
		session.setAttribute("UserDataRecord", row);
		session.setAttribute("UserDataAddressRecord", rows);
		//req.getRequestDispatcher("UserForm.jsp").forward(req, resp);
	}
}