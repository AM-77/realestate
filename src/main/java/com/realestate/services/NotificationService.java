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

}
