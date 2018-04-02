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
	
	

}
