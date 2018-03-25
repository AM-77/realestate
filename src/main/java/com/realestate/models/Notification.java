package com.realestate.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue
	private int id;
	private int id_appointement;
	private String client_notif;
	private String agent_notif;
	private Date time;
	private int v_agent;
	private int v_client;
	
	public Notification() {
		super();
	}
	
	public Notification(int id, int id_appointement, String client_notif, String agent_notif, Date time, int v_agent, int v_client) {
		this.id = id;
		this.id_appointement = id_appointement;
		this.client_notif = client_notif;
		this.agent_notif = agent_notif;
		this.time= time;
		this.v_agent = v_agent;
		this.v_client = v_client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_appointement() {
		return id_appointement;
	}

	public void setId_appointement(int id_appointement) {
		this.id_appointement = id_appointement;
	}

	public String getClient_notif() {
		return client_notif;
	}

	public void setClient_notif(String client_notif) {
		this.client_notif = client_notif;
	}

	public String getAgent_notif() {
		return agent_notif;
	}

	public void setAgent_notif(String agent_notif) {
		this.agent_notif = agent_notif;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getV_agent() {
		return v_agent;
	}

	public void setV_agent(int v_agent) {
		this.v_agent = v_agent;
	}

	public int getV_client() {
		return v_client;
	}

	public void setV_client(int v_client) {
		this.v_client = v_client;
	}
	
}
