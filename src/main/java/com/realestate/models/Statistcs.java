package com.realestate.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Statistcs {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	private int id_visitor;
	private String type_visitor;
	private Date date;
	
	public Statistcs(int id, int id_visitor, String type_visitor, Date date) {
		super();
		this.id = id;
		this.id_visitor = id_visitor;
		this.type_visitor = type_visitor;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_visitor() {
		return id_visitor;
	}
	
	public void setId_visitor(int id_visitor) {
		this.id_visitor = id_visitor;
	}
	
	public String getType_visitor() {
		return type_visitor;
	}
	
	public void setType_visitor(String type_visitor) {
		this.type_visitor = type_visitor;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
