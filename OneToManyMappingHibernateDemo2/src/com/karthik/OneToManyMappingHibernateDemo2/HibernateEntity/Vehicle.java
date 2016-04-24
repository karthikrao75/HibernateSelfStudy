package com.karthik.OneToManyMappingHibernateDemo2.HibernateEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehiclename;
	//bi-directional where vehicle is owner
	//since mappedby is used no new table is created 
	//instead a foreign key column is added in vehicle table
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="User_Id",nullable=false)
	private Userdetails userdetails;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int vehicleId, String vehiclename,Userdetails userdetails) {
		super();
		this.vehicleId = vehicleId;
		this.vehiclename = vehiclename;
		this.userdetails=userdetails;
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
