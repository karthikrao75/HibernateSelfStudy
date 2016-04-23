package com.karthik.EagerLazyHibernateDemo.Tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.EagerLazyHibernateDemo.HibernateEntity.Address;
import com.karthik.EagerLazyHibernateDemo.HibernateEntity.Userdetails;

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
		s.close();
		s=factory.openSession();
		Userdetails u=s.get(Userdetails.class, 1);
		//default method used by hibernate is Lazy that is while fetching userdetails
		//it wont fetch address details which is annotated by @ElementCollection
		/*
		 * in hibernate our entity class will have corresponding proxy (class)object 
		 * which internally interacts with database
		 * Entity class -----------> Proxy class ----------------> dataBase 
		 * when the fetchType is Lazy this proxy class will get only those values from database which
		 * are directly related to Entity class table and wont fetch value from related table(other mapped tables)
		 * hence in this case address details are not fetched   
		 * */ 
		 //but within the session if we try to fetch address details using userdetails object 
		//it will internally call proxy class and fetch the value of address.
		
		//Set<Address> address2=u.getAddress_List();
		//System.out.println(address2.size());
		//2
		s.close();
		System.out.println(u.getUserId());
		//1
		//In lazy method if we try to get address details after closing session it 
		//will give us org.hibernate.LazyInitializationException: failed to lazily initialize a collection of 
		//role: com.karthik.EagerLazyHibernateDemo.HibernateEntity.Userdetails.address_List, could not initialize proxy - no Session exception
		//same if we keep address details in eager method then it will fetch all the details in a go. 
		Set<Address> address2=u.getAddress_List();
		
		System.out.println(address2.size());
		//then size would be 2.
		}
		catch(ParseException exception){
			exception.printStackTrace();
		}
		finally {
			if(s!=null){
				//s.close();
			}
			
		}
		
		
		
	}
}
