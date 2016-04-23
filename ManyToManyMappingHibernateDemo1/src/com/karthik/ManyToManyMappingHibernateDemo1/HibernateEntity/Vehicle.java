package com.karthik.ManyToManyMappingHibernateDemo1.HibernateEntity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehiclename;
	@ManyToMany(mappedBy = "vehicle")
	private Collection<Userdetails> userdetails = new ArrayList<Userdetails>();

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int vehicleId, String vehiclename, Collection<Userdetails> userdetails) {
		super();
		this.vehicleId = vehicleId;
		this.vehiclename = vehiclename;
		this.userdetails = userdetails;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public Collection<Userdetails> getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Collection<Userdetails> userdetails) {
		this.userdetails = userdetails;
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

}
