package com.realestate.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Favorite {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int id_lodgement;
	private int id_client;
	private Date time;
	
	public Favorite() {
		super();
	}
	
	public Favorite(int id, int id_lodgement, int id_client, Date time) {
		this.id = id;
		this.id_lodgement = id_lodgement;
		this.id_client = id_client;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_lodgement() {
		return id_lodgement;
	}

	public void setId_lodgement(int id_lodgement) {
		this.id_lodgement = id_lodgement;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
