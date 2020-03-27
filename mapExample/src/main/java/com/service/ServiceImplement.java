package com.service;

import com.dao.DaoImplement;
import com.dao.DaoInterface;
import com.pojo.UserPojo;

public class ServiceImplement implements ServiceInterface{

	DaoInterface daoInterface;
	
	public ServiceImplement() {
		daoInterface = new DaoImplement();
	}
	
	@Override
	public boolean saveData(UserPojo pojo) {
		return daoInterface.saveData(pojo);
	}
}
