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
	
	private int nbr_appoi_locale_one;
	private int nbr_appoi_locale_two;
	private int nbr_appoi_locale_three;
	private int nbr_appoi_locale_four;
	private int nbr_appoi_locale_five;
	private double percent_appoi_locale_one;
	private double percent_appoi_locale_two;
	private double percent_appoi_locale_three;
	private double percent_appoi_locale_four;
	private double percent_appoi_locale_five;
	
	private int nbr_appoi_F1;
	private int nbr_appoi_F2;
	private int nbr_appoi_F3;
	private int nbr_appoi_F4;
	private int nbr_appoi_F5;
	private double percent_appoi_F1;
	private double percent_appoi_F2;
	private double percent_appoi_F3;
	private double percent_appoi_F4;
	private double percent_appoi_F5;
	
	private int nbr_appointement_canceled;
	private double percent_appointement_canceled;
	private int nbr_appointement_canceled_by_clients;
	private int nbr_appointement_canceled_by_agents;
	private double percent_appointement_canceled_by_clients;
	private double percent_appointement_canceled_by_agents;
	
	private int nbr_appointement_confirmed;
	private double percent_appointement_confirmed;
	private int nbr_appointement_confirmed_by_clients;
	private int nbr_appointement_confirmed_by_agents;
	private double percent_appointement_confirmed_by_clients;
	private double percent_appointement_confirmed_by_agents;
	
	private int nbr_appointement_reported;
	private double percent_appointement_reported;
	private int nbr_appointement_reported_by_clients;
	private int nbr_appointement_reported_by_agents;
	private double percent_appointement_reported_by_clients;
	private double percent_appointement_reported_by_agents;
	
	private int nbr_all_appoi;
	private int nbr_appointement_waiting_clients;
	private int nbr_appointement_waiting_agents;
	
	public Statistcs_details(int nbr_all_website_visites, int nbr_client_website_visites, int nbr_agent_website_visites,
			int nbr_operator_website_visites, double percent_client_website_visites,
			double percent_agent_website_visites, double percent_operator_website_visites,
			Map<String, Integer> nbr_all_visites_website_by_clients_mounths,
			Map<String, Double> percent_all_visites_website_by_clients_mounths,
			Map<String, Integer> nbr_all_visites_website_by_agents_mounths,
			Map<String, Double> percent_all_visites_website_by_agents_mounths,
			Map<String, Integer> nbr_all_visites_website_by_operators_mounths,
			Map<String, Double> percent_all_visites_website_by_operators_mounths, int nbr_appoi_locale_one,
			int nbr_appoi_locale_two, int nbr_appoi_locale_three, int nbr_appoi_locale_four, int nbr_appoi_locale_five,
			double percent_appoi_locale_one, double percent_appoi_locale_two, double percent_appoi_locale_three,
			double percent_appoi_locale_four, double percent_appoi_locale_five, int nbr_appoi_F1, int nbr_appoi_F2,
			int nbr_appoi_F3, int nbr_appoi_F4, int nbr_appoi_F5, double percent_appoi_F1, double percent_appoi_F2,
			double percent_appoi_F3, double percent_appoi_F4, double percent_appoi_F5, int nbr_appointement_canceled,
			double percent_appointement_canceled, int nbr_appointement_canceled_by_clients,
			int nbr_appointement_canceled_by_agents, double percent_appointement_canceled_by_clients,
			double percent_appointement_canceled_by_agents, int nbr_appointement_confirmed,
			double percent_appointement_confirmed, int nbr_appointement_confirmed_by_clients,
			int nbr_appointement_confirmed_by_agents, double percent_appointement_confirmed_by_clients,
			double percent_appointement_confirmed_by_agents, int nbr_appointement_reported,
			double percent_appointement_reported, int nbr_appointement_reported_by_clients,
			int nbr_appointement_reported_by_agents, double percent_appointement_reported_by_clients,
			double percent_appointement_reported_by_agents, int nbr_all_appoi,
			int nbr_appointement_waiting_clients, int nbr_appointement_waiting_agents) {
		super();
		this.nbr_all_website_visites = nbr_all_website_visites;
		this.nbr_client_website_visites = nbr_client_website_visites;
		this.nbr_agent_website_visites = nbr_agent_website_visites;
		this.nbr_operator_website_visites = nbr_operator_website_visites;
		this.percent_client_website_visites = percent_client_website_visites;
		this.percent_agent_website_visites = percent_agent_website_visites;
		this.percent_operator_website_visites = percent_operator_website_visites;
		this.nbr_all_visites_website_by_clients_mounths = nbr_all_visites_website_by_clients_mounths;
		this.percent_all_visites_website_by_clients_mounths = percent_all_visites_website_by_clients_mounths;
		this.nbr_all_visites_website_by_agents_mounths = nbr_all_visites_website_by_agents_mounths;
		this.percent_all_visites_website_by_agents_mounths = percent_all_visites_website_by_agents_mounths;
		this.nbr_all_visites_website_by_operators_mounths = nbr_all_visites_website_by_operators_mounths;
		this.percent_all_visites_website_by_operators_mounths = percent_all_visites_website_by_operators_mounths;
		this.nbr_appoi_locale_one = nbr_appoi_locale_one;
		this.nbr_appoi_locale_two = nbr_appoi_locale_two;
		this.nbr_appoi_locale_three = nbr_appoi_locale_three;
		this.nbr_appoi_locale_four = nbr_appoi_locale_four;
		this.nbr_appoi_locale_five = nbr_appoi_locale_five;
		this.percent_appoi_locale_one = percent_appoi_locale_one;
		this.percent_appoi_locale_two = percent_appoi_locale_two;
		this.percent_appoi_locale_three = percent_appoi_locale_three;
		this.percent_appoi_locale_four = percent_appoi_locale_four;
		this.percent_appoi_locale_five = percent_appoi_locale_five;
		this.nbr_appoi_F1 = nbr_appoi_F1;
		this.nbr_appoi_F2 = nbr_appoi_F2;
		this.nbr_appoi_F3 = nbr_appoi_F3;
		this.nbr_appoi_F4 = nbr_appoi_F4;
		this.nbr_appoi_F5 = nbr_appoi_F5;
		this.percent_appoi_F1 = percent_appoi_F1;
		this.percent_appoi_F2 = percent_appoi_F2;
		this.percent_appoi_F3 = percent_appoi_F3;
		this.percent_appoi_F4 = percent_appoi_F4;
		this.percent_appoi_F5 = percent_appoi_F5;
		this.nbr_appointement_canceled = nbr_appointement_canceled;
		this.percent_appointement_canceled = percent_appointement_canceled;
		this.nbr_appointement_canceled_by_clients = nbr_appointement_canceled_by_clients;
		this.nbr_appointement_canceled_by_agents = nbr_appointement_canceled_by_agents;
		this.percent_appointement_canceled_by_clients = percent_appointement_canceled_by_clients;
		this.percent_appointement_canceled_by_agents = percent_appointement_canceled_by_agents;
		this.nbr_appointement_confirmed = nbr_appointement_confirmed;
		this.percent_appointement_confirmed = percent_appointement_confirmed;
		this.nbr_appointement_confirmed_by_clients = nbr_appointement_confirmed_by_clients;
		this.nbr_appointement_confirmed_by_agents = nbr_appointement_confirmed_by_agents;
		this.percent_appointement_confirmed_by_clients = percent_appointement_confirmed_by_clients;
		this.percent_appointement_confirmed_by_agents = percent_appointement_confirmed_by_agents;
		this.nbr_appointement_reported = nbr_appointement_reported;
		this.percent_appointement_reported = percent_appointement_reported;
		this.nbr_appointement_reported_by_clients = nbr_appointement_reported_by_clients;
		this.nbr_appointement_reported_by_agents = nbr_appointement_reported_by_agents;
		this.percent_appointement_reported_by_clients = percent_appointement_reported_by_clients;
		this.percent_appointement_reported_by_agents = percent_appointement_reported_by_agents;
		this.nbr_all_appoi = nbr_all_appoi;
		this.nbr_appointement_waiting_clients = nbr_appointement_waiting_clients;
		this.nbr_appointement_waiting_agents = nbr_appointement_waiting_agents;
	}

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

	public int getNbr_appoi_locale_one() {
		return nbr_appoi_locale_one;
	}

	public void setNbr_appoi_locale_one(int nbr_appoi_locale_one) {
		this.nbr_appoi_locale_one = nbr_appoi_locale_one;
	}

	public int getNbr_appoi_locale_two() {
		return nbr_appoi_locale_two;
	}

	public void setNbr_appoi_locale_two(int nbr_appoi_locale_two) {
		this.nbr_appoi_locale_two = nbr_appoi_locale_two;
	}

	public int getNbr_appoi_locale_three() {
		return nbr_appoi_locale_three;
	}

	public void setNbr_appoi_locale_three(int nbr_appoi_locale_three) {
		this.nbr_appoi_locale_three = nbr_appoi_locale_three;
	}

	public int getNbr_appoi_locale_four() {
		return nbr_appoi_locale_four;
	}

	public void setNbr_appoi_locale_four(int nbr_appoi_locale_four) {
		this.nbr_appoi_locale_four = nbr_appoi_locale_four;
	}

	public int getNbr_appoi_locale_five() {
		return nbr_appoi_locale_five;
	}

	public void setNbr_appoi_locale_five(int nbr_appoi_locale_five) {
		this.nbr_appoi_locale_five = nbr_appoi_locale_five;
	}

	public double getPercent_appoi_locale_one() {
		return percent_appoi_locale_one;
	}

	public void setPercent_appoi_locale_one(double percent_appoi_locale_one) {
		this.percent_appoi_locale_one = percent_appoi_locale_one;
	}

	public double getPercent_appoi_locale_two() {
		return percent_appoi_locale_two;
	}

	public void setPercent_appoi_locale_two(double percent_appoi_locale_two) {
		this.percent_appoi_locale_two = percent_appoi_locale_two;
	}

	public double getPercent_appoi_locale_three() {
		return percent_appoi_locale_three;
	}

	public void setPercent_appoi_locale_three(double percent_appoi_locale_three) {
		this.percent_appoi_locale_three = percent_appoi_locale_three;
	}

	public double getPercent_appoi_locale_four() {
		return percent_appoi_locale_four;
	}

	public void setPercent_appoi_locale_four(double percent_appoi_locale_four) {
		this.percent_appoi_locale_four = percent_appoi_locale_four;
	}

	public double getPercent_appoi_locale_five() {
		return percent_appoi_locale_five;
	}

	public void setPercent_appoi_locale_five(double percent_appoi_locale_five) {
		this.percent_appoi_locale_five = percent_appoi_locale_five;
	}

	public int getNbr_appoi_F1() {
		return nbr_appoi_F1;
	}

	public void setNbr_appoi_F1(int nbr_appoi_F1) {
		this.nbr_appoi_F1 = nbr_appoi_F1;
	}

	public int getNbr_appoi_F2() {
		return nbr_appoi_F2;
	}

	public void setNbr_appoi_F2(int nbr_appoi_F2) {
		this.nbr_appoi_F2 = nbr_appoi_F2;
	}

	public int getNbr_appoi_F3() {
		return nbr_appoi_F3;
	}

	public void setNbr_appoi_F3(int nbr_appoi_F3) {
		this.nbr_appoi_F3 = nbr_appoi_F3;
	}

	public int getNbr_appoi_F4() {
		return nbr_appoi_F4;
	}

	public void setNbr_appoi_F4(int nbr_appoi_F4) {
		this.nbr_appoi_F4 = nbr_appoi_F4;
	}

	public int getNbr_appoi_F5() {
		return nbr_appoi_F5;
	}

	public void setNbr_appoi_F5(int nbr_appoi_F5) {
		this.nbr_appoi_F5 = nbr_appoi_F5;
	}

	public double getPercent_appoi_F1() {
		return percent_appoi_F1;
	}

	public void setPercent_appoi_F1(double percent_appoi_F1) {
		this.percent_appoi_F1 = percent_appoi_F1;
	}

	public double getPercent_appoi_F2() {
		return percent_appoi_F2;
	}

	public void setPercent_appoi_F2(double percent_appoi_F2) {
		this.percent_appoi_F2 = percent_appoi_F2;
	}

	public double getPercent_appoi_F3() {
		return percent_appoi_F3;
	}

	public void setPercent_appoi_F3(double percent_appoi_F3) {
		this.percent_appoi_F3 = percent_appoi_F3;
	}

	public double getPercent_appoi_F4() {
		return percent_appoi_F4;
	}

	public void setPercent_appoi_F4(double percent_appoi_F4) {
		this.percent_appoi_F4 = percent_appoi_F4;
	}

	public double getPercent_appoi_F5() {
		return percent_appoi_F5;
	}

	public void setPercent_appoi_F5(double percent_appoi_F5) {
		this.percent_appoi_F5 = percent_appoi_F5;
	}

	public int getNbr_appointement_canceled() {
		return nbr_appointement_canceled;
	}

	public void setNbr_appointement_canceled(int nbr_appointement_canceled) {
		this.nbr_appointement_canceled = nbr_appointement_canceled;
	}

	public int getNbr_appointement_canceled_by_clients() {
		return nbr_appointement_canceled_by_clients;
	}

	public void setNbr_appointement_canceled_by_clients(int nbr_appointement_canceled_by_clients) {
		this.nbr_appointement_canceled_by_clients = nbr_appointement_canceled_by_clients;
	}

	public int getNbr_appointement_canceled_by_agents() {
		return nbr_appointement_canceled_by_agents;
	}

	public void setNbr_appointement_canceled_by_agents(int nbr_appointement_canceled_by_agents) {
		this.nbr_appointement_canceled_by_agents = nbr_appointement_canceled_by_agents;
	}

	public double getPercent_appointement_canceled_by_clients() {
		return percent_appointement_canceled_by_clients;
	}

	public void setPercent_appointement_canceled_by_clients(double percent_appointement_canceled_by_clients) {
		this.percent_appointement_canceled_by_clients = percent_appointement_canceled_by_clients;
	}

	public double getPercent_appointement_canceled_by_agents() {
		return percent_appointement_canceled_by_agents;
	}

	public void setPercent_appointement_canceled_by_agents(double percent_appointement_canceled_by_agents) {
		this.percent_appointement_canceled_by_agents = percent_appointement_canceled_by_agents;
	}

	public int getNbr_appointement_confirmed() {
		return nbr_appointement_confirmed;
	}

	public void setNbr_appointement_confirmed(int nbr_appointement_confirmed) {
		this.nbr_appointement_confirmed = nbr_appointement_confirmed;
	}

	public double getPercent_appointement_confirmed() {
		return percent_appointement_confirmed;
	}

	public void setPercent_appointement_confirmed(double percent_appointement_confirmed) {
		this.percent_appointement_confirmed = percent_appointement_confirmed;
	}

	public int getNbr_appointement_confirmed_by_clients() {
		return nbr_appointement_confirmed_by_clients;
	}

	public void setNbr_appointement_confirmed_by_clients(int nbr_appointement_confirmed_by_clients) {
		this.nbr_appointement_confirmed_by_clients = nbr_appointement_confirmed_by_clients;
	}

	public int getNbr_appointement_confirmed_by_agents() {
		return nbr_appointement_confirmed_by_agents;
	}

	public void setNbr_appointement_confirmed_by_agents(int nbr_appointement_confirmed_by_agents) {
		this.nbr_appointement_confirmed_by_agents = nbr_appointement_confirmed_by_agents;
	}

	public double getPercent_appointement_confirmed_by_clients() {
		return percent_appointement_confirmed_by_clients;
	}

	public void setPercent_appointement_confirmed_by_clients(double percent_appointement_confirmed_by_clients) {
		this.percent_appointement_confirmed_by_clients = percent_appointement_confirmed_by_clients;
	}

	public double getPercent_appointement_confirmed_by_agents() {
		return percent_appointement_confirmed_by_agents;
	}

	public void setPercent_appointement_confirmed_by_agents(double percent_appointement_confirmed_by_agents) {
		this.percent_appointement_confirmed_by_agents = percent_appointement_confirmed_by_agents;
	}

	public int getNbr_appointement_reported() {
		return nbr_appointement_reported;
	}

	public void setNbr_appointement_reported(int nbr_appointement_reported) {
		this.nbr_appointement_reported = nbr_appointement_reported;
	}

	public double getPercent_appointement_reported() {
		return percent_appointement_reported;
	}

	public void setPercent_appointement_reported(double percent_appointement_reported) {
		this.percent_appointement_reported = percent_appointement_reported;
	}

	public int getNbr_appointement_reported_by_clients() {
		return nbr_appointement_reported_by_clients;
	}

	public void setNbr_appointement_reported_by_clients(int nbr_appointement_reported_by_clients) {
		this.nbr_appointement_reported_by_clients = nbr_appointement_reported_by_clients;
	}

	public int getNbr_appointement_reported_by_agents() {
		return nbr_appointement_reported_by_agents;
	}

	public void setNbr_appointement_reported_by_agents(int nbr_appointement_reported_by_agents) {
		this.nbr_appointement_reported_by_agents = nbr_appointement_reported_by_agents;
	}

	public double getPercent_appointement_reported_by_clients() {
		return percent_appointement_reported_by_clients;
	}

	public void setPercent_appointement_reported_by_clients(double percent_appointement_reported_by_clients) {
		this.percent_appointement_reported_by_clients = percent_appointement_reported_by_clients;
	}

	public double getPercent_appointement_reported_by_agents() {
		return percent_appointement_reported_by_agents;
	}

	public void setPercent_appointement_reported_by_agents(double percent_appointement_reported_by_agents) {
		this.percent_appointement_reported_by_agents = percent_appointement_reported_by_agents;
	}

	public double getPercent_appointement_canceled() {
		return percent_appointement_canceled;
	}

	public void setPercent_appointement_canceled(double percent_appointement_canceled) {
		this.percent_appointement_canceled = percent_appointement_canceled;
	}

	public int getNbr_all_appoi() {
		return nbr_all_appoi;
	}

	public void setNbr_all_appoi(int nbr_all_appoi) {
		this.nbr_all_appoi = nbr_all_appoi;
	}

	public int getNbr_appointement_waiting_clients() {
		return nbr_appointement_waiting_clients;
	}

	public void setNbr_appointement_waiting_clients(int nbr_appointement_waiting_clients) {
		this.nbr_appointement_waiting_clients = nbr_appointement_waiting_clients;
	}

	public int getNbr_appointement_waiting_agents() {
		return nbr_appointement_waiting_agents;
	}

	public void setNbr_appointement_waiting_agents(int nbr_appointement_waiting_agents) {
		this.nbr_appointement_waiting_agents = nbr_appointement_waiting_agents;
	}
		
	
}
