package com.realestate.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.models.Statistcs_details;
import com.realestate.services.AgentService;
import com.realestate.services.AppointementService;
import com.realestate.services.ClientService;
import com.realestate.services.OperatorService;
import com.realestate.services.ReportsService;
import com.realestate.services.StatistcsService;

@RestController
public class AdminController {
	
	@Autowired
	public StatistcsService statistcsService;
	@Autowired
	public AppointementService appointementService;
	@Autowired
	public ReportsService reportsService;
	@Autowired
	public ClientService clientService;
	@Autowired
	public AgentService agentService;
	@Autowired
	public OperatorService operatorService;
	
	@GetMapping("statistcs")
	public Statistcs_details post_statistics(HttpSession session) {

		int nbr_all_website_visites = statistcsService.get_nbr_all_website_visites(); 
		int nbr_client_website_visites = statistcsService.nbr_client_website_visites();
		int nbr_agent_website_visites = statistcsService.nbr_agent_website_visites();
		int nbr_operator_website_visites = statistcsService.nbr_operator_website_visites();
		double percent_client_website_visites = 0;
		double percent_agent_website_visites = 0;
		double percent_operator_website_visites =0;
		
		if(nbr_all_website_visites != 0) {
			percent_client_website_visites = round(((double)nbr_client_website_visites/nbr_all_website_visites)*100, 2);
			percent_agent_website_visites = round(((double)nbr_agent_website_visites/nbr_all_website_visites)*100, 2);
			percent_operator_website_visites = round(((double)nbr_operator_website_visites/nbr_all_website_visites)*100, 2);
		}

		Map<String, Integer> nbr_all_visites_website_by_clients_mounths = statistcsService.nbr_all_visites_website_by_visitor_mounths("client");
		Map<String, Double> percent_all_visites_website_by_clients_mounths = statistcsService.percent_all_visites_website_by_visitor_mounths("client");
		Map<String, Integer> nbr_all_visites_website_by_agents_mounths = statistcsService.nbr_all_visites_website_by_visitor_mounths("agent");
		Map<String, Double> percent_all_visites_website_by_agents_mounths = statistcsService.percent_all_visites_website_by_visitor_mounths("agent");
		Map<String, Integer> nbr_all_visites_website_by_operators_mounths = statistcsService.nbr_all_visites_website_by_visitor_mounths("operator");
		Map<String, Double> percent_all_visites_website_by_operators_mounths = statistcsService.percent_all_visites_website_by_visitor_mounths("operator");
		
		int nbr_all_appoi = appointementService.nbr_all_appoi();
		int nbr_appoi_locale_one = appointementService.nbr_appoi_by_locale(1);
		int nbr_appoi_locale_two = appointementService.nbr_appoi_by_locale(2);
		int nbr_appoi_locale_three = appointementService.nbr_appoi_by_locale(3);
		int nbr_appoi_locale_four = appointementService.nbr_appoi_by_locale(4);
		int nbr_appoi_locale_five = appointementService.nbr_appoi_by_locale(5);
		double percent_appoi_locale_one = 0;
		double percent_appoi_locale_two = 0;
		double percent_appoi_locale_three = 0;
		double percent_appoi_locale_four = 0;
		double percent_appoi_locale_five = 0;
		if(nbr_all_appoi != 0) {
			percent_appoi_locale_one = round(((double)nbr_appoi_locale_one/nbr_all_appoi)*100, 2);
			percent_appoi_locale_two = round(((double)nbr_appoi_locale_two/nbr_all_appoi)*100, 2);
			percent_appoi_locale_three = round(((double)nbr_appoi_locale_three/nbr_all_appoi)*100, 2);
			percent_appoi_locale_four = round(((double)nbr_appoi_locale_four/nbr_all_appoi)*100, 2);
			percent_appoi_locale_five = round(((double)nbr_appoi_locale_five/nbr_all_appoi)*100, 2);
		}
		
		int nbr_appoi_F1 = appointementService.nbr_appoi_by_type("F1");
		int nbr_appoi_F2 = appointementService.nbr_appoi_by_type("F2");
		int nbr_appoi_F3 = appointementService.nbr_appoi_by_type("F3");
		int nbr_appoi_F4 = appointementService.nbr_appoi_by_type("F4");
		int nbr_appoi_F5 = appointementService.nbr_appoi_by_type("F5");
		double percent_appoi_F1 = 0;
		double percent_appoi_F2 = 0;
		double percent_appoi_F3 = 0;
		double percent_appoi_F4 = 0;
		double percent_appoi_F5 = 0;
		if(nbr_all_appoi != 0) {
			percent_appoi_F1 = round(((double)nbr_appoi_locale_one/nbr_all_appoi)*100, 2);
			percent_appoi_F2 = round(((double)nbr_appoi_locale_one/nbr_all_appoi)*100, 2);
			percent_appoi_F3 = round(((double)nbr_appoi_locale_one/nbr_all_appoi)*100, 2);
			percent_appoi_F4 = round(((double)nbr_appoi_locale_one/nbr_all_appoi)*100, 2);
			percent_appoi_F5 = round(((double)nbr_appoi_locale_one/nbr_all_appoi)*100, 2);
		}
		
		int nbr_appointement_canceled = appointementService.nbr_appointement_canceled();
		int nbr_appointement_canceled_by_clients = appointementService.nbr_appointement_canceled("client");
		int nbr_appointement_canceled_by_agents = appointementService.nbr_appointement_canceled("agent");
		double percent_appointement_canceled = 0;
		double percent_appointement_canceled_by_clients = 0;
		double percent_appointement_canceled_by_agents = 0;
		if(nbr_all_appoi != 0 && nbr_appointement_canceled != 0) {
			percent_appointement_canceled = round(((double)nbr_appointement_canceled/nbr_all_appoi)*100, 2);
			percent_appointement_canceled_by_clients = round(((double)nbr_appointement_canceled_by_clients/nbr_appointement_canceled)*100, 2);
			percent_appointement_canceled_by_agents = round(((double)nbr_appointement_canceled_by_agents/nbr_appointement_canceled)*100, 2);
		}
		
		int nbr_appointement_confirmed = appointementService.nbr_appointement_confirmed();
		int nbr_appointement_confirmed_by_clients = appointementService.nbr_appointement_confirmed("client");
		int nbr_appointement_confirmed_by_agents = appointementService.nbr_appointement_confirmed("agent");
		double percent_appointement_confirmed = 0;
		double percent_appointement_confirmed_by_clients = 0;
		double percent_appointement_confirmed_by_agents = 0;
		if(nbr_all_appoi != 0 && nbr_appointement_confirmed != 0) {
			percent_appointement_confirmed = round(((double)nbr_appointement_confirmed/nbr_all_appoi)*100, 2);
			percent_appointement_confirmed_by_clients = round(((double)nbr_appointement_confirmed_by_clients/nbr_appointement_confirmed)*100, 2);
			percent_appointement_confirmed_by_agents = round(((double)nbr_appointement_confirmed_by_agents/nbr_appointement_confirmed)*100, 2);
		}
		
		int nbr_appointement_reported = reportsService.nbr_appointement_reported();
		int nbr_appointement_reported_by_clients = reportsService.nbr_appointement_reported("client");
		int nbr_appointement_reported_by_agents = reportsService.nbr_appointement_reported("agent");
		double percent_appointement_reported = 0; 
		double percent_appointement_reported_by_clients = 0;
		double percent_appointement_reported_by_agents = 0;
		if(nbr_all_appoi != 0 && nbr_appointement_reported != 0) {
			percent_appointement_reported = round(((double)nbr_appointement_reported/nbr_all_appoi)*100, 2); 
			percent_appointement_reported_by_clients = round(((double)nbr_appointement_reported_by_clients/nbr_appointement_reported)*100, 2);
			percent_appointement_reported_by_agents = round(((double)nbr_appointement_reported_by_agents/nbr_appointement_reported)*100, 2);
		}
		
		int nbr_appointement_waiting_clients = appointementService.nbr_appointement_waiting("client");
		int nbr_appointement_waiting_agents = appointementService.nbr_appointement_waiting("agent");
		
		return new Statistcs_details(nbr_all_website_visites, nbr_client_website_visites, nbr_agent_website_visites, nbr_operator_website_visites, percent_client_website_visites, percent_agent_website_visites, percent_operator_website_visites, nbr_all_visites_website_by_clients_mounths, percent_all_visites_website_by_clients_mounths, nbr_all_visites_website_by_agents_mounths, percent_all_visites_website_by_agents_mounths, nbr_all_visites_website_by_operators_mounths, percent_all_visites_website_by_operators_mounths, nbr_appoi_locale_one, nbr_appoi_locale_two, nbr_appoi_locale_three, nbr_appoi_locale_four, nbr_appoi_locale_five, percent_appoi_locale_one, percent_appoi_locale_two, percent_appoi_locale_three, percent_appoi_locale_four, percent_appoi_locale_five, nbr_appoi_F1, nbr_appoi_F2, nbr_appoi_F3, nbr_appoi_F4, nbr_appoi_F5, percent_appoi_F1, percent_appoi_F2, percent_appoi_F3, percent_appoi_F4, percent_appoi_F5, nbr_appointement_canceled, percent_appointement_canceled, nbr_appointement_canceled_by_clients, nbr_appointement_canceled_by_agents, percent_appointement_canceled_by_clients, percent_appointement_canceled_by_agents, nbr_appointement_confirmed, percent_appointement_confirmed, nbr_appointement_confirmed_by_clients, nbr_appointement_confirmed_by_agents, percent_appointement_confirmed_by_clients, percent_appointement_confirmed_by_agents, nbr_appointement_reported, percent_appointement_reported, nbr_appointement_reported_by_clients, nbr_appointement_reported_by_agents, percent_appointement_reported_by_clients, percent_appointement_reported_by_agents, nbr_all_appoi, nbr_appointement_waiting_clients, nbr_appointement_waiting_agents);
	}
	
	
}
