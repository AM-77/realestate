package com.realestate.models;

import java.util.Date;

public class Lodgement_detail {
	
	private String profile_pic;
	private String username;
	private Date date;
	private String half;
	private String review;
	
	public Lodgement_detail(String profile_pic, String username, Date date, String half, String review) {
		super();
		this.profile_pic = profile_pic;
		this.username = username;
		this.date = date;
		this.half = half;
		this.review = review;
	}
	
	public String getProfile_pic() {
		return profile_pic;
	}
	
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHalf() {
		return half;
	}
	
	public void setHalf(String half) {
		this.half = half;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}
	
}
