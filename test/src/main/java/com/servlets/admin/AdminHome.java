package com.servlets.admin;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comman.CommanUtility;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.pojo.RegisterPojo;
import com.service.ImplRegister;
import com.service.IntfRegister;

public class AdminHome extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private IntfRegister intfRegister;
	CommanUtility comman;
	@Override
	public void init() throws ServletException {
		intfRegister = new ImplRegister();
		comman=new CommanUtility();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		intfRegister = new ImplRegister();
		ResultSet result=intfRegister.showDataAllUser();
		ArrayList<RegisterPojo> rows=(ArrayList<RegisterPojo>) comman.bindData(result);
		Gson gson=new Gson();
		JsonElement ele=gson.toJsonTree(rows,new TypeToken<List<RegisterPojo>>() {}.getType());
		JsonArray jsonArray=ele.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
