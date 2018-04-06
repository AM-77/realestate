package com.realestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.models.Favorite;
import com.realestate.repositories.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository; 


	public boolean add_favorite(int id_lodgement, int id_client) {
		if(favoriteRepository.add_favorite(id_lodgement, id_client) == 1)
			return true;
		else
			return false;
	}
	
	public boolean existe_favorites_by_client_and_lodgement(int id_client, int id_lodgement) {
		
		if(favoriteRepository.existe_favorites_by_client_and_lodgement(id_client, id_lodgement) == null)
			return false;
		else
			return true;
		
	}
	
	public boolean existe_favorites_by_client_and_favorite(int id_client, int id_fav) {
		
		if(favoriteRepository.existe_favorites_by_client_and_favorite(id_client, id_fav) == null)
			return false;
		else
			return true;
		
	}
	
	public List<Favorite> get_favorites_by_client(int id_client){
		return favoriteRepository.get_favorites_by_client(id_client);
	}

	public boolean remove_favorite(int id_fav) {
		if(favoriteRepository.remove_favorite(id_fav) == 1)
			return true;
		else
			return false;
	}
}
