package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.servlet.ServletRequest;

import com.db.DbHelper;
import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public class ImplDaoRegister implements IntfDaoRegister{
	
	ResultSet result;
	DbHelper helper;
	PreparedStatement preparedStatement;
	Connection con;
	
	public ImplDaoRegister(){
		helper = DbHelper.getInstance("jdbc:mysql://localhost:","3306","karan","karan");
	}
	
	@Override
	public void connect(){
		try {
			con=helper.Connect("inexdb");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("\n Failed To Connnect DB " + e );
		}
	}
	
	@Override
	public boolean addUser(RegisterPojo registerPojo, AddressPojo addressPojo) {
		boolean result=false;
			try {
				preparedStatement = con.prepareStatement("insert into register(first_name,last_name,email,password,image,gender,language_known,phoneno,dob,role) values(?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, registerPojo.getFirstName());
				preparedStatement.setString(2, registerPojo.getLastName());
				preparedStatement.setString(3, registerPojo.getEmail());
				preparedStatement.setString(4, registerPojo.getPassword());
				//preparedStatement.setString(5, registerPojo.getImage());
				preparedStatement.setBlob  (5, registerPojo.getInputStream());
				preparedStatement.setString(6, registerPojo.getGender());
				preparedStatement.setString(7, registerPojo.getLanguageKnown());
				preparedStatement.setString(8, registerPojo.getPhoneNo());
				System.out.println(registerPojo.getDob());
				preparedStatement.setString(9, registerPojo.getDob());
				preparedStatement.setString(10, "user");
				result = preparedStatement.executeUpdate() > 0;
				int id=getKey();
				registerPojo.setRegisterId(id);
				if(id > 0 ) {
					preparedStatement = con.prepareStatement("insert into address(address,rid,cityname,state,country)values(?,?,?,?,?)");
					String[] str=addressPojo.getAddress();
					Arrays.stream(str).forEach(s -> System.out.println("\n " + s));
					for(int i=0;i<str.length;i++) {
					
					  preparedStatement.setString(1,addressPojo.getAddress()[i]);
					  preparedStatement.setInt(2,id);
					  preparedStatement.setString(3,addressPojo.getCityName()[i]);
					  preparedStatement.setString(4,addressPojo.getStateName()[i]);
					  preparedStatement.setString(5,addressPojo.getCountryName()[i]);
					  result = preparedStatement.executeUpdate() > 0;
					}
				}
			} catch (SQLException e) {
				System.out.println("Error in sql " + e);
			}
		return result;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean result=false;
			try {
				preparedStatement = con.prepareStatement("delete from register where rid=?");
				preparedStatement.setInt(1, id);
				result = preparedStatement.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("\n Failed " + e);
			}
		return result;
	}

	@Override
	public void getPassword(RegisterPojo registerPojo) {
		
		try {
			preparedStatement = con.prepareStatement("select password, first_name, role, rid from register where email=?");			
			preparedStatement.setString(1, registerPojo.getEmail());
			result = preparedStatement.executeQuery();
			
			while(result.next()){
				registerPojo.setFirstName(result.getString(2));
				registerPojo.setPassword(result.getString(1));
				registerPojo.setRole(result.getString(3));
				registerPojo.setRegisterId(result.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println("\n Sql error" + e );
		} 
	}

	@Override
	public boolean updateUser(RegisterPojo regPojo, AddressPojo addPojo,ServletRequest request) {
		boolean result=false;
		try {
			
			preparedStatement = con.prepareStatement(getQuery(regPojo,request));
			
			preparedStatement.setString(1, regPojo.getFirstName());
			preparedStatement.setString(2, regPojo.getLastName());
			preparedStatement.setString(3, regPojo.getEmail());
			preparedStatement.setString(4, regPojo.getPassword());
			preparedStatement.setString(5, regPojo.getGender());
			preparedStatement.setString(6, regPojo.getLanguageKnown());
			preparedStatement.setString(7, regPojo.getPhoneNo());
			preparedStatement.setString(8, regPojo.getDob());
			if(request.getParameter("checkNewOld").equals("new")) {
				preparedStatement.setBlob  (9, regPojo.getInputStream());
				preparedStatement.setInt  (10, regPojo.getRegisterId());
			}
			else {
				preparedStatement.setInt  (9, regPojo.getRegisterId());
			}
			result = preparedStatement.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.out.println("Error in sql " + e);
		}
		
		return result;
	}
	
	@Override
	public ResultSet showUser(RegisterPojo registerPojo) {
		
		try {
			preparedStatement = con.prepareStatement("select * from register where rid=?");
			preparedStatement.setInt(1, registerPojo.getRegisterId());
			result = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("\n Sql error" + e );
		}
		return result;
	}
	
	@Override
	public ResultSet showAllUser() {
		System.out.println("\n implDao  start");
		try {
			preparedStatement = con.prepareStatement("select * from register where role != 'admin' ORDER BY first_name ASC");
			result = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("\n Sql error" + e );
		}
		System.out.println("\n implDao  End");
		return result;
	}
	
	private int getKey() {
		int key=0;
		try {
			this.result = preparedStatement.getGeneratedKeys();
			key = this.result.next() ? this.result.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}
	
	private String getQuery(RegisterPojo pojo,ServletRequest req) {
		String query;
		String str=req.getParameter("checkNewOld");
		if(str.equals("new"))
			query="update register set "
				+ "first_name=?,"
				+ " last_name=?, "
				+ "email=?, "
				+ "password=?,"
				+ "gender=?,"
				+ "language_known=?,"
				+ "phoneno=?,"
				+ "dob=?, "
				+ "image=? "
				+ "where rid=?";
		else 
			query="update register set "
					+ "first_name=?,"
					+ " last_name=?, "
					+ "email=?, "
					+ "password=?, "
					+ "gender=?,"
					+ "language_known=?,"
					+ "phoneno=?,"
					+ "dob=? "
					+ "where rid=?" ;
		return query;
	}

	@Override
	public ResultSet getEmail(String email) {
		try {
			preparedStatement = con.prepareStatement("select email from register where email=?");
			preparedStatement.setString(1, email);
			result = preparedStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("sqlExeption ->");
		}
		return result;
	}
}
