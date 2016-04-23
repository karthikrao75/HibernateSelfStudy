package com.karthik.OneToManyMappingHibernateDemo2.HibernateEntity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_DETAILS")

public class Userdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	@OneToMany(mappedBy="userdetails")
	//in this new table with primary key of both the table will be created
	//@joinTable name attribute will give it a new table name
	//joincolumn will rename primary column name key of this class to new name
	//inverseJoinColumns will rename pk of other mapped table

	private Collection<Vehicle> vehicle = new ArrayList<>();

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userdetails(int userId, String userName, Collection<Vehicle> vehicle) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.vehicle = vehicle;

	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
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
