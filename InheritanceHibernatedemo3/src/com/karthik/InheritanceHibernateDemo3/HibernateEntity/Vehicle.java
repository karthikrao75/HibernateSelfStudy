package com.karthik.InheritanceHibernateDemo3.HibernateEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//check read me for more information
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehiclename;

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

}
