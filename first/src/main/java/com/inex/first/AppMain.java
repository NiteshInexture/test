package com.inex.first;
 
import java.util.Date;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class AppMain {
 
    static User userObj;
    static User2 userObj2;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
 
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
 
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
 
    public static void main(String[] args) {
        System.out.println(".......Hibernate Maven Example.......\n");
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();
 
            for(int i = 120; i <= 130; i++) {
                userObj = new User();
                userObj2 = new User2();
                userObj.setUserid(i);
                userObj2.setId(i);
                userObj.setUsername("Editor " + i);
                userObj2.setFirstName("vns");;
                userObj.setCreatedBy("Administrator");
                userObj2.setLastName("nmnmnm");
                userObj.setCreatedDate(new Date());
 
                sessionObj.save(userObj);
                sessionObj.save(userObj2);
            }
            System.out.println("\n.......Records Saved Successfully To The Database.......\n");
 
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}