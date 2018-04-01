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

	public int nbr_account() {
		return agentRepository.nbr_account();
	}

	public List<Agent> get_agent_subscribe_demand() {
		return agentRepository.get_agent_subscribe_demand();
	}

	public boolean remove_an_agent(int id) {
		if(agentRepository.remove_an_agent(id) == 1)
			return true;
		else
			return false;
	}

	public boolean confirm_an_agent(int id) {
		if(agentRepository.confirm_an_agent(id) == 1)
			return true;
		else
			return false;
	}

	public boolean block_an_agent(String email) {
		if(agentRepository.block_an_agent(email) == 1)
			return true;
		else
			return false;
	}

	public boolean deblock_an_agent(String email) {
		if(agentRepository.deblock_an_agent(email) == 1)
			return true;
		else
			return false;
	}

	public boolean remove_an_agent(String email) {
		if(agentRepository.remove_an_agent(email) == 1)
			return true;
		else
			return false;
	}

	public boolean get_agent_by_confirmation_key(String key) {
		if((Agent)agentRepository.get_agent_by_confirmation_key(key) != null)
			return true;
		return false;
	}

	public boolean update_agent_profile(Agent agent) {
		if(agentRepository.update_agent_profile(agent.getId(), agent.getUsername(), agent.getName(), agent.getLast_name(), agent.getPhone(), agent.getBirthdate()) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
}
