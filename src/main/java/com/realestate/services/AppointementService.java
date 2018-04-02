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

	public int add(Date date, int first_half, int second_half, int id_lodgement, int id_agent, int id_client) {
		return appointementRepository.add(date, first_half, second_half, id_lodgement, id_agent, id_client);
	}
	
	
	public List<Appointement> get_Appointements_by_id_lodgement(int id_lodgement){
		return appointementRepository.get_Appointements_by_id_lodgement(id_lodgement);
	}

	public List<Appointement> get_Appointements_by_id_client(int id) {
		return appointementRepository.get_Appointements_by_id_client(id);
	}

	public boolean is_avail_lodgement_by_id_date_first_half(Date date, int id_lodg) {
		
		if(appointementRepository.is_avail_lodgement_by_id_date_first_half(date, id_lodg) == null)
			return true;
		else
			return false;
	}
	
	public boolean is_avail_lodgement_by_id_date_second_half(Date date, int id_lodg) {
		
		if(appointementRepository.is_avail_lodgement_by_id_date_second_half(date, id_lodg) == null)
			return true;
		else
			return false;
	}

	public boolean existe_appoi_by_id_client(int id, int id_appoi) {
		if(appointementRepository.existe_appoi_by_id_client(id, id_appoi) == null)
			return false;
		else
			return true;
	}

	public Appointement get_appointements_by_id(int id_appointement) {
		return appointementRepository.get_appointements_by_id(id_appointement);
	}

	public boolean client_confirm_appointement(int id_appointement) {
	
		if(appointementRepository.client_confirm_appointement( id_appointement) == 1){
			return true;
		}else {
			return false;
		}
	
	}

	public boolean client_cancel_appointement(int id_appointement) {
		if(appointementRepository.client_cancel_appointement( id_appointement) == 1){
			return true;
		}else {
			return false;
		}
	}

	public int get_canceled_value(int id_appointement) {
		return appointementRepository.get_canceled_value(id_appointement);
	}

	public List<Appointement> get_Appointements_by_id_agent(int id_agent) {
		return appointementRepository. get_Appointements_by_id_agent(id_agent);
	}

	public boolean agent_cancel_appointement(int id_appointement) {
		if(appointementRepository.agent_cancel_appointement(id_appointement) == 1){
			return true;
		}else {
			return false;
		}
	}

	public boolean agent_confirm_appointement(int id_appointement) {
		if(appointementRepository.agent_confirm_appointement(id_appointement) == 1){
			return true;
		}else {
			return false;
		}
	}

	public boolean save_review(int id_appointement, String review) {
		if(appointementRepository.save_review(id_appointement, review) == 1){
			return true;
		}else {
			return false;
		}
	}

	public boolean change_review(int id_appointement, String review) {
		if(appointementRepository.change_review(id_appointement, review) == 1){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean existe_appoi_by_id_agent(int id, int id_appoi) {
		if(appointementRepository.existe_appoi_by_id_agent(id, id_appoi) == null)
			return false;
		else
			return true;
	}

	public void sold_cancel_appointement(int id) {
		appointementRepository.sold_cancel_appointement(id);
	}
	
	public int nbr_all_appoi() {
		return appointementRepository.nbr_all_appoi();
	}

	public int nbr_appoi_by_locale(int locale) {
		return appointementRepository.nbr_appoi_by_locale(locale);
	}

	public int nbr_appoi_by_type(String type) {
		return appointementRepository.nbr_appoi_by_type(type);
	}
	
	public int nbr_appoi_by_floor(int floor) {
		return appointementRepository.nbr_appoi_by_floor(floor);
	}
	
	public int nbr_appoi_by_address(String address) {
		return appointementRepository.nbr_appoi_by_address(address);
	}

	public int nbr_appointement_canceled() {
		return appointementRepository.nbr_appointement_canceled();
	}

	public int nbr_appointement_canceled(String user) {
		return appointementRepository.nbr_appointement_canceled(user);
	}

	public int nbr_appointement_confirmed() {
		return appointementRepository.nbr_appointement_confirmed();
	}

	public int nbr_appointement_confirmed(String user) {
		if(user.equals("client"))
			return appointementRepository.nbr_appointement_confirmed_client();
		else
			return appointementRepository.nbr_appointement_confirmed_agent();
	}

	public int nbr_appointement_waiting(String user) {
		if(user.equals("client"))
			return appointementRepository.nbr_appointement_waiting_client();
		else
			return appointementRepository.nbr_appointement_waiting_agent();
	}

}
