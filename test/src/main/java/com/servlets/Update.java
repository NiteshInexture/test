package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
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
 * Servlet implementation class Update
 */
@MultipartConfig(maxFileSize = 16177215)
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IntfRegister intfRegister;
	IntfAddress intfAddress;
	RegisterPojo registerPojo;
	AddressPojo addressPojo;
	CommanUtility comman;
	ResultSet result;
	
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
		
		intfRegister.EditData(registerPojo, addressPojo,request);
		result=intfRegister.showData(registerPojo);
		List<RegisterPojo> row=comman.bindData(result);
		
		result=intfAddress.getAddress(registerPojo);
		
		List<AddressPojo> rows=comman.bindDataAddress(result);
		HttpSession session=request.getSession();
		session.setAttribute("UserDataRecord", row);
		session.setAttribute("UserDataAddressRecord", rows);
		request.getRequestDispatcher("UserForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		registerPojo = new RegisterPojo();
		addressPojo = new AddressPojo();

		deleteAddress(request, response, registerPojo, addressPojo);
		updateAddress(request, response, registerPojo, addressPojo);
		
		registerPojo.setRegisterId(Integer.parseInt(request.getParameter("userId")));
		registerPojo.setFirstName(request.getParameter("first_name"));
		registerPojo.setLastName(request.getParameter("last_name"));
		
		setAddress(request,registerPojo,addressPojo);
		
		addressPojo.setAddress(request.getParameterValues("address"));
	 	addressPojo.setCityName(request.getParameterValues("city"));
		addressPojo.setStateName(request.getParameterValues("state"));
	 	addressPojo.setCountryName(request.getParameterValues("country"));
	 	
	 	registerPojo.setEmail(request.getParameter("email"));
	 	registerPojo.setPassword(request.getParameter("psw"));
		registerPojo.setGender(request.getParameter("gender"));
		registerPojo.setLanguageKnown(request.getParameter("languageKnown"));
		registerPojo.setDob(request.getParameter("dob"));
		registerPojo.setInputStream(comman.getInputStream(request,"file_To_Upload"));
		//registerPojo.setImage(request.getParameter("file_To_Upload"));
		registerPojo.setPhoneNo(request.getParameter("phone_no"));
		
		doGet(request, response);
	}
	private void deleteAddress(HttpServletRequest request, HttpServletResponse response, RegisterPojo registerPojo, AddressPojo addressPojo) {
		String del=request.getParameter("delCounter");
		if(!del.isEmpty()) {
			String[] delArray=del.split(",");
			for(int i=0;i<delArray.length;i++)
			{
				delArray[i]=comman.getNumber(delArray[i]);
			}
			addressPojo.setDeleleArray(delArray);
			intfAddress.deleteAddress(addressPojo);
		}
	}
	
	private void updateAddress(HttpServletRequest request, HttpServletResponse response, RegisterPojo registerPojo, AddressPojo addressPojo) {
		
		String update=request.getParameter("updCounter");
		if(!update.isEmpty()) {
			comman.asignValues(request, registerPojo, addressPojo, update);
			intfAddress.updateAddress(addressPojo,registerPojo);
		}
	}

	private void setAddress(ServletRequest request,RegisterPojo registerPojo,AddressPojo addressPojo) {
		
		String insert=request.getParameter("counter");
		if(!insert.isEmpty()) {
			comman.asignValues(request, registerPojo, addressPojo, insert);
			intfAddress.insertAddress(registerPojo, addressPojo);
		}
	}
	
}
