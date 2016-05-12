package com.karthik.CriteriaAPIHibernateDemo.TesterPackage;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.karthik.CriteriaAPIHibernateDemo.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String []args){
		Userdetails userdetails=new Userdetails();
		userdetails.setUserName("karthik");

		Userdetails userdetails2=new Userdetails();
		userdetails2.setUserName("karthik2");

		Userdetails userdetails3=new Userdetails();
		userdetails3.setUserName("karthik3");

		Userdetails userdetails4=new Userdetails();
		userdetails4.setUserName("karthik4");

		Userdetails userdetails5=new Userdetails();
		userdetails5.setUserName("karthik5");
		Configuration cfg;
		SessionFactory factory;
		Session s=null;
		try{
		cfg=new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		s=factory.openSession();
		s.getTransaction();
		s.save(userdetails);
		s.save(userdetails2);
		s.save(userdetails3);
		s.save(userdetails4);
		s.save(userdetails5);
		s.beginTransaction().commit();
		System.out.println("operation completed");
		
		
		Criteria criteria=s.createCriteria(Userdetails.class);
		//criteria.add(Restrictions.eq("userName", "karthik"));
		//criteria.add(Restrictions.between("userId", 3, 6));
		//criteria.add(Restrictions.gt("userId", 4));
		// add acts as And if u want or then use restrictions or as shown below
		//criteria.add(Restrictions.or(Restrictions.ge("userId", 2), Restrictions.gt("userId", 3)));
		
		//criteria.setProjection(Projections.rowCount());
		//will give number of rows 
		
		//criteria.setProjection(Projections.property("userName"));
		//will get only one column mentioned that is username
		
		criteria.addOrder(Order.desc("userName"));
		// will fetch result in descending order of username
		
		//Userdetails u=(Userdetails)criteria.uniqueResult();
		@SuppressWarnings("unchecked")
		List<Object> u=(ArrayList<Object>)criteria.list();
		
		System.out.println(u);
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
