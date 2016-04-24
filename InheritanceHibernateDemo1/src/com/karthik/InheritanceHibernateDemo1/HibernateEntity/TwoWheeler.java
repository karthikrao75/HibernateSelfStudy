package com.karthik.InheritanceHibernateDemo1.HibernateEntity;

import javax.persistence.DiscriminatorValue;
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
