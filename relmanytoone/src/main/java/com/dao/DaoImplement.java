package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pojo.UserPojo;

public class DaoImplement implements DaoInterface{

	
	private StandardServiceRegistry ssr ;
	private Metadata meta ;
	private SessionFactory factory;
	
	public DaoImplement() {
		ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
	}
	
	@Override
	public boolean saveData(UserPojo pojo) {
		factory = meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(pojo);
		transaction.commit();
		
		session.close();
		factory.close();
		return false;
	}
	
}
