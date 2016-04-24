package com.karthik.CRUD_HibernateDemo.TesterPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.CRUD_HibernateDemo.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String []args){
		Configuration cfg;
		SessionFactory factory;
		Session s=null;
		try{

		cfg=new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		s=factory.openSession();
		s.getTransaction();
		/* 
		
		for(int i=0;i<=10;i++){
			Userdetails userdetails=new Userdetails();
			userdetails.setUserName("user"+i);
			s.save(userdetails);
		}
		
		
		*/
		Userdetails user=s.get(Userdetails.class, 5);
		user.setUserName("karthik");
		//will update username of user object
		// or v can use s.update(user);
		//s.delete(user);
		s.beginTransaction().commit();
		System.out.println("operation completed");
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		finally {
			if(s!=null){
				s.close();
			}
			
		}
		
		
		
	}
}
