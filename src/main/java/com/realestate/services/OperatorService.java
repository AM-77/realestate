package com.realestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Operator;
import com.realestate.repositories.OperatorRepository;

@Service
public class OperatorService {
	
	@Autowired
	private OperatorRepository operatorRepository; 

	public boolean operator_subscribe(Operator operator) {
		if(operatorRepository.operator_subscribe(	operator.getId(), 
													operator.getEmail(), 
													operator.getGender(), 
													operator.getBirthdate(), 
													operator.getBlocked(), 
													operator.getName(), 
													operator.getPassword(), 
													operator.getLast_name(), 
													operator.getProfile_pic(), 
													operator.getPhone(), 
													operator.getUsername(), 
													operator.getCv(), 
													operator.getLocale(),
													operator.getConfirm_key())==1)
			
			return true;
		else
		return false;
	}



}
