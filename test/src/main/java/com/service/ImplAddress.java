package com.service;

import java.sql.ResultSet;

import com.dao.ImplDaoAddress;
import com.dao.IntfDaoAddress;
import com.pojo.AddressPojo;
import com.pojo.RegisterPojo;

public class ImplAddress implements IntfAddress{

	IntfDaoAddress intfDaoAddress;
	ResultSet result;
	
	public ImplAddress(){
		intfDaoAddress=new ImplDaoAddress();
		intfDaoAddress.connect();
	}
	
	@Override
	public ResultSet getAddress(RegisterPojo registerPojo) {
		result = intfDaoAddress.getAddress(registerPojo);
		return result;
	}


	@Override
	public void deleteAddress(AddressPojo addressPojo) {
		intfDaoAddress.deleteAddress(addressPojo);		
	}

	@Override
	public void updateAddress(AddressPojo addressPojo,RegisterPojo pojo) {
		intfDaoAddress.UpdateAddress(addressPojo, pojo);
	}

	@Override
	public void insertAddress(RegisterPojo registerPojo, AddressPojo addressPojo) {
		intfDaoAddress.insertAddress(addressPojo, registerPojo);
	}
}
