package com.karthik.InheritanceHibernateDemo2.HibernateEntity;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
private String steeringhandle;

public String getSteeringhandle() {
	return steeringhandle;
}

public void setSteeringhandle(String steeringhandle) {
	this.steeringhandle = steeringhandle;
}

}
