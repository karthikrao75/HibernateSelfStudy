package com.karthik.EmbeddingCollectionHibernateDemo3.TesterPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.EmbeddingCollectionHibernateDemo3.HibernateEntity.Address;
import com.karthik.EmbeddingCollectionHibernateDemo3.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String... args){
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
		Address address1=new Address("E-city","Bengaluru","India");
		Set<Address> address_List=new HashSet<Address>();
		
		address_List.add(address);
		address_List.add(address1);
		userdetails.setAddress_List(address_List);
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
