package com.inex.third;    

import com.inex.pojo.PojoTest;
import com.inex.services.ServiceInterfacePojoTest;
import com.inex.services.ServicePojoTest;  
  
    
public class App {    
	public static void main(String[] args) {    
		PojoTest e1=new PojoTest();    
	    e1.setId(101);    
	    e1.setFirstName("Gaurav");    
	    e1.setLastName("wins");    
		ServiceInterfacePojoTest serviceInterfacePojoTest=new ServicePojoTest();
		serviceInterfacePojoTest.saveData(e1);
	}    
}   