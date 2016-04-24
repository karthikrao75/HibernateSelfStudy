package com.karthik.InheritanceHibernateDemo1.HibernateEntity;

import javax.persistence.DiscriminatorValue;
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
