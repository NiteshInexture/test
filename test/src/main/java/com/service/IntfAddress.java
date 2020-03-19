package com.service;

import java.sql.ResultSet;

import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public interface IntfAddress {
	ResultSet getAddress(RegisterPojo registerPojo);
	void deleteAddress(AddressPojo addressPojo);
	void updateAddress(AddressPojo addressPojo,RegisterPojo pojo);
	void insertAddress(RegisterPojo registerPojo,AddressPojo addressPojo);
}
