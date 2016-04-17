package com.karthik.SecondHibernateDemo.HibernateEntity;

import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User_DETAILS")
public class Userdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Embedded
	//it is not mandatory to put Embedded, only address class has to have @Embeddable annotation.
	// column name of address class attribute can be changed in @Embeddable class 
	private Address address;

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Userdetails [userId=" + userId + ", userName=" + userName + "]";
	}

}
