package com.karthik.EmbeddingCollectionHibernateDemo3.HibernateEntity;

import java.util.ArrayList;
import java.util.Collection;
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

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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

	
	// since HashSet dosen't support indexing we have to change it to arrayList
	//or any other collection which supports indexing.to generate Id.
	@JoinTable(name = "USER_ADDRESS", 
	joinColumns = @JoinColumn(name = "user_Id")
	)
	@GenericGenerator(name="increment",strategy="increment")
	@CollectionId(columns=@Column(name="address_Id"),generator="increment",type=@Type(type="long"))
	private Collection<Address> address_List = new ArrayList<Address>();

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

	public Collection<Address> getAddress_List() {
		return address_List;
	}

	public void setAddress_List(Collection<Address> address_List) {
		this.address_List = address_List;
	}

	@Override
	public String toString() {
		return "Userdetails [userId=" + userId + ", userName=" + userName + "]";
	}

}
