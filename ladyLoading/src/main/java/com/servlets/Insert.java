package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pojo.Address;
import com.pojo.User;


@WebServlet("/insert")
public class Insert extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
//		User pojo=new User();
//		pojo.setName("nitesh");
//		Address apojo=new Address();
//		apojo.setAddress("navsari");
//		List<Address> list=new ArrayList<Address>();
//		list.add(apojo);
//		pojo.setList(list);
//			int id=(int) session.save(pojo);
//			
			
			User user = (User) session.get(User.class, new Integer(3));
			System.out.println("User ID= "+user.getUid());
		    System.out.println("User Name= "+user.getName());
		    List<Address> addr=user.getList();
//		    
//		
//		  for (Iterator<Address> iterator1 = addr.iterator(); iterator1.hasNext();){
//		  Address employee = (Address) iterator1.next();
//		  System.out.println("Address Id: " + employee.getId());
//		  System.out.println("Address: " + employee.getAddress()); }
		 
		t.commit();
		session.close();
		factory.close();
	}
}
