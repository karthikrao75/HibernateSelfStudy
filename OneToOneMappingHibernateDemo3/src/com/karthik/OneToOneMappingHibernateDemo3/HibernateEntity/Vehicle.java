package com.karthik.OneToOneMappingHibernateDemo3.HibernateEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Vehicle {
	@Id
	@GenericGenerator(name="gen",strategy="increment",parameters=@Parameter(name="property",value="userdetails"))
	@GeneratedValue(generator="gen")
	private int vehicleId;
	private String vehiclename;
	@OneToOne(mappedBy="vehicle")
	private Userdetails userdetails;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int vehicleId, String vehiclename) {
		super();
		this.vehicleId = vehicleId;
		this.vehiclename = vehiclename;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public Userdetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Userdetails userdetails) {
		this.userdetails = userdetails;
	}
	
}
