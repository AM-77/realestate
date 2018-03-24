package com.realestate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lodgement {

	@Id
	@GeneratedValue
	private int id;
	
	private float price;
	private double surface;
	private String address;
	private String type;
	private int locale;
	private String pics;
	private int floor;
	private int sold;
	
	public Lodgement() {
		super();
	}
	
	public Lodgement(int id, float price, double surface, String address, String type, int locale, String pics,
			int floor, int sold) {
		super();
		this.id = id;
		this.price = price;
		this.surface = surface;
		this.address = address;
		this.type = type;
		this.locale = locale;
		this.pics = pics;
		this.floor = floor;
		this.sold = sold;
	}


	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLocale() {
		return locale;
	}

	public void setLocale(int locale) {
		this.locale = locale;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int get_price() {
		return new Double(price).intValue();
	}
	
}
