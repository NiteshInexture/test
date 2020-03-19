package com.ajax;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IntfRegister intfRegister;
	CommanUtility comman=new CommanUtility();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		intfRegister = new ImplRegister();
		ResultSet result=intfRegister.showDataAllUser();
		ArrayList<RegisterPojo> rows=(ArrayList<RegisterPojo>) comman.bindData(result);
		Gson gson=new Gson();
		JsonElement ele=gson.toJsonTree(rows,new TypeToken<List<RegisterPojo>>() {}.getType());
		JsonArray jsonArray=ele.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

}
