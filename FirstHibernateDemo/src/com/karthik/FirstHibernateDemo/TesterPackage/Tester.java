package com.karthik.FirstHibernateDemo.TesterPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.FirstHibernateDemo.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String []args){
		Userdetails userdetails=new Userdetails();
		userdetails.setUserId(1);
		userdetails.setUserName("karthik");
		Configuration cfg=new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		s.getTransaction();
		s.save(userdetails);
		s.beginTransaction().commit();
		s.close();
		System.out.println("operation completed");
		
	}
}
