package com.realestate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String password;
	private String name;
	private String last_name;
	private String phone;
	private String profile_pic;
	
	public Admin() {
		super();
	}
	 
	public Admin(int id, 
				  String email, 
				  String password, 
				  String name, 
				  String last_name, 
				  String phone, 
				  String profile_pic) {
		
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.last_name = last_name;
		this.phone = phone;
		this.profile_pic = profile_pic;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getProfile_pic() {
		return profile_pic;
	}


	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	
	
}
