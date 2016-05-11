package com.karthik.NamedQueryHibernateDemo.HibernateEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "User_DETAILS")
@NamedQuery(name="userDetails.byName",query="from Userdetails where userName = ? ")
@NamedQueries(value={@NamedQuery(name="userDetails.byID",query="from Userdetails where userId=?"),
					@NamedQuery(name="userDetails",query="from Userdetails")})
@NamedNativeQuery(name="native.userdetails",query="select * from User_DETAILS",resultClass=Userdetails.class)
//native method is used to write sql query instead of hql and 
//if resultclass is not used it will give classCastException
public class Userdetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Transient
	private int age;

	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Userdetails(int userId, String userName, Date dateOfBirth, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
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
