package com.realestate.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.models.Admin;
import com.realestate.models.Agent;
import com.realestate.models.Appointement;
import com.realestate.models.Client;
import com.realestate.models.Lodgement;
import com.realestate.models.Lodgement_detail;
import com.realestate.models.Notification_details;
import com.realestate.models.Operator;
import com.realestate.services.AdminService;
import com.realestate.services.AgentService;
import com.realestate.services.AppointementService;
import com.realestate.services.ClientService;
import com.realestate.services.LodgementService;
import com.realestate.services.NotificationService;
import com.realestate.services.OperatorService;
import com.realestate.services.ReportsService;

@Controller
public class AccountController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ReportsService reportsService;
	@Autowired
	private AppointementService appointementService;
	@Autowired
	private LodgementService lodgementService;
	@Autowired
	private NotificationService notificationService;
	
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	@GetMapping("subscribe_as_client")
	public String get_subscribe(HttpSession session) {
		if(session.getAttribute("client") != null || session.getAttribute("agent") != null || session.getAttribute("operator") != null || session.getAttribute("admin") != null)
			return "redirect:/";
		
		return "subscribe/subscribe_as_client";
	}
	
	@GetMapping("subscribe_as_agent")
	public String get_subscribe_as_agent(HttpSession session, Model model) {
		if(session.getAttribute("client") != null || session.getAttribute("operator") != null || session.getAttribute("agent") != null || session.getAttribute("admin") != null)
			return "redirect:/";
		
		if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
			model.addAttribute("type", session.getAttribute("type"));
			model.addAttribute("message", session.getAttribute("message"));
			
			session.removeAttribute("type");
			session.removeAttribute("message");
		}
		
		return "subscribe/subscribe_as_agent";
	}
	
	@GetMapping("subscribe_as_operator")
	public String get_subscribe_as_operator(HttpSession session, Model model) {
		if(session.getAttribute("client") != null || session.getAttribute("operator") != null || 
				session.getAttribute("agent") != null || session.getAttribute("admin") != null)
			return "redirect:/";
		
		if(session.getAttribute("type") != null && session.getAttribute("message") != null) {
			model.addAttribute("type", session.getAttribute("type"));
			model.addAttribute("message", session.getAttribute("message"));
			
			session.removeAttribute("type");
			session.removeAttribute("message");
		}
		
		return "subscribe/subscribe_as_operator";
	}
	
	@GetMapping("subscribe_as_admin")
	public String get_subscribe_as_admin(HttpSession session, Model model) {
		if(session.getAttribute("admin") != null)
				return "subscribe/subscribe_as_admin";
		
		
		model.addAttribute("type", "model.addAttribute(\"message\", \"You have to login to your admin account.\");");
		model.addAttribute("message", "You have to login to your admin account.");
		return "login/login";
	}
	
	
}
