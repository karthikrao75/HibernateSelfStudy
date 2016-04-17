package com.karthik.SecondHibernateDemo.HibernateEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
// it is mandatory to annotate class with Embeddable for a class to be embedded
// into entity.
//we can change column name in @Embeddable class.
public class Address {
	@Column(name = "ADDRESS_STREET")
	private String street;
	@Column(name = "ADDRESS_CITY")
	private String city;
	@Column(name = "ADDRESS_COUNTRY")
	private String country;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, String country) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
