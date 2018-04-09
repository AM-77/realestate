package com.realestate.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.repositories.StatistcsRepository;

@Service
public class StatistcsService {
	
	@Autowired
	private StatistcsRepository statistcsRepository; 

	public boolean add_statistc(int id_reporter, String type_visitor) {
		if(statistcsRepository.add_statistc(id_reporter, type_visitor) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public int get_nbr_all_website_visites() {
		return statistcsRepository.get_nbr_all_website_visites();
	}

	public int nbr_client_website_visites() {
		return statistcsRepository.nbr_visite_by_type("client");
	}

	public int nbr_agent_website_visites() {
		return statistcsRepository.nbr_visite_by_type("agent");
	}

	public int nbr_operator_website_visites() {
		return statistcsRepository.nbr_visite_by_type("operator");
	}

	public int nbr_visites_locale_one() {
		return 0;
	}

	public Map<String, Integer> nbr_all_visites_website_by_visitor_mounths(String visitor) {
		HashMap<String, Integer> visites_website_by_visitors_mounths = new HashMap<String, Integer>();
      
		visites_website_by_visitors_mounths.put("January", statistcsRepository.visites_website_by_mounths(visitor, "2018-01-01", "2018-02-01"));
		visites_website_by_visitors_mounths.put("February", statistcsRepository.visites_website_by_mounths(visitor, "2018-02-01", "2018-03-01"));
		visites_website_by_visitors_mounths.put("March", statistcsRepository.visites_website_by_mounths(visitor, "2018-03-01", "2018-04-01"));
		visites_website_by_visitors_mounths.put("April", statistcsRepository.visites_website_by_mounths(visitor, "2018-04-01", "2018-05-01"));
		visites_website_by_visitors_mounths.put("May", statistcsRepository.visites_website_by_mounths(visitor, "2018-05-01", "2018-06-01"));
		visites_website_by_visitors_mounths.put("June", statistcsRepository.visites_website_by_mounths(visitor, "2018-06-01", "2018-07-01"));
		visites_website_by_visitors_mounths.put("July", statistcsRepository.visites_website_by_mounths(visitor, "2018-07-01", "2018-08-01"));
		visites_website_by_visitors_mounths.put("August", statistcsRepository.visites_website_by_mounths(visitor, "2018-08-01", "2018-09-01"));
		visites_website_by_visitors_mounths.put("September", statistcsRepository.visites_website_by_mounths(visitor, "2018-09-01", "2018-10-01"));
		visites_website_by_visitors_mounths.put("October", statistcsRepository.visites_website_by_mounths(visitor, "2018-10-01", "2018-11-01"));
		visites_website_by_visitors_mounths.put("November", statistcsRepository.visites_website_by_mounths(visitor, "2018-11-01", "2018-12-01"));
		visites_website_by_visitors_mounths.put("December", statistcsRepository.visites_website_by_mounths(visitor, "2018-12-01", "2019-01-01"));
		
		return visites_website_by_visitors_mounths;
	}
	
	
	public Map<String, Double> percent_all_visites_website_by_visitor_mounths(String visitor) {
		HashMap<String, Double> percent_all_visites_website_by_visitor_mounths = new HashMap<String, Double>();
		
		int nbr_all_visites = statistcsRepository.get_nbr_all_website_visites();
		
		percent_all_visites_website_by_visitor_mounths.put("January", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-01-01", "2018-02-01")/nbr_all_visites)*100, 2) );
		percent_all_visites_website_by_visitor_mounths.put("February", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-02-01", "2018-03-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("March", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-03-01", "2018-04-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("April", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-04-01", "2018-05-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("May", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-05-01", "2018-06-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("June", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-06-01", "2018-07-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("July", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-07-01", "2018-08-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("August", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-08-01", "2018-09-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("September", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-09-01", "2018-10-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("October", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-10-01", "2018-11-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("November", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-11-01", "2018-12-01")/nbr_all_visites)*100, 2));
		percent_all_visites_website_by_visitor_mounths.put("December", round((statistcsRepository.visites_website_by_mounths(visitor, "2018-12-01", "2019-01-01")/nbr_all_visites)*100, 2));
		
		return percent_all_visites_website_by_visitor_mounths;
	}

	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	

}
