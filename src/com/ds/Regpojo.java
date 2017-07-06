package com.ds;

public class Regpojo {
	
	private String firstname;
	private String email;
	private String password;
	
	public String getName() {
		return firstname;
	}
	public void setName(String name) {
		this.firstname = firstname;
	}
	public Regpojo(String name, String email, String password) {
		super();
		this.firstname = name;
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "Regpojo [name=" + firstname + ", email=" + email + ", password=" + password + "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
