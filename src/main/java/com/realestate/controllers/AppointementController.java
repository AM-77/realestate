package com.realestate.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realestate.models.Agent;
import com.realestate.models.Appointement;
import com.realestate.models.Appointement_details;
import com.realestate.models.Client;
import com.realestate.models.Lodgement;
import com.realestate.models.My_Appointement;
import com.realestate.models.Notification_details;
import com.realestate.services.AgentService;
import com.realestate.services.AppointementService;
import com.realestate.services.ClientService;
import com.realestate.services.LodgementService;
import com.realestate.services.NotificationService;
import com.realestate.services.ReportsService;

@Controller
public class AppointementController {
	
	@Autowired
	private AppointementService appointementService;
	@Autowired
	private LodgementService lodgementService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private ReportsService reportService;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@SuppressWarnings({ "deprecation" })
	@GetMapping("reserve_appointement")
	public String get_reserve_appointement(@RequestParam("id") int id_lodgement, HttpSession session,  Model model) throws ParseException {
		
		
		
		
		if(session.getAttribute("client") != null ) {

			if(((Client)session.getAttribute("client")).getUsername().equals("added_by_operator"))
				return "redirect:/";
			
			model.addAttribute("client", session.getAttribute("client"));
			
			List<Notification_details> notifications = notificationService.get_notifications(session);
			int notification_nbr = 0;
			
			for(Notification_details notif : notifications) {
				if(!notif.isViewed())
					notification_nbr ++ ;
			}
			
			model.addAttribute("notification_nbr", notification_nbr);
			model.addAttribute("notifications", notifications);
			
			
			
			Lodgement lodgement = lodgementService.get_lodgements_by_id(id_lodgement);
			
			if(lodgement == null) {
				
				session.setAttribute("looking_for", "lodgement");
				return "redirect:/not_found_profile";
			}
		
			List<Agent> agents = agentService.get_agents_by_locale(lodgement.getLocale());
						
			ArrayList<String> avail_dates = new ArrayList<String>();
			
			int day = new Date().getDate()+1;
			int month = new Date().getMonth()+1;
			int year = new Date().getYear() + 1900;

			
			if(( day == 32 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )) || (day == 31 && (month == 4 || month == 6 || month == 9 || month == 10 || month == 11 )) || (day == 29 && month == 2)) {
				System.out.println("cool");
				day = 1;
				
				if(month == 12) {
					month = 1;
					year++;
				}else {
					month ++;
				}
			}else {
				day ++;
			}
			
			String __date = null;
			Date date = null;
			
			
			while(avail_dates.size() < 20) {
				
				if((day == 32 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )) || (day == 31 && (month == 4 || month == 6 || month == 9 || month == 10 || month == 11 )) || (day == 29 && month == 2)) {
					
					day = 1;
					
					if(month == 12) {
						month = 1;
						year++;
					}else {
						month ++;
					}
				}else {
					day ++;
				}
				
				if(day<10) {
					if(month<10)
						__date = year+"-0"+month+"-0"+day;
					else
						__date = year+"-"+month+"-0"+day;
				}else {
					if(month<10)
						__date = year+"-0"+month+"-"+day;
					else
						__date = year+"-"+month+"-"+day;
				}
				
				date = df.parse(__date);
								
				if(appointementService.is_avail_date_first_half(date, id_lodgement) == true) {
					avail_dates.add(__date + " f");
				}
					
				if(appointementService.is_avail_date_second_half(date, id_lodgement) == true) {
					avail_dates.add(__date + " s");
				}				
			
			}
			
			List<Appointement_details> avail_appointements = new ArrayList<Appointement_details>();
			String half;
			
			ArrayList<Agent> avail_agents = new ArrayList<>();
			for(int i=0; i < avail_dates.size(); i++) {		
				
				Date _date = df.parse(avail_dates.get(i).substring(0,10));
				String _half = avail_dates.get(i).substring(11,12);
				avail_agents = new ArrayList<>();
				
				for(int j=0; j< agents.size(); j++) {
					
					
					if(_half.equals("f")) {
						
						if(appointementService.is_avail_agent_first_half(_date, agents.get(j).getId())) {
							avail_agents.add(agents.get(j));
						}
						
					}else {
						
						if(appointementService.is_avail_agent_second_half(_date, agents.get(j).getId())) {
							avail_agents.add(agents.get(j));
						}
					}
						
					if(avail_agents.size() == 25)
						break;
				}				
				
				if(_half.equals("f")) {
					half= "Morning";
				}else {
					half="Evening";
				}

				avail_appointements.add(new Appointement_details(avail_dates.get(i).substring(0,10), half, avail_agents));
			}

					
			model.addAttribute("avail_appointements", avail_appointements);
			
			if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
				model.addAttribute("type", session.getAttribute("type"));
				model.addAttribute("message", session.getAttribute("message"));
				
				session.removeAttribute("type");
				session.removeAttribute("message");
			}
			
			String today;
			
			if((new Date().getDate()+1) < 10) {
				if((new Date().getMonth()+1)<10)
					today = (new Date().getYear()+1900) +"-0"+ (new Date().getMonth()+1) +"-0"+ (new Date().getDate()+1);
				else
					today = (new Date().getYear()+1900) +"-"+ (new Date().getMonth()+1) +"-0"+ (new Date().getDate()+1);
			}else {
				if((new Date().getMonth()+1) <10)
					today = (new Date().getYear()+1900) +"-0"+ (new Date().getMonth()+1) +"-"+ (new Date().getDate()+1);
				else
					today = (new Date().getYear()+1900) +"-"+ (new Date().getMonth()+1) +"-"+ (new Date().getDate()+1);
			}
			
			
			
			model.addAttribute("today", today);
			model.addAttribute("avail_agents", avail_agents);
			model.addAttribute("id_lodgement", id_lodgement);
			
			
			return "appointement/new_appointement";	

		}else {
			
			if(session.getAttribute("operator") != null) {
				
				model.addAttribute("operator", session.getAttribute("operator"));
				
				List<Notification_details> notifications = notificationService.get_notifications(session);
				int notification_nbr = 0;
				
				for(Notification_details notif : notifications) {
					if(!notif.isViewed())
						notification_nbr ++ ;
				}
				
				model.addAttribute("notification_nbr", notification_nbr);
				model.addAttribute("notifications", notifications);
				
				Lodgement lodgement = lodgementService.get_lodgements_by_id(id_lodgement);
				List<Agent> agents = agentService.get_agents_by_locale(lodgement.getLocale());
							
				ArrayList<String> avail_dates = new ArrayList<String>();
				
				int day = new Date().getDate()+1;
				int month = new Date().getMonth()+1;
				int year = new Date().getYear() + 1900;

				String __date = null;
				Date date = null;
				while(avail_dates.size() < 20) {
					if(day<10) {
						if(month<10)
							__date = year+"-0"+month+"-0"+day;
						else
							__date = year+"-"+month+"-0"+day;
					}else {
						if(month<10)
							__date = year+"-0"+month+"-"+day;
						else
							__date = year+"-"+month+"-"+day;
					}
					
					date = df.parse(__date);
									
					if(appointementService.is_avail_date_first_half(date, id_lodgement) == true) {
						avail_dates.add(__date + " f");
					}
						
					if(appointementService.is_avail_date_second_half(date, id_lodgement) == true) {
						avail_dates.add(__date + " s");
					}
					
					if((day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )) || (day == 30 && (month == 4 || month == 6 || month == 9 || month == 10 || month == 11 )) || (day == 29 && month == 2)) {
						day = 1;
						
						if(month == 12) {
							month = 1;
							year++;
						}else {
							month ++;
						}
					}else {
						day ++;
					}
						
				
				}
				
				List<Appointement_details> avail_appointements = new ArrayList<Appointement_details>();
				String half;
				
				ArrayList<Agent> avail_agents = new ArrayList<>();
				for(int i=0; i < avail_dates.size(); i++) {		
					
					Date _date = df.parse(avail_dates.get(i).substring(0,10));
					String _half = avail_dates.get(i).substring(11,12);
					avail_agents = new ArrayList<>();
					
					for(int j=0; j< agents.size(); j++) {
						
						
						if(_half.equals("f")) {
							
							if(appointementService.is_avail_agent_first_half(_date, agents.get(j).getId())) {
								avail_agents.add(agents.get(j));
							}
							
						}else {
							
							if(appointementService.is_avail_agent_second_half(_date, agents.get(j).getId())) {
								avail_agents.add(agents.get(j));
							}
						}
							
						if(avail_agents.size() == 25)
							break;
					}				
					
					if(_half.equals("f")) {
						half= "Morning";
					}else {
						half="Evening";
					}

					avail_appointements.add(new Appointement_details(avail_dates.get(i).substring(0,10), half, avail_agents));
				}

						
				model.addAttribute("avail_appointements", avail_appointements);
				
				if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
					model.addAttribute("type", session.getAttribute("type"));
					model.addAttribute("message", session.getAttribute("message"));
					
					session.removeAttribute("type");
					session.removeAttribute("message");
				}
				
				String today;
				
				if((new Date().getDate()+1) < 10) {
					if((new Date().getMonth()+1)<10)
						today = (new Date().getYear()+1900) +"-0"+ (new Date().getMonth()+1) +"-0"+ (new Date().getDate()+1);
					else
						today = (new Date().getYear()+1900) +"-"+ (new Date().getMonth()+1) +"-0"+ (new Date().getDate()+1);
				}else {
					if((new Date().getMonth()+1) <10)
						today = (new Date().getYear()+1900) +"-0"+ (new Date().getMonth()+1) +"-"+ (new Date().getDate()+1);
					else
						today = (new Date().getYear()+1900) +"-"+ (new Date().getMonth()+1) +"-"+ (new Date().getDate()+1);
				}
				
				model.addAttribute("today", today);
				model.addAttribute("avail_agents", avail_agents);
				model.addAttribute("id_lodgement", id_lodgement);
				
				return "appointement/new_operator_appointement";
			
			}else {
				if(session.getAttribute("agent") != null || session.getAttribute("admin") != null) {
					session.setAttribute("type", "error");
					session.setAttribute("message", "Access denied.");
					return "redirect:/";
				}else {
					session.setAttribute("type", "error");
					session.setAttribute("message", "You have to login.");
					session.setAttribute("url", "reserve_appointement?id="+id_lodgement);
					return "redirect:/login";
				}
			}
		}	
		
	}
	
	@PostMapping("reserve_appointement")
	public String post_reserve_appointement(@RequestParam("id_lodg") int id_lodgement,
											 @RequestParam("id_agent") int id_agent,
											 @RequestParam("half") String half,
											 @RequestParam("date") String date,
											 HttpSession session,  Model model) throws ParseException {
		
		int first_half = 0;
		int second_half = 0;
		if(session.getAttribute("client") != null) {
			if(half.toLowerCase().equals("morning")) {
				first_half = 1;
				second_half = 0;
			}else {
				first_half = 0;
				second_half = 1;
			}
				
			if(appointementService.add(df.parse(date), first_half, second_half, id_lodgement, id_agent, ((Client)session.getAttribute("client")).getId()) == 1) {
				session.setAttribute("type", "success");
				session.setAttribute("message", "The appointement has been saved.");
			}
			else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "There was an error in saving the appointement.");
			}
			
			
			return "redirect:/reserve_appointement?id="+id_lodgement;
		}else
			return "login/login";

	}
	
	@PostMapping("reserve_appointement_by_operator")
	public String post_reserve_appointement_by_operator(@RequestParam("id_lodg") int id_lodgement,
											 @RequestParam("id_agent") int id_agent,
											 @RequestParam("client") String email_client,
											 @RequestParam("half") String half,
											 @RequestParam("date") String date,
											 HttpSession session) throws ParseException {
		
		int first_half = 0;
		int second_half = 0;
		if(session.getAttribute("operator") != null) {
			
			if(clientService.client_email_exists(email_client)) {
				
				if(!clientService.block_client_by_email(email_client)) {
					if(half.toLowerCase().equals("morning")) {
						first_half = 1;
						second_half = 0;
					}else {
						first_half = 0;
						second_half = 1;
					}
						
					if(appointementService.add(df.parse(date), first_half, second_half, id_lodgement, id_agent, ((Client)clientService.get_client_by_email(email_client)).getId() ) == 1) {
						session.setAttribute("type", "success");
						session.setAttribute("message", "The appointement has been saved.");
					}
					else {
						session.setAttribute("type", "error");
						session.setAttribute("message", "There was an error in saving the appointement.");
					}
				}else {
					session.setAttribute("type", "error");
					session.setAttribute("message", "The client' account is blocked.");
				}
			
				
			}else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "The client's email is assocaited to any account.");
			}
			
			
			return "redirect:/reserve_appointement?id="+id_lodgement;
		}else
			return "login/login";

	}
	
	
	@PostMapping("propose_appointement")
	public String post_propose_appointement(@RequestParam(value="id_agent")int id_agent,
											 @RequestParam(value="date")String date,
											 @RequestParam(value="half")String half,
											 @RequestParam(value="id_lodgement")int id_lodgement,
											 Model model, HttpSession session) throws ParseException {
				
		int first_half = 0;
		int second_half = 0;
		if(session.getAttribute("client") != null) {
			if(half.toLowerCase().equals("morning")) {
				first_half = 1;
				second_half = 0;
			}else {
				first_half = 0;
				second_half = 1;
			}
				
			if(appointementService.add(df.parse(date), first_half, second_half, id_lodgement, id_agent, ((Client)session.getAttribute("client")).getId()) == 1) {
				session.setAttribute("type", "success");
				session.setAttribute("message", "The appointement has been saved.");
			}
			else {
				session.setAttribute("type", "error");
				session.setAttribute("message", "There was an error in saving the appointement.");
			}
			
			
			return "redirect:/reserve_appointement?id="+id_lodgement;
		}else
			return "login/login";
	}
	
	
}
