package com.ds;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Regdatastore {
	@Persistent
	private String firstname;
	@PrimaryKey
	@Persistent
	private String email;
	@Persistent
	private String password;

	public Regdatastore(String firstname, String email, String password) {
	
		this.firstname = firstname;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Regdatastore [firstname=" + firstname + ", email=" + email + ", password=" + password + "]";
	}

}
