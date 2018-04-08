package com.realestate.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Client;
import com.realestate.models.Lodgement;
import com.realestate.models.Wishlist;
import com.realestate.repositories.WishRepository;

@Service
public class WishService {
	
	@Autowired
	private WishRepository wishRepository; 
	@Autowired
	private LodgementService lodgementService;
	
	public List<Wishlist> get_all_wished_by_client(int id_client){
		return wishRepository.get_all_wished_by_client(id_client);
	}

	public boolean add_wish(int id_client, String address, String type, double max_surface, double min_surface, double max_price, double min_price, int max_floor, int min_floor) {
		if(wishRepository.add_wish( id_client, address, type, max_surface, min_surface, max_price, min_price, max_floor, min_floor) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean is_found_wish(int id) {
		if(wishRepository.is_found_wish(id) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean remove_wish(int id) {
		if(wishRepository.remove_wish(id) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void search_wish(HttpSession session) {
		
		if(session.getAttribute("client") != null) {
			
			List<Wishlist> wishes = wishRepository.get_all_wished_by_client(((Client)session.getAttribute("client")).getId());
						
			for(Wishlist wish: wishes) {
				
				Lodgement lodgement = lodgementService.search_wish(wish.getAddress(),
										   wish.getType(),
										   wish.getMax_surface(),
										   wish.getMin_surface(),
										   new Double(wish.getMax_price()).intValue(),
										   new Double(wish.getMin_price()).intValue(),
										   wish.getMax_floor(),
										   wish.getMin_floor());

				if(lodgement != null) {
					wishRepository.found_wish(wish.getId(), lodgement.getId());
				}
				
			}
			
		}
		
	}

}
