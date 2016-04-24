package com.karthik.HQL_HibernateDemo.TesterPackage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.HQL_HibernateDemo.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String []args){
		Userdetails userdetails=new Userdetails();		
		userdetails.setUserName("karthik");
		
		Userdetails userdetails1=new Userdetails();		
		userdetails1.setUserName("srikanth");
		
		Userdetails userdetails2=new Userdetails();		
		userdetails2.setUserName("babishan");
		
		Configuration cfg;
		SessionFactory factory;
		Session s=null;
		try{

		cfg=new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		s=factory.openSession();
		s.getTransaction();
		s.save(userdetails);
		s.save(userdetails1);
		s.save(userdetails2);
		s.beginTransaction().commit();
		
		Query q=s.createQuery("from Userdetails u where u.userId =:user");
		q.setParameter("user", 1);
		Userdetails user=(Userdetails)q.uniqueResult();
		System.out.println(user);
		//Userdetails [userId=1, userName=karthik]
		q.setFirstResult(5);
		//will fetch the result after first 4 row that is from 5th row.
		q.setMaxResults(4);
		//will fetch maximum of four result
		//in this case it will start from 5th and fetch total 4 result by this we can use
		//pagination.
		
		// String sql="Select new map(userId,userName) from userdetails"
		//well return map list
		Query q1=s.createQuery("Update Userdetails u set u.userName =:name where u.userId =:user");
		q1.setParameter("name", "kallappa");
		q1.setParameter("user", 2);
		q1.executeUpdate();
		s.beginTransaction().commit();
		System.out.println("operation completed");
		}
		catch(Exception exception){
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
