package com.realestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Agent;
import com.realestate.repositories.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
	private AgentRepository agentRepository; 
	
	public boolean agent_subscribe(Agent agent) {
		if(agentRepository.agent_subscribe(agent.getId(), 
										   agent.getEmail(), 
										   agent.getGender(), 
										   agent.getBirthdate(), 
										   agent.getBlocked(), 
										   agent.getName(), 
										   agent.getPassword(), 
										   agent.getLast_name(), 
										   agent.getProfile_pic(), 
										   agent.getPhone(), 
										   agent.getUsername(), 
										   agent.getCv(), 
										   agent.getLocale(),
										   agent.getConfirm_key())==1)
			return true;
		else
			return false;
	}

	public boolean agent_email_exists(String email) {
		if(agentRepository.get_agent_by_email(email) != null)
			return true;
		else
			return false;
	}

	public Agent get_agent_by_email_and_password(String email, String password) {
		return (Agent)agentRepository.get_agent_by_email_and_password(email, password);
	}

	public List<Agent> get_agents_by_locale(int locale) {
		return agentRepository.get_agents_by_locale(locale);
	}

	public Agent get_agent_by_id(int id_agent) {
		return agentRepository.get_agent_by_id(id_agent);
	}

	public Agent get_agent_by_appointement_id(int id_appointement) {
		return agentRepository.get_agent_by_appointement_id(id_appointement);
	}

}
