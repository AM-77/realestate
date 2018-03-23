package com.realestate.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agent {

	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String password;
	private String username;
	private String name;
	private String last_name;
	private Date birthdate;
	private String gender;
	private String locale;
	private int blocked;
	private String profile_pic;
	private String cv;
	private String phone;
	private String confirm_key;
	
	public Agent() {
		super();
	}
	 
	public Agent(int id, String email, String password, String username, String name, String last_name, Date birthdate, String gender, String locale, int blocked, String profile_pic, String cv,String phone, String confirm_key) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.locale = locale;
		this.blocked = blocked;
		this.profile_pic = profile_pic;
		this.cv = cv;
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


	public String getLocale() {
		return locale;
	}


	public void setLocale(String locale) {
		this.locale = locale;
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


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String get_birthdate() {
		return getBirthdate().toString().substring(0, getBirthdate().toString().indexOf(" "));
	}
	
	public boolean cv_exsites() {
		if(this.cv.length() != 0)
			return true;
		else
			return false;
	}
}
