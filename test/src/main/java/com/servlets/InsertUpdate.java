package com.servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.comman.CommanUtility;
import com.comman.PasswordEnc;
import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;
import com.service.ImplRegister;
import com.service.IntfRegister;

@MultipartConfig(maxFileSize = 16177215)
public class InsertUpdate extends HttpServlet{

	RegisterPojo registerPojo;
	AddressPojo addressPojo;
	CommanUtility comman;
	ArrayList<String> address;
	ArrayList<String> cityList;
	ArrayList<String> stateList;
	ArrayList<String> countryList;
	ArrayList<Integer> idList;
	
	private static final long serialVersionUID = 1L;

	IntfRegister intfRegister;
	@Override
	public void init() throws ServletException {
		intfRegister = new ImplRegister();
		comman = new CommanUtility();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("o" + request.getParameterValues("languageKnown") + request.getParameter("first_name"));
		registerPojo = new RegisterPojo();
		addressPojo = new AddressPojo();
		
		setValues(request, registerPojo, addressPojo);
		if(registerPojo.validate() & addressPojo.validate()) {
			if(intfRegister.insertData(registerPojo,addressPojo)) {
				HttpSession session=request.getSession(); 
				request.setAttribute("registerStatus", "success");
				session.setAttribute("role", "user");
				session.setAttribute("userId",registerPojo.getRegisterId());
				request.getRequestDispatcher("UserHome").forward(request, resp);
			}else {
				request.getRequestDispatcher("UserForm.jsp").include(request, resp);
			}
		} else {
			request.setAttribute("pojoExistingValues", registerPojo);
			request.setAttribute("pojoExistingHashTable", registerPojo.errors);
			request.getRequestDispatcher("UserForm.jsp").include(request, resp);
		}
		 
		
	}
		private int getNumber(String str) {
		int index = str.lastIndexOf('_');
		return Integer.parseInt( str.substring(index +1));
	}
	
	private void setValues(HttpServletRequest request,RegisterPojo registerPojo,AddressPojo addressPojo) {
		
		registerPojo.setFirstName(comman.getInputDataString(request,"first_name"));
		registerPojo.setLastName(comman.getInputDataString(request,"last_name"));
		
		setList(request);
		
		Object[] arr=address.toArray(); 
		String[] str = Arrays.copyOf(arr, arr.length,String[].class);
		addressPojo.setAddress(str);
		
		arr=cityList.toArray();
		str=Arrays.copyOf(arr, arr.length,String[].class);
		addressPojo.setCityName(str);
		
		arr=stateList.toArray();
		str=Arrays.copyOf(arr, arr.length,String[].class);
		addressPojo.setStateName(str);
		
		arr=countryList.toArray();
		str=Arrays.copyOf(arr, arr.length,String[].class);
	 	addressPojo.setCountryName(str);
	 	
	 	int[] idArray=idList.stream().mapToInt(Integer :: intValue).toArray();
	 	addressPojo.setAddressIdArray(idArray);
	 	
		try {
			String password=request.getParameter("psw");
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] out=md.digest();
			PasswordEnc enc=new  PasswordEnc();
			String str2=enc.bytesToHex(out);
			System.out.println("\n"+str2);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
	 	
	 	registerPojo.setPassword(comman.getInputDataString(request,"psw"));
	 	registerPojo.setConfirmPassword(comman.getInputDataString(request,"psw_repeat"));
	 	registerPojo.setGender(comman.getInputDataString(request,"gender"));
		registerPojo.setLanguageKnown(comman.getInputDataStringArray(request, "languageKnown"));
		registerPojo.setDob(comman.getInputDataString(request,"dob"));
		
		HttpServletRequest req=(HttpServletRequest) request;
		Part filePart;
		try {
			filePart = (req).getPart("file_To_Upload");
			registerPojo.setInputStream(filePart.getInputStream());
		} catch (IOException e) {
			System.out.println("io Ex. " + e);
		} catch (ServletException e) {
			System.out.println("servlet Ex. " + e);
		}
		registerPojo.setPhoneNo(comman.getInputDataString(request, "phone_no"));
		registerPojo.setEmail(comman.getInputDataString(request, "email"));
	}

	private void setList(ServletRequest request) {

		String count=request.getParameter("counter");	
		String[] arrCount=count.split(",");
		int value;
		 address=new ArrayList<String>();
		 cityList=new ArrayList<String>();
		 stateList=new ArrayList<String>();
		 countryList=new ArrayList<String>();
		 idList =new ArrayList<Integer>();
		 String name;
		 String city;
		 String state;
		 String country;
		 for(int i=0;i<arrCount.length;i++) {
			try {
				value=getNumber(arrCount[i]);
				name=request.getParameter("address_"+value);
				city=request.getParameter("city_"+value);
				state=request.getParameter("state_"+value);
				country=request.getParameter("country_"+value);
			}catch(Exception E) {
				continue;
			}
			if(name!=null) {
				idList.add(value);
				address.add(name);
				cityList.add(city);
				stateList.add(state);
				countryList.add(country);
			}
		 }
	}
}
