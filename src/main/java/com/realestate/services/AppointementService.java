package com.realestate.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Appointement;
import com.realestate.repositories.AppointementRepository;

@Service
public class AppointementService {

	@Autowired
	private AppointementRepository appointementRepository;
	
	public boolean is_avail_date_first_half(Date date,int id_lodgement) {
		if (appointementRepository.is_avail_date_first_half(date, id_lodgement) == null) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public boolean is_avail_date_second_half(Date date, int id_lodgement) {
		
		if (appointementRepository.is_avail_date_second_half(date, id_lodgement) == null)
			return true;
		else {
			return false;
		} 
	}

	public boolean is_avail_agent_first_half(Date date, int id_agent) {
		
		if (appointementRepository.is_avail_agent_first_half(date, id_agent) == null)
			return true;
		else {
			return false;
		} 
	}

	public boolean is_avail_agent_second_half(Date date, int id_agent) {
		if (appointementRepository.is_avail_agent_second_half(date, id_agent) == null)
			return true;
		else {
			return false;
		} 
	}

	

}
