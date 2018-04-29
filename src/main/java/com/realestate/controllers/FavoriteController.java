package com.realestate.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realestate.models.Client;
import com.realestate.models.Favorite;
import com.realestate.models.Favorite_details;
import com.realestate.models.Lodgement;
import com.realestate.models.Notification_details;
import com.realestate.services.FavoriteService;
import com.realestate.services.LodgementService;
import com.realestate.services.NotificationService;

@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	@Autowired
	private LodgementService lodgementService;
	@Autowired
	private NotificationService notificationService;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@GetMapping("add_favorite")
	public String get_add_favorite(@RequestParam("id")int id_lodgement, Model model, HttpSession session) {
		
		if(session.getAttribute("client") != null) {
			
			if(((Client)session.getAttribute("client")).getUsername().equals("added_by_oprator"))
				return "redirect:/";
			
			
			if(favoriteService.existe_favorites_by_client_and_lodgement(((Client)session.getAttribute("client")).getId(), id_lodgement)) {
				
				session.setAttribute("type", "error");
				session.setAttribute("message", "You already have it in your favorite list");
				
			}else {
				
				if(favoriteService.add_favorite(id_lodgement, ((Client)session.getAttribute("client")).getId())) {
					
					session.setAttribute("type", "success");
					session.setAttribute("message", "Added to your favorite list.");
					
				}else {
					
					session.setAttribute("type", "error");
					session.setAttribute("message", "Sorry! Something went worng, Try again later.");
				}
				
			}
			
			
			return "redirect:/lodgement_details/"+id_lodgement;
		}else {
			session.setAttribute("type", "error");
			session.setAttribute("message", "You have to login.");
			return "redirect:/login";
		}

	}
	
	@GetMapping("remove_favorite")
	public String get_remove_favorite(@RequestParam("id")int id_fav, HttpSession session, Model model) {
		
		if(session.getAttribute("client") != null) {
			
			if(((Client)session.getAttribute("client")).getUsername().equals("added_by_oprator"))
				return "redirect:/";
			
			if(favoriteService.existe_favorites_by_client_and_favorite(((Client)session.getAttribute("client")).getId(), id_fav)) {
				
				if(favoriteService.remove_favorite(id_fav)) {
					
					session.setAttribute("type", "success");
					session.setAttribute("message", "Removed from your favorite list.");
					
				}else {
					
					session.setAttribute("type", "error");
					session.setAttribute("message", "Sorry! Something went worng, Try again later.");
				}		
			}else {
				
				session.setAttribute("type", "error");
				session.setAttribute("message", "You dont have any favorite with this details.");
			}
					
			return "redirect:/my_favorites";
		}else {
			session.setAttribute("url", "remove_favorite?id="+id_fav);
			return "redirect:/login";
		}
	}	
	
	@GetMapping("my_favorites")
	public String get_my_favorites(HttpSession session, Model model) throws ParseException {
		
		
		if(session.getAttribute("client") != null) {
			
			if(((Client)session.getAttribute("client")).getUsername().equals("added_by_oprator"))
				return "redirect:/";
			
			
			List<Notification_details> notifications = notificationService.get_notifications(session);
			int notification_nbr = 0;
			
			for(Notification_details notif : notifications) {
				if(!notif.isViewed())
					notification_nbr ++ ;
			}
			
			model.addAttribute("notification_nbr", notification_nbr);
			model.addAttribute("notifications", notifications);
			
			List<Favorite> favs = favoriteService.get_favorites_by_client(((Client)session.getAttribute("client")).getId());
			
			if(favs.size() == 0) {
				model.addAttribute("empty_list", "true");
			}else {
				List<Favorite_details> favorites = new ArrayList<Favorite_details>();
				Lodgement l;
				
				for(Favorite f:favs) {
					l = lodgementService.get_lodgements_by_id(f.getId_lodgement());
										
					favorites.add(new Favorite_details(f.getId(), l.getId(), l.getType(), l.getAddress(), f.getTime().toString().substring(0, 10), f.getTime().toString().substring(11, 19)));
				}
				
				model.addAttribute("empty_list", "false");
				model.addAttribute("favorites", favorites);
			}
			
			if( !(session.getAttribute("type") == null) && !(session.getAttribute("message") == null) ) {
				
				model.addAttribute("type", session.getAttribute("type"));
				model.addAttribute("message", session.getAttribute("message"));
				
				session.removeAttribute("type");
				session.removeAttribute("message");
			}
			
			session.setAttribute("url", "my_favorites");
			model.addAttribute("client", session.getAttribute("client"));
			return "favorite/my_favorites";
		}else {
			session.setAttribute("url", "my_favorites");
			return "redirect:/login";
		}
	}
	
}
