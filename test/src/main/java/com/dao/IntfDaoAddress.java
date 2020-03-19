package com.dao;

import java.sql.ResultSet;

import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public interface IntfDaoAddress {
	ResultSet getAddress(RegisterPojo pojo); 
	void connect();
	void deleteAddress(AddressPojo addressPojo);
	void UpdateAddress(AddressPojo addressPojo,RegisterPojo pojo);
	void insertAddress(AddressPojo addressPojo,RegisterPojo pojo);
}
