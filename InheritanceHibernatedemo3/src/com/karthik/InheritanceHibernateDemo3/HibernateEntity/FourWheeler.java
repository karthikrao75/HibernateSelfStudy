package com.karthik.InheritanceHibernateDemo3.HibernateEntity;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
private String steeringWheel;

public String getSteeringWheel() {
	return steeringWheel;
}

public void setSteeringWheel(String steeringWheel) {
	this.steeringWheel = steeringWheel;
}

}
