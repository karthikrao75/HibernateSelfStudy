package com.karthik.FirstHibernateDemo.HibernateEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userdetails {
	@Id
private int userId;
private String userName;
public Userdetails() {
	super();
	// TODO Auto-generated constructor stub
}
public Userdetails(int userId, String userName) {
	super();
	this.userId = userId;
	this.userName = userName;
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
