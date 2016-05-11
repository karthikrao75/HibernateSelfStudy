package com.karthik.NamedQueryHibernateDemo.TesterPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.NamedQueryHibernateDemo.HibernateEntity.Userdetails;

public class Tester {

	public static void main(String[] args) {
		Userdetails userdetails = new Userdetails();

		userdetails.setUserName("karthik");
		// object is in transient state
		Configuration cfg;
		SessionFactory factory;
		Session s = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date d = dateFormat.parse("07-05-1992");
			System.out.println(d.toString());
			userdetails.setDateOfBirth(d);
			cfg = new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			s = factory.openSession();
			s.getTransaction();
			s.save(userdetails);
			// persistence state
			s.beginTransaction().commit();
			System.out.println("operation completed");

			Query q = s.getNamedQuery("userDetails.byName");
			q.setString(0, "karthik");
			Userdetails u = (Userdetails) q.uniqueResult();
			System.out.println(u);

			Query q1 = s.getNamedQuery("userDetails.byID");
			q1.setInteger(0, 1);
			Userdetails u1 = (Userdetails) q1.uniqueResult();
			System.out.println(u1);

			Query q2 = s.getNamedQuery("native.userdetails");
			Userdetails u2 = (Userdetails) q2.uniqueResult();
			System.out.println(u2);
		} catch (ParseException exception) {
			exception.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}

		}

	}
}
