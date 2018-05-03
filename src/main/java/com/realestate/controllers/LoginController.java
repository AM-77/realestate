package com.realestate.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realestate.models.Admin;
import com.realestate.models.Agent;
import com.realestate.models.Client;
import com.realestate.models.Operator;
import com.realestate.services.AdminService;
import com.realestate.services.AgentService;
import com.realestate.services.ClientService;
import com.realestate.services.OperatorService;
import com.realestate.services.StatistcsService;

@Controller
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private StatistcsService statistcsService;
	
	@GetMapping("login")
	public String get_login(HttpSession session, Model model) {
		
		if(session.getAttribute("client") != null ) {
			
			statistcsService.add_statistc(((Client)session.getAttribute("client")).getId(), "client");
			
			return "redirect:/";
		}else {
			
			if(session.getAttribute("operator") != null) {
				if(session.getAttribute("lodgement_id")!=null) {
					
					return "redirect:/operator_reserve_appointement";
				}else {
					
					return "homepage/operator";
				}
				
			}else {
				
				if(session.getAttribute("agent") != null) {
				
					return "redirect:/";
				
				}else {
					
					if(session.getAttribute("admin") != null) {
						return "admin/general";
					}else {
					
						if(session.getAttribute("type") != null && session.getAttribute("message") != null ) {
							
							model.addAttribute("type",session.getAttribute("type"));
							model.addAttribute("message",session.getAttribute("message"));
							
							session.removeAttribute("message");
							session.removeAttribute("type");
						}
						
						return "login/login";
					
					}
				
				}
				
			}
			
		}

	}
			
	
	@GetMapping("homepage")
	public String get_homepage(HttpSession session) {
		
		if(session.getAttribute("url") != null)
			session.removeAttribute("url");

		return "redirect:/";
	}

	@PostMapping("login")
	public String post_login(@RequestParam("email") String email, 
							  @RequestParam("password") String password,
							  @RequestParam(value="keep_logged", defaultValue="no_value")String keep_logged,
							  HttpSession session, Model model, HttpServletResponse response) {
		String url = "";
		if(session.getAttribute("url") != null) {
			url = (String)session.getAttribute("url");
			session.removeAttribute("url");
		}
				

		Client client = (Client)clientService.get_client_by_email_and_password(email, password);
		
		if( client != null) {
						
			
				if(client.getBlocked() == 0) {
					session.setAttribute("client", client);	
					session.setAttribute("get_my_all_appointements", "go");
					
					statistcsService.add_statistc( client.getId(), "client");
					
					if(keep_logged.equals("keep_logged")) {
						Cookie k = new Cookie("logged_in", "client-"+client.getId());
						k.setMaxAge(7*24*60*60*60);
						response.addCookie(k);
					}
					
					if(client.getUsername().equals("added_by_operator")) {
						session.setAttribute("url", "finish_client_subscription");
						session.setAttribute("not_finished", "finish_client_subscription");
					}else {
						session.setAttribute("url", "my_all_appointements");
					}
					
				}else {
					session.setAttribute("type", "error");
					session.setAttribute("message", "This account is blocked.");
				}
				
				return "redirect:/"+url;
			
			
		}else {
			
			Agent agent = (Agent)agentService.get_agent_by_email_and_password(email, password);
			if( agent != null) {
				
				if(agent.getBlocked() == 0) {
					session.setAttribute("agent", agent);
					
					if(keep_logged.equals("keep_logged")) {
						Cookie k = new Cookie("logged_in", "agent-"+agent.getId());
						k.setMaxAge(7*24*60*60*60);
						response.addCookie(k);
					}
					
					statistcsService.add_statistc( agent.getId(), "agent");
					
					return "redirect:/"+url;
				}else {
					model.addAttribute("type", "error");
					if(agent.getBlocked() == 2) {
						model.addAttribute("message", "This account has not been validated yet.");
					}else {
						model.addAttribute("message", "This account is blocked.");
					}
				}
				
			}else {
				
				Operator operator = (Operator) operatorService.get_operator_by_email_and_password(email, password);
				if( operator != null) {
					
					if(operator.getBlocked() == 0) {
						session.setAttribute("operator", operator);
						
						if(keep_logged.equals("keep_logged")) {
							Cookie k = new Cookie("logged_in", "operator-"+operator.getId());
							k.setMaxAge(7*24*60*60*60);
							response.addCookie(k);
						}
						
						statistcsService.add_statistc( operator.getId(), "operator");
						return "redirect:/"+url;
					}else {
						model.addAttribute("type", "error");
						if(operator.getBlocked() == 2) {
							model.addAttribute("message", "This account has not been validated yet.");
						}else {
							model.addAttribute("message", "This account is blocked.");
						}
					}
					
				}else {
					
					Admin admin = (Admin)adminService.get_admin_by_email_and_password(email, password);
					if( admin != null) { 
					
						session.setAttribute("admin", admin);
						
						if(keep_logged.equals("keep_logged")) {
							Cookie k = new Cookie("logged_in", "admin-"+admin.getId());
							k.setMaxAge(7*24*60*60*60);
							response.addCookie(k);
						}
						
						return "redirect:/"+url;
					
					}else {
						
						if(!clientService.client_email_exists(email) && !agentService.agent_email_exists(email) &&
						   !operatorService.operator_email_exists(email) && !adminService.admin_email_exists(email) ) {
							model.addAttribute("type", "error");
							model.addAttribute("message", "This email is not assocaited to any account.");
						}else {
							model.addAttribute("type", "error");
							model.addAttribute("message", "Wrong password");
						}
						
					}
					
				}
				
			}
			
		}
		
		
		return "login/login";
	}
	
}
