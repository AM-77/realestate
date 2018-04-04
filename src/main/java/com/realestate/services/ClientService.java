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
	
	

}
