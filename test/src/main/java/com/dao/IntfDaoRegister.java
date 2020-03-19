package com.dao;

import java.sql.ResultSet;

import javax.servlet.ServletRequest;

import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public interface IntfDaoRegister {
	public ResultSet getEmail(String email);
	public void connect();
	public void getPassword(RegisterPojo registerPojo);
	public ResultSet showUser(RegisterPojo registerPojo);
	public ResultSet showAllUser();
	public boolean addUser(RegisterPojo registerPojo, AddressPojo addressPojo);
	boolean deleteUser(int id);
	boolean updateUser(RegisterPojo regPojo, AddressPojo addPojo,ServletRequest req);
}
