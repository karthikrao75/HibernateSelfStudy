	package com.karthik.OneToManyMappingHibernateDemo2.TesterPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.OneToManyMappingHibernateDemo2.HibernateEntity.Userdetails;
import com.karthik.OneToManyMappingHibernateDemo2.HibernateEntity.Vehicle;

public class Tester {

	public static void main(String[] args) {
		Userdetails userdetails = new Userdetails();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclename("XXXCar");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehiclename("YYYCar");

		userdetails.setUserName("karthik");
		Configuration cfg;
		SessionFactory factory;
		Session s = null;
		try {

			cfg = new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			s = factory.openSession();
			s.getTransaction();
			vehicle.setUserdetails(userdetails);
			vehicle2.setUserdetails(userdetails);
			s.save(vehicle);
			s.save(vehicle2);
			s.beginTransaction().commit();
			System.out.println("operation completed");
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}

		}

	}
}
