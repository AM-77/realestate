package com.realestate.models;

import java.util.Map;

public class Statistcs_details {
	
	private int nbr_all_website_visites;
	private int nbr_client_website_visites;
	private int nbr_agent_website_visites;
	private int nbr_operator_website_visites;
	private double percent_client_website_visites;
	private double percent_agent_website_visites;
	private double percent_operator_website_visites;
	private Map<String, Integer> nbr_all_visites_website_by_clients_mounths;
	private Map<String, Double> percent_all_visites_website_by_clients_mounths;
	private Map<String, Integer> nbr_all_visites_website_by_agents_mounths;
	private Map<String, Double> percent_all_visites_website_by_agents_mounths;
	private Map<String, Integer> nbr_all_visites_website_by_operators_mounths;
	private Map<String, Double> percent_all_visites_website_by_operators_mounths;
	
	
	
	public int getNbr_all_website_visites() {
		return nbr_all_website_visites;
	}

	public void setNbr_all_website_visites(int nbr_all_website_visites) {
		this.nbr_all_website_visites = nbr_all_website_visites;
	}

	public int getNbr_client_website_visites() {
		return nbr_client_website_visites;
	}

	public void setNbr_client_website_visites(int nbr_client_website_visites) {
		this.nbr_client_website_visites = nbr_client_website_visites;
	}

	public int getNbr_agent_website_visites() {
		return nbr_agent_website_visites;
	}

	public void setNbr_agent_website_visites(int nbr_agent_website_visites) {
		this.nbr_agent_website_visites = nbr_agent_website_visites;
	}

	public int getNbr_operator_website_visites() {
		return nbr_operator_website_visites;
	}

	public void setNbr_operator_website_visites(int nbr_operator_website_visites) {
		this.nbr_operator_website_visites = nbr_operator_website_visites;
	}

	public double getPercent_client_website_visites() {
		return percent_client_website_visites;
	}

	public void setPercent_client_website_visites(double percent_client_website_visites) {
		this.percent_client_website_visites = percent_client_website_visites;
	}

	public double getPercent_agent_website_visites() {
		return percent_agent_website_visites;
	}

	public void setPercent_agent_website_visites(double percent_agent_website_visites) {
		this.percent_agent_website_visites = percent_agent_website_visites;
	}

	public double getPercent_operator_website_visites() {
		return percent_operator_website_visites;
	}

	public void setPercent_operator_website_visites(double percent_operator_website_visites) {
		this.percent_operator_website_visites = percent_operator_website_visites;
	}

	public Map<String, Integer> getNbr_all_visites_website_by_clients_mounths() {
		return nbr_all_visites_website_by_clients_mounths;
	}

	public void setNbr_all_visites_website_by_clients_mounths(
			Map<String, Integer> nbr_all_visites_website_by_clients_mounths) {
		this.nbr_all_visites_website_by_clients_mounths = nbr_all_visites_website_by_clients_mounths;
	}

	public Map<String, Double> getPercent_all_visites_website_by_clients_mounths() {
		return percent_all_visites_website_by_clients_mounths;
	}

	public void setPercent_all_visites_website_by_clients_mounths(
			Map<String, Double> percent_all_visites_website_by_clients_mounths) {
		this.percent_all_visites_website_by_clients_mounths = percent_all_visites_website_by_clients_mounths;
	}

	public Map<String, Integer> getNbr_all_visites_website_by_agents_mounths() {
		return nbr_all_visites_website_by_agents_mounths;
	}

	public void setNbr_all_visites_website_by_agents_mounths(
			Map<String, Integer> nbr_all_visites_website_by_agents_mounths) {
		this.nbr_all_visites_website_by_agents_mounths = nbr_all_visites_website_by_agents_mounths;
	}

	public Map<String, Double> getPercent_all_visites_website_by_agents_mounths() {
		return percent_all_visites_website_by_agents_mounths;
	}

	public void setPercent_all_visites_website_by_agents_mounths(
			Map<String, Double> percent_all_visites_website_by_agents_mounths) {
		this.percent_all_visites_website_by_agents_mounths = percent_all_visites_website_by_agents_mounths;
	}

	public Map<String, Integer> getNbr_all_visites_website_by_operators_mounths() {
		return nbr_all_visites_website_by_operators_mounths;
	}

	public void setNbr_all_visites_website_by_operators_mounths(
			Map<String, Integer> nbr_all_visites_website_by_operators_mounths) {
		this.nbr_all_visites_website_by_operators_mounths = nbr_all_visites_website_by_operators_mounths;
	}

	public Map<String, Double> getPercent_all_visites_website_by_operators_mounths() {
		return percent_all_visites_website_by_operators_mounths;
	}

	public void setPercent_all_visites_website_by_operators_mounths(
			Map<String, Double> percent_all_visites_website_by_operators_mounths) {
		this.percent_all_visites_website_by_operators_mounths = percent_all_visites_website_by_operators_mounths;
	}

	
}
