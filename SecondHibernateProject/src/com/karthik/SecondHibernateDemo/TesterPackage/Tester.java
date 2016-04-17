package com.karthik.SecondHibernateDemo.TesterPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.SecondHibernateDemo.HibernateEntity.Address;
import com.karthik.SecondHibernateDemo.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String []args){
		Userdetails userdetails=new Userdetails();
		
		userdetails.setUserName("karthik");
		Configuration cfg;
		SessionFactory factory;
		Session s=null;
		try{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date d=dateFormat.parse("07-05-1992");
		
		userdetails.setDateOfBirth(d);
		Address address=new Address("BTM 2nd Stage", "Bengaluru", "India");
		userdetails.setAddress(address);
		cfg=new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		s=factory.openSession();
		s.getTransaction();
		s.save(userdetails);
		s.beginTransaction().commit();
		System.out.println("operation completed");
		}
		catch(ParseException exception){
			exception.printStackTrace();
		}
		finally {
			if(s!=null){
				s.close();
			}
			
		}
		
		
		
	}
}
