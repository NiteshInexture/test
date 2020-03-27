package com.inex.third;

import com.inex.pojo.PojoTest;
import com.inex.services.ServiceInterfacePojoTest;
import com.inex.services.ServicePojoTest;

public class Show {
	public static void main(String args[]) {
		ServiceInterfacePojoTest serviceInterfacePojoTest=new ServicePojoTest();
		PojoTest pojo=serviceInterfacePojoTest.GetDataAll();
		System.out.println("done");
	}
}
