	package com.karthik.ManyToManyMappingHibernateDemo1.TesterPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.ManyToManyMappingHibernateDemo1.HibernateEntity.Userdetails;
import com.karthik.ManyToManyMappingHibernateDemo1.HibernateEntity.Vehicle;

public class Tester {

	public static void main(String[] args) {
		Userdetails userdetails = new Userdetails();
		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclename("XXXCar");
		Vehicle vehicle2 = new Vehicle();
		vehicle.setVehiclename("YYYCar");

		userdetails.setUserName("karthik");
		
		userdetails.getVehicle().add(vehicle);
		userdetails.getVehicle().add(vehicle2);
		Configuration cfg;
		SessionFactory factory;
		Session s = null;
		try {

			cfg = new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			s = factory.openSession();
			s.getTransaction();
			s.save(userdetails);
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
