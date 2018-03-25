package com.realestate.models;

import java.util.Date;

public class Notification_details {

	private int id;
	private String message;
	private Date notification_time;
	
	private Date appointement_date;
	private String appointement_time;
	
	private String agent_confirm;
	private String client_confirm;
	
	private int id_client;
	private String client_username;
	
	private int id_lodgement;
	private String lodgement_type;
	private String lodgement_address;
	
	private int id_agent;
	private String agent_username;
	
	private boolean viewed;
	
	public Notification_details() {
		super();
	}

	public Notification_details(int id, 
			String message, 
			Date notification_time, 
			Date appointement_date,
			String appointement_time, 
			String agent_confirm, String 
			client_confirm,
			int id_client, 
			String client_username, 
			int id_lodgement, 
			String lodgement_type, 
			String lodgement_address,
			int id_agent, 
			String agent_username, 
			boolean viewed) {
		
		super();
		this.id = id;
		this.message = message;
		this.notification_time = notification_time;
		this.appointement_date = appointement_date;
		this.appointement_time = appointement_time;
		this.agent_confirm = agent_confirm;
		this.client_confirm = client_confirm;
		this.id_client = id_client;
		this.client_username = client_username;
		this.id_lodgement = id_lodgement;
		this.lodgement_type = lodgement_type;
		this.lodgement_address = lodgement_address;
		this.id_agent = id_agent;
		this.agent_username = agent_username;
		this.viewed = viewed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getNotification_time() {
		return notification_time;
	}

	public void setNotification_time(Date notification_time) {
		this.notification_time = notification_time;
	}

	public Date getAppointement_date() {
		return appointement_date;
	}

	public void setAppointement_date(Date appointement_date) {
		this.appointement_date = appointement_date;
	}

	public String getAppointement_time() {
		return appointement_time;
	}

	public void setAppointement_time(String appointement_time) {
		this.appointement_time = appointement_time;
	}

	public String getAgent_confirm() {
		return agent_confirm;
	}

	public void setAgent_confirm(String agent_confirm) {
		this.agent_confirm = agent_confirm;
	}

	public String getClient_confirm() {
		return client_confirm;
	}

	public void setClient_confirm(String client_confirm) {
		this.client_confirm = client_confirm;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getClient_username() {
		return client_username;
	}

	public void setClient_username(String client_username) {
		this.client_username = client_username;
	}

	public int getId_lodgement() {
		return id_lodgement;
	}

	public void setId_lodgement(int id_lodgement) {
		this.id_lodgement = id_lodgement;
	}

	public String getLodgement_type() {
		return lodgement_type;
	}

	public void setLodgement_type(String lodgement_type) {
		this.lodgement_type = lodgement_type;
	}

	public String getLodgement_address() {
		return lodgement_address;
	}

	public void setLodgement_address(String lodgement_address) {
		this.lodgement_address = lodgement_address;
	}

	public int getId_agent() {
		return id_agent;
	}

	public void setId_agent(int id_agent) {
		this.id_agent = id_agent;
	}

	public String getAgent_username() {
		return agent_username;
	}

	public void setAgent_username(String agent_username) {
		this.agent_username = agent_username;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	public String get_notification_time() {
		return notification_time.toString().substring(0, notification_time.toString().indexOf(" "));
	}
	
}
