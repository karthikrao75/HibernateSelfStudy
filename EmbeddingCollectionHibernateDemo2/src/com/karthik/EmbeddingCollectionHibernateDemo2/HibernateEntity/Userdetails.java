package com.karthik.EmbeddingCollectionHibernateDemo2.HibernateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@ElementCollection

	//since the table created by hibernate for collection will be name entity_embeddedClass
	//if we want to change new table name 
	//if foreign key column name has to be changed then use joincolumns
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="user_Id")
			)
	private Set<Address> address_List=new HashSet<Address>();

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


	public Set<Address> getAddress_List() {
		return address_List;
	}

	public void setAddress_List(Set<Address> address_List) {
		this.address_List = address_List;
	}

	@Override
	public String toString() {
		return "Userdetails [userId=" + userId + ", userName=" + userName + "]";
	}

}
