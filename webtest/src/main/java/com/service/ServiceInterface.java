package com.service;

import com.pojo.AddressPojo;
import com.pojo.UserPojo;

public interface ServiceInterface {
	public boolean saveData(UserPojo pojo,AddressPojo addressPojo);
}
