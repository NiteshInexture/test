package com.inex.dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.inex.pojo.PojoTest;

public class DaoPojoTest implements DaoInterfacePojoTest{
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	
	@Override
	public boolean saveData(PojoTest pojo) {
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
	    session.save(pojo);  
	    t.commit();  
	    System.out.println("successfully saved");    
	    factory.close();  
	    session.close();    
	       
		return false;
	}

	@Override
	public PojoTest getAllData() {
		
		SessionFactory factory= meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Query query = session.createQuery("from PojoTest");  		
		Iterator<PojoTest> it=query.iterate();  
		while(it.hasNext())  
		{  
			PojoTest e=(PojoTest)it.next();  
			System.out.println(e.getId());  
			
			System.out.println(e.getFirstName());
			
			System.out.println(e.getLastName());
		}
		session.close();  
		factory.close();  
	     
		return null;
	}

}
