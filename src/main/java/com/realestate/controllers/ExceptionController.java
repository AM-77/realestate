package com.realestate.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
@Controller
public class ExceptionController {//implements ErrorController{
	
//	@GetMapping("error")
//	public String get_not_found_profile(HttpSession session, Model model) {
//		
//		if(session.getAttribute("looking_for") != null) {
//			
//			if(session.getAttribute("looking_for").equals("client"))
//				model.addAttribute("looking_for_client", true);
//			
//			if(session.getAttribute("looking_for").equals("agent"))
//				model.addAttribute("looking_for_agent", true);
//			
//			if(session.getAttribute("looking_for").equals("lodgement"))
//				model.addAttribute("looking_for_lodgement", true);
//			
//			if(session.getAttribute("looking_for").equals("wish_list"))
//				model.addAttribute("looking_for_wish_list", true);
//			
//			
//			session.removeAttribute("looking_for");
//		}else {
//			model.addAttribute("not_found_error", true);
//		}
//		
//		return "exceptions/not_found";
//	}
//
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}
//	
}
