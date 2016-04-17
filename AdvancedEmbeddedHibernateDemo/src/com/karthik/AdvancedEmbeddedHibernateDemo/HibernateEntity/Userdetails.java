package com.karthik.AdvancedEmbeddedHibernateDemo.HibernateEntity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HomeAddress_Street")),
		@AttributeOverride(name="city",column=@Column(name="HomeAddress_City")),
		@AttributeOverride(name="country",column=@Column(name="HomeAddress_Country")),
	})
	private Address homeAddress;
	
	@Embedded
	//if u want to change the column name of this address, do same as above
	private Address officeAddress;

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Userdetails(int userId, String userName, Date dateOfBirth, Address homeAddress, Address officeAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
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



	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "Userdetails [userId=" + userId + ", userName=" + userName + "]";
	}

}
