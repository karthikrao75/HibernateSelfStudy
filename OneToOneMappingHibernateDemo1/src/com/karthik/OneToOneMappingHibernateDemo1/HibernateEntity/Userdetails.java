package com.karthik.OneToOneMappingHibernateDemo1.HibernateEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
// (name="U_DETAILS")
@Table(name = "User_DETAILS")
// if both have name then @table is given preference.
public class Userdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	//@joincolumn will rename the foreign key column name
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userdetails(int userId, String userName, Vehicle vehicle) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.vehicle = vehicle;

	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Userdetails [userId=" + userId + ", userName=" + userName + "]";
	}

}
