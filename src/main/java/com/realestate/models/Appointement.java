package com.realestate.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appointement {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="date")
	private Date date;
	@Column(name="first_half")
	private int first_half;
	@Column(name="second_half")
	private int second_half;
	@Column(name="id_agent")
	private int id_agent;
	@Column(name="id_lodgement")
	private int id_lodgement;
	@Column(name="id_client")
	private int id_client;
	@Column(name="agent_confirm")
	private int agent_confirm;
	@Column(name="client_confirm")
	private int client_confirm;
	@Column(name="review")
	private String review;
	@Column(name="canceled")
	private int canceled;
	@Column(name="canceler")
	private String canceler;	
	
	public Appointement() {
		super();
	}
	
	public Appointement(int id, Date date, int first_half, int second_half, int id_agent, int id_lodgement,
			int id_client, int agent_confirm, int client_confirm, String review, int canceled, String canceler) {
		super();
		this.id = id;
		this.date = date;
		this.first_half = first_half;
		this.second_half = second_half;
		this.id_agent = id_agent;
		this.id_lodgement = id_lodgement;
		this.id_client = id_client;
		this.agent_confirm = agent_confirm;
		this.client_confirm = client_confirm;
		this.review = review;
		this.canceled = canceled;
		this.canceler = canceler;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFirst_half() {
		return first_half;
	}

	public void setFirst_half(int first_half) {
		this.first_half = first_half;
	}

	public int getSecond_half() {
		return second_half;
	}

	public void setSecond_half(int second_half) {
		this.second_half = second_half;
	}

	public int getId_agent() {
		return id_agent;
	}

	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
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

	public int getAgent_confirm() {
		return agent_confirm;
	}

	public void setAgent_confirm(int agent_confirm) {
		this.agent_confirm = agent_confirm;
	}

	public int getClient_confirm() {
		return client_confirm;
	}

	public void setClient_confirm(int client_confirm) {
		this.client_confirm = client_confirm;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getCanceled() {
		return canceled;
	}

	public void setCanceled(int canceled) {
		this.canceled = canceled;
	}

	public String getCanceler() {
		return canceler;
	}

	public void setCanceler(String canceler) {
		this.canceler = canceler;
	}
		
}
