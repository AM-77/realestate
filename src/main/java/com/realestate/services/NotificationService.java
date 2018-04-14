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
import com.realestate.models.Notification;
import com.realestate.models.Notification_details;
import com.realestate.repositories.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository; 
	@Autowired
	private LodgementService lodgementService; 
	@Autowired
	private ClientService clientService;
	@Autowired
	private AppointementService appointementService;
	@Autowired
	private AgentService agentService;
	
	public boolean add_notification(int id_appointement, String client_notif, String agent_notif) {
		
		if(notificationRepository.add_notification(id_appointement, client_notif, agent_notif) == 1)
			return true;
		else
			return false;
	}

	public boolean add_client_confirm_notification(int id_appointement, String client_notif, String agent_notif) {
		if(notificationRepository.add_client_confirm_notification( id_appointement, client_notif, agent_notif) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean add_client_cancel_notification(int id_appointement, String client_notif, String agent_notif) {
		if(notificationRepository.add_client_cancel_notification( id_appointement, client_notif, agent_notif) == 1) {
			return true;
		}else {
			return false;
		}
	}


	public boolean add_agent_cancel_notification(int id_appointement, String client_notif, String agent_notif) {
		if(notificationRepository.add_agent_cancel_notification( id_appointement, client_notif, agent_notif) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean add_agent_confirm_notification(int id_appointement, String client_notif, String agent_notif) {
		if(notificationRepository.add_agent_confirm_notification( id_appointement, client_notif, agent_notif) == 1) {
			return true;
		}else {
			return false;
		}
	}
	public List<Notification> get_notifications_by_agent_id(int id_agent) {
		return notificationRepository.get_notifications_by_agent_id(id_agent);
	}
	
	public List<Notification> get_notifications_by_client_id(int id_client) {
		return notificationRepository.get_notifications_by_client_id(id_client);
	}

	public void set_viewed_notifications_for_agent(int id_agent) {
		notificationRepository.set_viewed_notifications_for_agent(id_agent);
	}
	
	public void set_viewed_notifications_for_client(int id_client) {
		notificationRepository.set_viewed_notifications_for_client(id_client);
	}
	
	public void add_sold_notification(int id, String client_notif, String agent_notif) {
		notificationRepository.add_sold_notification( id, client_notif, agent_notif);
	}	
	
	public List<Notification_details> get_notifications(HttpSession session) throws ParseException{
		
		List<Notification_details> list_notification_details = new ArrayList<Notification_details>();
		
		if(session.getAttribute("client") != null) {
			
			List<Notification> notifs = get_notifications_by_client_id(((Client)session.getAttribute("client")).getId());
			
			Lodgement lodgement; 
			Client client; 
			Agent agent;
			Appointement appointement;
			
			for(Notification notif : notifs) {
							
				if(notif.getClient_notif().equals("no_notif"))
					continue;
				
				lodgement = lodgementService.get_lodgement_by_appointement_all_id(notif.getId_appointement());
				client = clientService.get_client_by_appointement_id(notif.getId_appointement());
				agent = agentService.get_agent_by_appointement_id(notif.getId_appointement());
				appointement = appointementService.get_appointements_by_id(notif.getId_appointement());
				
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
				

				list_notification_details.add(new Notification_details( notif.getId(), 
																		 notif.getClient_notif(), 
																	     notif.getTime(), 
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
																	     agent.getUsername(),(notif.getV_client() == 1)));
				
			}				
				
		}else {
			
			if(session.getAttribute("agent") != null) {
				
				System.out.println(((Agent)session.getAttribute("agent")).getId());
				
				List<Notification> notifs = get_notifications_by_agent_id(((Agent)session.getAttribute("agent")).getId());
				
				Lodgement lodgement; 
				Client client; 
				Agent agent;
				Appointement appointement;
				
				for(Notification notif : notifs) {
								
					if(notif.getAgent_notif().equals("no_notif"))
						continue;
					
					lodgement = lodgementService.get_lodgement_by_appointement_all_id(notif.getId_appointement());
					client = clientService.get_client_by_appointement_id(notif.getId_appointement());
					agent = agentService.get_agent_by_appointement_id(notif.getId_appointement());
					appointement = appointementService.get_appointements_by_id(notif.getId_appointement());
					
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
					

					list_notification_details.add(new Notification_details( notif.getId(), 
																			 notif.getClient_notif(), 
																		     notif.getTime(), 
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
																		     agent.getUsername(),
																		     (notif.getV_client() == 1)));
					
				}				
					
			}
			
		}
							
		return list_notification_details;
		
	}

}
