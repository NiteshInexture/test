package com.comman;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public class CommanUtility {
	/**
	 * 
	 * @param result
	 * @return
	 */
	
	public List<RegisterPojo> bindData(ResultSet result) {
		List<RegisterPojo> rows = new ArrayList<RegisterPojo>();
		try {
			while(result.next()){
				RegisterPojo registerPojo=new RegisterPojo();
				registerPojo.setRegisterId(result.getInt(1));
				registerPojo.setFirstName(result.getString(2));
				registerPojo.setLastName(result.getString(3));
				registerPojo.setEmail(result.getString(4));
				registerPojo.setPassword(result.getString(5));
				
				Blob blob =(Blob) result.getBlob(6);
                if(blob != null) {
                	 InputStream inputStream = blob.getBinaryStream();
                     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                     byte[] buffer = new byte[4096];
                     int bytesRead = -1;
                     try {
     					while ((bytesRead = inputStream.read(buffer)) != -1) {
     					    outputStream.write(buffer, 0, bytesRead); 
     					}
     					 byte[] imageBytes = outputStream.toByteArray();
     		             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
     		             
     		             inputStream.close();
     		             outputStream.close();
     		                
     		             registerPojo.setBase64Image(base64Image);
     				} catch (IOException e) {
     				}
                }
                else {
                    registerPojo.setBase64Image(null);
                }
               
				registerPojo.setGender(result.getString(7));
				registerPojo.setLanguageKnown(result.getString(8));
				registerPojo.setPhoneNo(result.getString(9));
				
				String str=result.getString(10);
				registerPojo.setDob(str);
				
				rows.add(registerPojo);
			}
			
		} catch (SQLException e) {
			System.out.print("\n sql Error " + e);
		}
		return rows;
	}
	
	/**
	 * 
	 * @param result
	 * @return
	 */
	public List<AddressPojo> bindDataAddress(ResultSet result) {
		List<AddressPojo> rows = new ArrayList<AddressPojo>();
		try {
			
			while(result.next()){
				AddressPojo addressPojo=new AddressPojo();
				addressPojo.setAddressId(result.getInt("adress_id"));
				
				addressPojo.setSingleAddress(result.getString("address"));
				
				addressPojo.setRegisterId(result.getInt("rid"));
				
				addressPojo.setSingleCityName(result.getString("cityname"));
				
				addressPojo.setSingleStateName(result.getString("state"));
				
				addressPojo.setSingleCountryName(result.getString("country"));
				
				rows.add(addressPojo);
			}
			
		} catch (SQLException e) {
			System.out.print("\n sql Error " + e);
		}
		return rows;
	}	
	
	
	public String getNumber(String str) {
		int index = str.lastIndexOf('_');
		return str.substring(index +1);
	}
	
	public void asignValues(ServletRequest request,RegisterPojo registerPojo,AddressPojo addressPojo, String values ) {
		String[] updArray=values.split(",");
		String[] address = new String[updArray.length];
		String[] city = new String[updArray.length];
		String[] state = new String[updArray.length];
		String[] country = new String[updArray.length];
		int[] id = new int[updArray.length];
		for(int i=0;i<updArray.length;i++)
		{
			int no=Integer.parseInt(getNumber(updArray[i]));
			id[i]=no;
			address[i]=request.getParameter("address_"+no);
			city[i]=request.getParameter("city_"+no);
			state[i]=request.getParameter("state_"+no);
			country[i]=request.getParameter("country_"+no);
		}
		addressPojo.setAddressIdArray(id);
		addressPojo.setAddress(address);
		addressPojo.setCityName(city);
		addressPojo.setStateName(state);
		addressPojo.setCountryName(country);
	}
	
	public InputStream getInputStream(HttpServletRequest request,String str) {
		InputStream inputStream=null;
		
		Part filePart;
		try {
			filePart = request.getPart(str);
			if (filePart != null) {
			    inputStream = filePart.getInputStream();
			}
		} catch (IOException | ServletException e) {
			
		}
		return inputStream;
	}
	
	public String getInputDataString(ServletRequest req,String from) {
		String value=req.getParameter(from);
		if(value == null || value.equals("")) {
			value="";
		}
		return value;
	}
	
	public String getInputDataString(ServletRequest req,String from,String from2) {
		String value;
		try {
		value=req.getParameter(from);
		} catch ( NullPointerException e) {
			value = req.getParameter(from);
		}
		if(value == null || value.equals("")) {
			value="";
		}
		return value;
	}
	public String[] getInputDataStringArray(ServletRequest req,String from) {
		String[] value;
		try {
		value=req.getParameterValues(from);
		} catch ( NullPointerException e) {
			value=null;
		}
		return value;
	}

	public int getInputDataInteger(ServletRequest req,String from) {
		int value=Integer.parseInt(req.getParameter(from));
		return value;
	}
}
