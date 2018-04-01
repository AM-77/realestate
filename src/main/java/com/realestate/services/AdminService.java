package com.realestate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Admin;
import com.realestate.repositories.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository; 

	public boolean admin_subscribe(Admin admin) {
		if(adminRepository.admin_subscribe(admin.getId(), admin.getEmail(), admin.getPhone(), admin.getName(), 
				admin.getPassword(), admin.getLast_name(),admin.getProfile_pic())==1)
			return true;
		else
		return false;
	}

}
