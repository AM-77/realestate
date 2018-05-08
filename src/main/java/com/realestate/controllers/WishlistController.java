package com.realestate.controllers;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realestate.models.Client;
import com.realestate.models.Notification_details;
import com.realestate.models.Wishlist;
import com.realestate.services.NotificationService;
import com.realestate.services.WishService;

@Controller
public class WishlistController {
	
	@Autowired
	private WishService wishService;
	@Autowired
	private NotificationService notificationService;
		
	@GetMapping("wish_list")
	public String get_wish_list(HttpSession session, Model model) throws ParseException {
		
		if(session.getAttribute("client") != null) {
			
			wishService.search_wish( session);
			
			List<Wishlist> wished_list = wishService.get_all_wished_by_client(((Client)session.getAttribute("client")).getId());
			
			if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
				
				model.addAttribute("type", session.getAttribute("type"));
				model.addAttribute("message", session.getAttribute("message"));
				
				session.removeAttribute("type");
				session.removeAttribute("message");
				
			}
			
			List<Notification_details> notifications = notificationService.get_notifications(session);
			int notification_nbr = 0;
			
			for(Notification_details notif : notifications) {
				if(!notif.isViewed())
					notification_nbr ++ ;
			}
			
			model.addAttribute("notification_nbr", notification_nbr);
			model.addAttribute("notifications", notifications);
			
			
			if(wished_list.size() == 0) {
				model.addAttribute("empty_list", true);
			}else {
				model.addAttribute("empty_list", false);
			}
			
			model.addAttribute("client", session.getAttribute("client"));
			model.addAttribute("wished_list", wished_list);
			return "appointement/my_wish_list";
		}else {
			
			if(session.getAttribute("agent") != null || session.getAttribute("operator") != null || session.getAttribute("admin") != null) {
				
				session.setAttribute("looking_for", "wish_list");
				return "redirect:/not_found_profile";
			}else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "You have to login.");
				session.setAttribute("url", "wish_list");
				return "redirect:/login";
			}
		
		}
		
	}
	
	@PostMapping("add_wish_list")
	public String post_add_wish_list(@RequestParam("address") String address,
									  @RequestParam("type") String type,
									  @RequestParam("max_price") double max_price,
									  @RequestParam("min_price") double min_price,
									  @RequestParam("max_surface") double max_surface,
									  @RequestParam("min_surface") double min_surface,
									  @RequestParam("max_floor") int max_floor,
									  @RequestParam("min_floor") int min_floor,
									  HttpSession session, Model model) {
		
		if(session.getAttribute("client") != null) {
					
			if(wishService.add_wish(((Client)session.getAttribute("client")).getId(), address, type, max_surface, min_surface, max_price, min_price, max_floor, min_floor)) {
				session.setAttribute("type", "success");
				session.setAttribute("message", "The lodgement has been added to the wish list.");
			}else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "Sorry! There was an error please try again later.");
			}
			return "redirect:/wish_list";
	
		}else {
			
			session.setAttribute("type", "error");
			session.setAttribute("message", "Access denied.");
			return "redirect:/";
		}
		
	}
	
	
}
