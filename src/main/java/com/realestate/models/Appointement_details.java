package com.realestate.models;

import java.util.List;

public class Appointement_details {

	private String date;
	private String half;
	private List<Agent> agents;

	public Appointement_details(String date, String half, List<Agent> agents) {
		this.date = date;
		this.half = half;
		this.agents = agents;
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

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	
}
