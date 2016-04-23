package com.karthik.OneToOneMappingHibernateDemo2.HibernateEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehiclename;
	@OneToOne(cascade = CascadeType.ALL,mappedBy="vehicle")
	@JoinColumn(name="User_Id")
	private Userdetails userdetails;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int vehicleId, String vehiclename, Userdetails userdetails) {
		super();
		this.vehicleId = vehicleId;
		this.vehiclename = vehiclename;
		this.userdetails = userdetails;
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
