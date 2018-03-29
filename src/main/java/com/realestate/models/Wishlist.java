package com.realestate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wishlist {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="id_client")
	private int id_client;
	@Column(name="address")
	private String address;
	@Column(name="type")
	private String type;
	@Column(name="max_surface")
	private double max_surface;
	@Column(name="min_surface")
	private double min_surface;
	@Column(name="max_price")
	private double max_price;
	@Column(name="min_price")
	private double min_price;
	@Column(name="max_floor")
	private int max_floor;
	@Column(name="min_floor")
	private int min_floor;
	@Column(name="found")
	private boolean found;
	@Column(name="id_found")
	private int id_found;
	
	public Wishlist() {
		super();
	}
	
	
	public Wishlist(int id, int id_client, String address, String type, double max_surface, double min_surface,
			double max_price, double min_price, int max_floor, int min_floor, boolean found, int id_found) {
		super();
		this.id = id;
		this.id_client = id_client;
		this.address = address;
		this.type = type;
		this.max_surface = max_surface;
		this.min_surface = min_surface;
		this.max_price = max_price;
		this.min_price = min_price;
		this.max_floor = max_floor;
		this.min_floor = min_floor;
		this.found = found;
		this.id_found = id_found;
	}

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
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


	public double getMax_surface() {
		return max_surface;
	}


	public void setMax_surface(double max_surface) {
		this.max_surface = max_surface;
	}


	public double getMin_surface() {
		return min_surface;
	}


	public void setMin_surface(double min_surface) {
		this.min_surface = min_surface;
	}


	public double getMax_price() {
		return max_price;
	}


	public void setMax_price(double max_price) {
		this.max_price = max_price;
	}


	public double getMin_price() {
		return min_price;
	}


	public void setMin_price(double min_price) {
		this.min_price = min_price;
	}


	public int getMax_floor() {
		return max_floor;
	}


	public void setMax_floor(int max_floor) {
		this.max_floor = max_floor;
	}


	public int getMin_floor() {
		return min_floor;
	}


	public void setMin_floor(int min_floor) {
		this.min_floor = min_floor;
	}


	public boolean isFound() {
		return found;
	}


	public void setFound(boolean found) {
		this.found = found;
	}


	public int getId_found() {
		return id_found;
	}


	public void setId_found(int id_found) {
		this.id_found = id_found;
	}


	public int get_min_price() {
		return new Double(min_price).intValue();
	}
	
	public int get_max_price() {
		return new Double(max_price).intValue();
	}
		
}
