package com.karthik.InheritanceHibernateDemo1.TesterPackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karthik.InheritanceHibernateDemo1.HibernateEntity.FourWheeler;
import com.karthik.InheritanceHibernateDemo1.HibernateEntity.TwoWheeler;
import com.karthik.InheritanceHibernateDemo1.HibernateEntity.Vehicle;

public class Tester {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehiclename("XXXCar");

		TwoWheeler bike=new TwoWheeler();
		bike.setSteeringhandle("bike steering from handle");
		
		FourWheeler car=new FourWheeler();
		car.setSteeringWheel("car steering from wheel");

		Configuration cfg;
		SessionFactory factory;
		Session s = null;
		try {

			cfg = new Configuration().configure("/Resource/HibernateResource/hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
			s = factory.openSession();
			s.getTransaction();
			s.save(vehicle);
			s.save(bike);
			s.save(car);
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
