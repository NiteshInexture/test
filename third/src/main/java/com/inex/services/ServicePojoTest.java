package com.inex.services;

import com.inex.dao.DaoInterfacePojoTest;
import com.inex.dao.DaoPojoTest;
import com.inex.pojo.PojoTest;

public class ServicePojoTest  implements ServiceInterfacePojoTest {

	DaoInterfacePojoTest daoInterfacePojoTest=new DaoPojoTest();
	
	@Override
	public boolean saveData(PojoTest pojo) {
		daoInterfacePojoTest.saveData(pojo);
		return false;
	}

	@Override
	public PojoTest GetDataAll() {
		return daoInterfacePojoTest.getAllData();
	}
	
}
