package com.karthik.SecondLevelCacheHibernateDemo.TesterPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.SecondLevelCacheHibernateDemo.HibernateEntity.Userdetails;

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
	System.out.println(d.toString());
		userdetails.setDateOfBirth(d);
		cfg=new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		s=factory.openSession();
		s.getTransaction();
		s.save(userdetails);
		s.beginTransaction().commit();
		System.out.println("insert operation completed");
		
		Userdetails user=(Userdetails)s.get(Userdetails.class, 1);
		//since this object is already cached by hibernate ,no select query is used to get the user.
		System.out.println("get user");
		
		Session s1=factory.openSession();
		Userdetails user1=(Userdetails)s1.get(Userdetails.class, 1);
		//since we have used second level cache no select query is used .
		}
		catch(ParseException exception){
			exception.printStackTrace();
		}
		finally {
			if(s!=null){
				s.close();
				//detached state
			}
			
		}
		
		
		
	}
}
