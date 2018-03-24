package com.realestate.models;

public class Favorite_details {
	
	private int id;
	private int id_lodg;
	private String type;
	private String address;
	private String date;
	private String time;
	

	public Favorite_details() {
		super();
	}
	
	public Favorite_details(int id, int id_lodg, String type, String address, String date, String time) {
		this.id = id;
		this.id_lodg = id_lodg;
		this.type = type;
		this.address = address;
		this.time =  time;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_lodg() {
		return id_lodg;
	}

	public void setId_lodg(int id_lodg) {
		this.id_lodg = id_lodg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
