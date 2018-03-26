package com.realestate.models;

public class My_Appointement {

	private int id;
	private String date;
	private String half;
	private int id_agent;
	private String agent_username;
	private int id_client;
	private String client_username;
	private int id_lodgement;
	private String lodgement_address;
	private String lodgement_type;
	private boolean can_confirm;
	private String agent_confirm;
	private String client_confirm;
	private String review;
	private int canceled;

	public My_Appointement(int id, String date, String half, int id_agent, String agent_username, int id_client, String client_username, int id_lodgement, String lodgement_address, String lodgement_type, String agent_confirm, String client_confirm, String review, int canceled, boolean can_confirm) {
		this.id = id;
		this.date = date;
		this.half = half;
		this.id_agent = id_agent;
		this.agent_username = agent_username;
		this.id_lodgement = id_lodgement;
		this.lodgement_address = lodgement_address;
		this.lodgement_type = lodgement_type;
		this.can_confirm = can_confirm;
		this.agent_confirm = agent_confirm;
		this.client_confirm = client_confirm;
		this.review = review;
		this.canceled = canceled;
		this.id_client = id_client;
		this.client_username = client_username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHalf() {
		return half;
	}

	public void setHalf(String half) {
		this.half = half;
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

	public int getId_lodgement() {
		return id_lodgement;
	}

	public void setId_lodgement(int id_lodgement) {
		this.id_lodgement = id_lodgement;
	}

	public String getLodgement_address() {
		return lodgement_address;
	}

	public void setLodgement_address(String lodgement_address) {
		this.lodgement_address = lodgement_address;
	}

	public String getLodgement_type() {
		return lodgement_type;
	}

	public void setLodgement_type(String lodgement_type) {
		this.lodgement_type = lodgement_type;
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

	public boolean isCan_confirm() {
		return can_confirm;
	}

	public void setCan_confirm(boolean can_confirm) {
		this.can_confirm = can_confirm;
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
	
}
