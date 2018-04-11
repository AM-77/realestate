package com.realestate.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Agent;
import com.realestate.models.Appointement;
import com.realestate.models.Client;
import com.realestate.models.Lodgement;
import com.realestate.models.Notification_details;
import com.realestate.models.Operator;
import com.realestate.models.Reports;
import com.realestate.repositories.ReportsRepository;

@Service
public class ReportsService {

	@Autowired
	private ReportsRepository reportsRepository;
	@Autowired
	private LodgementService lodgementService; 
	@Autowired
	private ClientService clientService;
	@Autowired
	private AppointementService appointementService;
	@Autowired
	private AgentService agentService;

	public boolean add_report(String reporter, int id_appoi, String report) {
		if(reportsRepository.add_report( reporter, id_appoi, report) == 1)
			return true;
		else
			return false;
	}

	public List<Reports> get_reports_by_locale(int locale) {
		return reportsRepository.get_reports_by_locale(locale);
	}

	public void set_viewed_reports(int id_operator) {
		reportsRepository.set_viewed_reports(id_operator);
	} 
	
	public int nbr_appointement_reported() {
		return reportsRepository.nbr_appointement_reported();
	}
	
	public int nbr_appointement_reported(String user) {
		return reportsRepository.nbr_appointement_reported(user);
	}
	
	public List<Notification_details> get_reports(HttpSession session) throws ParseException{
		
		List<Notification_details> list_notification_details = new ArrayList<Notification_details>();
		
			
					if(session.getAttribute("operator") != null) {
						
						List<Reports> reports = get_reports_by_locale(Integer.parseInt(((Operator)session.getAttribute("operator")).getLocale()));
						
						for(Reports r : reports) {
							
							Appointement appointement = appointementService.get_appointements_by_id(r.getId_appointement());
							Lodgement lodgement = lodgementService.get_lodgement_by_appointement_id(appointement.getId()); 
							Client client = clientService.get_client_by_appointement_id(appointement.getId()); 
							Agent agent = agentService.get_agent_by_appointement_id(appointement.getId());
							
							String appointement_time, agent_confirm = "Not confirmed", client_confirm = "Not confirmed";
							
							if(appointement.getFirst_half() == 1) {
								appointement_time = "Morning";
							}else {
								appointement_time = "Evening";
							}
							
							if(appointement.getAgent_confirm() == 1) {
								agent_confirm = "Confirmed";
							}
							
							if(appointement.getClient_confirm() == 1) {
								client_confirm = "Confirmed";
							}
			

							list_notification_details.add(new Notification_details( r.getId(), 
									 r.getReport(), 
								     r.getTime(), 
								     appointement.getDate(), 
								     appointement_time, 
								     agent_confirm, 
								     client_confirm, 
								     client.getId(), 
								     client.getUsername(), 
								     lodgement.getId(), 
								     lodgement.getType(), 
								     lodgement.getAddress(), 
								     agent.getId(), 
								     agent.getUsername(),(r.getV_operator() == 1)));

							session.setAttribute("reporter", r.getRepoter());
							
						}
										
					}
				
					
			
							
			return list_notification_details;
			
		}
	
}
