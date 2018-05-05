package com.realestate.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.models.Agent;
import com.realestate.models.Client;
import com.realestate.models.Lodgement;
import com.realestate.models.Operator;
import com.realestate.services.AgentService;
import com.realestate.services.AppointementService;
import com.realestate.services.LodgementService;
import com.realestate.services.NotificationService;
import com.realestate.services.ReportsService;

@RestController
public class SearchController {
	
	@Autowired
	private LodgementService lodgementService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private AppointementService appointementService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private ReportsService reportService;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		
	@PostMapping("search")
	public List<Lodgement>post_search(@RequestParam(value="address", defaultValue="no_value")String address,
									   @RequestParam(value="max_price", defaultValue="1000000000")double max_price,
									   @RequestParam(value="min_price", defaultValue="0")double min_price,
									   @RequestParam(value="type_f1", defaultValue="no_value")String type_f1,
									   @RequestParam(value="type_f2", defaultValue="no_value")String type_f2,
									   @RequestParam(value="type_f3", defaultValue="no_value")String type_f3,
									   @RequestParam(value="type_f4", defaultValue="no_value")String type_f4,
									   @RequestParam(value="type_f5", defaultValue="no_value")String type_f5,									   
									   @RequestParam(value="min_floor", defaultValue="0")int min_floor,
									   @RequestParam(value="max_floor", defaultValue="1000")int max_floor,
									   @RequestParam(value="max_surface", defaultValue="10000")double max_surface,
									   @RequestParam(value="min_surface", defaultValue="0")double min_surface,
									   Model model) {
		List<Lodgement> lodgs = new ArrayList<Lodgement>();
		address = address.toLowerCase();
		if(address.equals("no_value") ) {
			
			if( type_f1.equals("no_value") && type_f2.equals("no_value") && type_f3.equals("no_value") && type_f4.equals("no_value") && type_f4.equals("no_value")) {
				lodgs.addAll(lodgementService.get_lodgements_by_price_surface_and_floor(min_price, max_price, min_surface, max_surface, min_floor, max_floor));
			}
			
			if(type_f1.equalsIgnoreCase("F1")) {
				lodgs.addAll(lodgementService.get_lodgements_by_price_surface_type_and_floor(min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F1"));
			}
			
			if(type_f2.equalsIgnoreCase("F2")) {
				lodgs.addAll(lodgementService.get_lodgements_by_price_surface_type_and_floor(min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F2"));
			}
			
			if(type_f3.equalsIgnoreCase("F3")) {
				lodgs.addAll(lodgementService.get_lodgements_by_price_surface_type_and_floor(min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F3"));
			}
			
			if(type_f4.equalsIgnoreCase("F4")) {
				lodgs.addAll(lodgementService.get_lodgements_by_price_surface_type_and_floor(min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F4"));
			}
			
			if(type_f5.equalsIgnoreCase("F5")) {
				lodgs.addAll(lodgementService.get_lodgements_by_price_surface_type_and_floor(min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F5"));
			}
			
		
		}else {
			
			if( type_f1.equals("no_value") && type_f2.equals("no_value") && type_f3.equals("no_value") && type_f4.equals("no_value") && type_f4.equals("no_value")) {
				lodgs.addAll(lodgementService.get_lodgements_by_address_price_surface_and_floor(address, min_price, max_price, min_surface, max_surface, min_floor, max_floor));
			}
			
			if(type_f1.equalsIgnoreCase("F1")) {
				lodgs.addAll(lodgementService.get_lodgements_by_address_price_surface_type_and_floor(address, min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F1"));
			}
			
			if(type_f2.equalsIgnoreCase("F2")) {
				lodgs.addAll(lodgementService.get_lodgements_by_address_price_surface_type_and_floor(address, min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F2"));
			}
			
			if(type_f3.equalsIgnoreCase("F3")) {
				lodgs.addAll(lodgementService.get_lodgements_by_address_price_surface_type_and_floor(address, min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F3"));
			}
			
			if(type_f4.equalsIgnoreCase("F4")) {
				lodgs.addAll(lodgementService.get_lodgements_by_address_price_surface_type_and_floor(address, min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F4"));
			}
			
			if(type_f5.equalsIgnoreCase("F5")) {
				lodgs.addAll(lodgementService.get_lodgements_by_address_price_surface_type_and_floor(address, min_price, max_price, min_surface, max_surface, min_floor, max_floor, "F5"));
			}
		}
				
		return lodgs;
	}
	
	
	@PostMapping("avail_agents")
	public List<Agent> post_avail_agents(@RequestParam(value="date")String date,
									      @RequestParam(value="time")String half, 
										  @RequestParam(value="id_lodg")int id_lodg) throws ParseException{
		
		List<Agent> avail_agents = new ArrayList<Agent>();
		
		
		
		for(Agent agent : agentService.get_agents_by_locale(lodgementService.get_lodgements_by_id(id_lodg).getLocale())) {
			
			if(agent.getBlocked() != 1)
				
				if( half.toLowerCase().equals("morning")) {
					if(appointementService.is_avail_lodgement_by_id_date_first_half(df.parse(date), id_lodg)) {
						
						if(appointementService.is_avail_agent_first_half(df.parse(date), agent.getId()))
							avail_agents.add(agent);
					}	
				}else 
					if(appointementService.is_avail_lodgement_by_id_date_second_half(df.parse(date), id_lodg))
						if (appointementService.is_avail_agent_second_half(df.parse(date), agent.getId())) {
							avail_agents.add(agent);
						}
						
			
		}
		
		
				
		return avail_agents;
	}
	
	@GetMapping("see_notifications")
	public void get_see_notifications(HttpSession session) {
		
		if(session.getAttribute("client") != null) {
			notificationService.set_viewed_notifications_for_client(((Client)session.getAttribute("client")).getId());
		}else {
			if(session.getAttribute("agent") != null) {
				notificationService.set_viewed_notifications_for_agent(((Agent)session.getAttribute("agent")).getId());
			}
		}
		
	}
	
	@GetMapping("see_reports")
	public void get_see_reports(HttpSession session) {
		
		if(session.getAttribute("operator") != null) {
			reportService.set_viewed_reports(((Operator)session.getAttribute("operator")).getId());
		}
		
	}
	
}
