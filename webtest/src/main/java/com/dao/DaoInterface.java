package com.dao;

import com.pojo.AddressPojo;
import com.pojo.UserPojo;

public interface DaoInterface {
	public boolean saveData(UserPojo pojo, AddressPojo addresspojo);
}
