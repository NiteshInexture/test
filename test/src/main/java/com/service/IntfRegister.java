package com.service;

import java.sql.ResultSet;

import javax.servlet.ServletRequest;

import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public interface IntfRegister {
	public int checkMail(String email);
	public void login(RegisterPojo registerPojo);
	public boolean deleteData(int id);
	public ResultSet showData(RegisterPojo pojo);
	public void forgetPassword(RegisterPojo pojo);
	public ResultSet showDataAllUser();
	public boolean insertData(RegisterPojo registerPojo, AddressPojo addressPojo);
	public void EditData(RegisterPojo registerPojo, AddressPojo addressPojo,ServletRequest req);
}
