package com.cmpe202.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Userprofile")
public class Userprofile implements Serializable {


	public Userprofile(String id, String firstname, String lastname, String password, String emailid, String phoneno) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.emailid = emailid;
		this.phoneno = phoneno;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 76802965758923183L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	String id;
	@Column(name = "firstname")
	String firstname;
	@Column(name = "lastname")
	String lastname;
	@Column(name = "password")
	String password;
	@Column(name = "emailid")
	String emailid;
	@Column(name = "phoneno")
	String phoneno;

	

	@Override
	public String toString() {
		return "Userprofile [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", emailid=" + emailid + ", phoneno=" + phoneno + "]";
	}

	public Userprofile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	

	



}
