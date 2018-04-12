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

	public boolean operator_email_exists(String email) {
		if(operatorRepository.get_operator_by_email(email) != null)
			return true;
		else
			return false;
	}

	public Operator get_operator_by_email_and_password(String email, String password) {
		return (Operator)operatorRepository.get_operator_by_email_and_password(email, password);
	}

	public Operator get_operator_by_id(int user_id) {
		return operatorRepository.get_operator_by_id(user_id);
	}

	public int nbr_account() {
		return operatorRepository.nbr_account();
	}

	public List<Operator> get_operator_subscribe_demand() {
		return operatorRepository.get_operator_subscribe_demand();
	}

	public boolean remove_an_op(int id) {
		if(operatorRepository.remove_an_op(id) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean confirm_an_op(int id) {
		if(operatorRepository.confirm_an_op(id) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean block_an_op(String email) {
		if(operatorRepository.block_an_op(email) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean remove_an_op(String email) {
		if(operatorRepository.remove_an_op(email) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean deblock_an_op(String email) {
		if(operatorRepository.deblock_an_op(email) == 1) {
			return true;
		}else {
			return false;
		}
	}

	public boolean get_operator_by_confirmation_key(String key) {
		if((Operator)operatorRepository.get_operator_by_confirmation_key(key) != null)
			return true;
		return false;
	}

	public boolean update_operator_profile(Operator operator) {
		if(operatorRepository.update_operator_profile(operator.getId(), operator.getUsername(), operator.getName(), operator.getLast_name(), operator.getEmail(), operator.getPhone(), operator.getBirthdate()) == 1) {
			return true;
		}else {
			return false;
		}
	}

}
