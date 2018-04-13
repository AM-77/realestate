package com.realestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Lodgement;
import com.realestate.repositories.LodgementRepository;

@Service
public class LodgementService {
	
	@Autowired
	private LodgementRepository lodgementRepository; 

	public List<Lodgement> get_lodgements_by_address_price_surface_type_and_floor(String address, 
																			 double min_price,
																			 double max_price, 
																			 double min_surface, 
																			 double max_surface, 
																			 int min_floor, 
																			 int max_floor,
																			 String type) {
		
		return lodgementRepository.get_lodgements_by_address_price_surface_type_and_floor( address, 
																					  min_price,
																					  max_price, 
																					  min_surface, 
																					  max_surface, 
																					  min_floor, 
																					  max_floor,
																					  type);
	}

	public List<Lodgement> get_lodgements_by_address_price_surface_and_floor(String address, 
																		double min_price,
																		double max_price, 
																		double min_surface, 
																		double max_surface,
																		int min_floor, 
																		int max_floor) {
		
		return lodgementRepository.get_lodgements_by_address_price_surface_and_floor( address, 
																				 min_price,
																				 max_price, 
																				 min_surface, 
																				 max_surface,
																				 min_floor, 
																				 max_floor);
	}

	public List<Lodgement> get_lodgements_by_price_surface_type_and_floor(double min_price, 
																	 double max_price,
																	 double min_surface, 
																	 double max_surface, 
																	 int min_floor, 
																	 int max_floor, 
																	 String type) {

		return lodgementRepository.get_lodgements_by_price_surface_type_and_floor( min_price, 
																			  max_price,
																			  min_surface, 
																			  max_surface,
																			  min_floor, 
																			  max_floor,
																			  type);
	}

	public List<Lodgement> get_lodgements_by_price_surface_and_floor(double min_price, 
																double max_price, 
																double min_surface,
																double max_surface,
																int min_floor,
																int max_floor) {
		
		return lodgementRepository.get_lodgements_by_price_surface_and_floor( min_price, 
																		 max_price, 
																		 min_surface,
																		 max_surface,
																		 min_floor,
																		 max_floor);
	}

	public Lodgement get_lodgements_by_id(int lodgement_id) {
		
		return lodgementRepository.get_lodgements_by_id(lodgement_id);
	}

	public Lodgement get_lodgement_by_appointement_all_id(int id_appointement) {
		return lodgementRepository.get_lodgement_by_appointement_all_id(id_appointement);
	}
	
	public Lodgement get_lodgement_by_appointement_id(int id_appointement) {
		return lodgementRepository.get_lodgement_by_appointement_id(id_appointement);
	}


	
	public List<Lodgement> get_lodgements_by_address_price_surface_and_type_and_floor(String address, 
			 double min_price,
			 double max_price, 
			 double min_surface, 
			 double max_surface, 
			 String type, int floor) {

	return lodgementRepository.get_lodgements_by_address_price_surface_and_type_and_floor( address, 
						  min_price,
						  max_price, 
						  min_surface, 
						  max_surface, 
						  type, floor);
	}
	
	public List<Lodgement> get_lodgements_by_address_price_and_surface_and_floor(String address, 
			double min_price,
			double max_price, 
			double min_surface, 
			double max_surface,int floor) {
	
		return lodgementRepository.get_lodgements_by_address_price_and_surface_and_floor( address, 
					 min_price,
					 max_price, 
					 min_surface, 
					 max_surface, floor);
	}
	
	public List<Lodgement> get_lodgements_by_price_surface_and_type_and_floor(double min_price, 
		 double max_price,
		 double min_surface, 
		 double max_surface, 
		 String type, int floor) {
	
		return lodgementRepository.get_lodgements_by_price_surface_and_type_and_floor( min_price, 
				  max_price,
				  min_surface, 
				  max_surface, 
				  type, floor);
	}
	
	public List<Lodgement> get_lodgements_by_price_and_surface_and_floor(double min_price, 
		double max_price, 
		double min_surface,
		double max_surface, int floor) {
		
		return lodgementRepository.get_lodgements_by_price_and_surface_and_floor( min_price, 
			 max_price, 
			 min_surface,
			 max_surface, floor);
	}
		
}
