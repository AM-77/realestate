package com.realestate.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	@Column(name="name")
	private String name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="birthdate")
	private Date birthdate;
	@Column(name="gender")
	private String gender;
	@Column(name="phone")
	private String phone;
	@Column(name="blocked")
	private int blocked;
	@Column(name="profile_pic")
	private String profile_pic;
	@Column(name="confirm_key")
	private String confirm_key;
	
	
	public Client(){
		super();
	}
	
	 
	public Client(int id, String email, String password, String username, String name, String last_name, Date birthdate, String gender, int blocked, String profile_pic, String phone, String confirm_key) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.blocked = blocked;
		this.profile_pic = profile_pic;
		this.phone = phone;
		this.confirm_key = confirm_key;
	}

	

	public String getConfirm_key() {
		return confirm_key;
	}


	public void setConfirm_key(String confirm_key) {
		this.confirm_key = confirm_key;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getBlocked() {
		return blocked;
	}


	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}


	public String getProfile_pic() {
		return profile_pic;
	}


	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	
	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String get_birthdate() {
		return this.birthdate.toString().substring(0, this.birthdate.toString().indexOf(" "));
	}
	
	
}
