package com.ajax;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

/**
 * Servlet implementation class CurrentUserBySession
 */
@WebServlet("/CurrentUserBySession")
public class CurrentUserBySession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResultSet result;
	IntfRegister intfRegister;
	IntfAddress intfAddress;
	CommanUtility comman;
	RegisterPojo registerPojo;
	
	@Override
	public void init() throws ServletException {
		intfRegister = new ImplRegister();
		intfAddress = new ImplAddress();
		comman=new CommanUtility();
	}
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registerPojo = new RegisterPojo();
		HttpSession session=request.getSession();
		int id;
		try {
			id=Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e) {
			id=0;
		}
		registerPojo.setRegisterId(id);
		
		result=intfRegister.showData(registerPojo);
		List<RegisterPojo> row=comman.bindData(result);
		
		result=intfAddress.getAddress(registerPojo);		
		List<AddressPojo> rows=comman.bindDataAddress(result);
		
		
		session.setAttribute("UserDataRecord", row);
		session.setAttribute("UserDataAddressRecord", rows);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
