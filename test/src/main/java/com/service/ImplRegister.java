package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;

import com.dao.ImplDaoRegister;
import com.dao.IntfDaoRegister;
import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public class ImplRegister implements IntfRegister{

	IntfDaoRegister intfDaoRegister;
	ResultSet result;
	
	public ImplRegister() {
		intfDaoRegister=new ImplDaoRegister();
		intfDaoRegister.connect();
	}
	
	@Override
	public void login(RegisterPojo registerPojo) {
		intfDaoRegister.getPassword(registerPojo);
	}

	@Override
	public boolean insertData(RegisterPojo registerPojo, AddressPojo addressPojo) {
		return intfDaoRegister.addUser(registerPojo, addressPojo);
	}

	@Override
	public boolean deleteData(int id) {
		return intfDaoRegister.deleteUser(id);
	}

	@Override
	public ResultSet showData(RegisterPojo registerPojo) {
		result = intfDaoRegister.showUser(registerPojo);
		return result;
	}

	@Override
	public void forgetPassword(RegisterPojo registerPojo) {
		intfDaoRegister.getPassword(registerPojo);
	}

	@Override
	public ResultSet showDataAllUser() {
		result = intfDaoRegister.showAllUser();
		return result;
	}

	@Override
	public void EditData(RegisterPojo registerPojo, AddressPojo addressPojo,ServletRequest req) {
		
		intfDaoRegister.updateUser(registerPojo,addressPojo,req);
	}

	@Override
	public int checkMail(String email) {
		int occur=0;
		result = intfDaoRegister.getEmail(email);
		try {
			while(result.next()) {
				occur++;
			}
		} catch (SQLException e) {
		}
		return occur;
	}
}
