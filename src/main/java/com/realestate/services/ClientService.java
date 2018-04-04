package com.realestate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Client;
import com.realestate.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository; 
	
	public boolean client_subscribe(Client client) {
		if(clientRepository.client_subscribe(client.getId(), 
											 client.getEmail(), 
											 client.getGender(), 
											 client.getBirthdate(), 
											 client.getBlocked(), 
											 client.getName(), 
											 client.getPassword(), 
											 client.getLast_name(), 
											 client.getProfile_pic(), 
											 client.getPhone(), 
											 client.getUsername(),
											 client.getConfirm_key())==1)
				return true;
		else
			return false;
	}
	
	public boolean client_finish_subscribe(Client client) {
		if(clientRepository.client_finish_subscribe(client.getEmail(), 
													client.getGender(), 
													client.getBirthdate(), 
													client.getBlocked(), 
													client.getName(), 
													client.getPassword(), 
													client.getLast_name(), 
													client.getProfile_pic(), 
													client.getPhone(), 
													client.getUsername())==1)
				return true;
		else
			return false;
	}
	

	public boolean client_email_exists(String email) {
		
		if(clientRepository.get_client_by_email(email) != null)
			return true;
		else
			return false;
	}
	
	public Client get_client_by_email_and_password(String email, String password) {
		return (Client)clientRepository.get_client_by_email_and_password(email, password);
	}


	public Client get_client_by_id(int id_client) {
		return (Client)clientRepository.get_client_by_id(id_client);
	}


	public Client get_client_by_appointement_id(int id_appointement) {
		return clientRepository. get_client_by_appointement_id(id_appointement);
	}


	public boolean remove_client_by_email(String email) {
		if(clientRepository.remove_client_by_email(email) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean block_client_by_email(String email) {
		if(clientRepository.block_client_by_email(email) == 1) {
			return true;
		}else {
			return false;
		}
	}


	public Client get_client_by_email(String email_client) {
		return clientRepository.get_client_by_email(email_client);
	}

}
