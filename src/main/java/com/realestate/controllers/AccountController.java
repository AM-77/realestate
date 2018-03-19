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
	
	
	public String  is_valid_client(Client client, String repassword) {
		if(is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
				client.getPhone(), repassword).equals("valid")) {
			
			if(client_email_exists(client.getEmail()))
				return "This email is already assained to an other account.";
				 
			return "valid";
		}else {
			return is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
					client.getPhone(), repassword);
		}
	}
	
	
	public String  is_valid_client_not_finished(Client client, String repassword) {
		if(is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
				client.getPhone(), repassword).equals("valid")) {
			
			if(clientService.is_finished_subscribe(client.getEmail()))
				return "This email is already assained to an other account.";
				 
			return "valid";
		}else {
			return is_valid(client.getUsername(), client.getEmail(),client.getName(), client.getLast_name(), client.getPassword(), 
					client.getPhone(), repassword);
		}
	}
	
	public String  is_valid_agent(Agent agent, String repassword) {
		if(is_valid(agent.getUsername(), agent.getEmail(),agent.getName(), agent.getLast_name(), agent.getPassword(), 
				agent.getPhone(), repassword).equals("valid")) {
			
			if(agent_email_exists(agent.getEmail()))
				return "This email is already assained to an other account.";
				
			return "valid";
		}else {
			return is_valid(agent.getUsername(), agent.getEmail(),agent.getName(), agent.getLast_name(), agent.getPassword(), 
					agent.getPhone(), repassword);
		}
	}
	
	
	public String  is_valid_operator(Operator operator, String repassword) {
		if(is_valid(operator.getUsername(), operator.getEmail(), operator.getName(), operator.getLast_name(), 
			operator.getPassword(), operator.getPhone(), repassword).equals("valid")) {
			if(operator_email_exists(operator.getEmail()))
				return "This email is already assained to an other account.";
	
			return "valid";
		}else {
			return is_valid(operator.getUsername(), operator.getEmail(), operator.getName(), operator.getLast_name(), 
					operator.getPassword(), operator.getPhone(), repassword);
		}
	}
	
	public String  is_valid_admin(Admin admin, String repassword) {
		if(is_valid("username", admin.getEmail(), admin.getName(), admin.getLast_name(), 
				admin.getPassword(), admin.getPhone(), repassword).equals("valid")) {
			
			if(admin_email_exists(admin.getEmail()))
				return "This email is already assained to an other account.";
			
			//the cv and the loacle validation 
			return "valid";
		}else {
			return is_valid("a_valid_username", admin.getEmail(), admin.getName(), admin.getLast_name(), 
					admin.getPassword(), admin.getPhone(), repassword);
		}
	}
	
	public String is_valid(String username, String email, String name, String last_name, String password, 
						    String phone, String repassword) {
		
		if(username.trim().length() == 0)
			return "The username is required.";	
		
		if(email.trim().length() == 0)
			return "The email is required.";
		
		if(password.trim().length() == 0)
			return "The password is required.";
		
		if(phone.trim().length() == 0)
			return "The phone number is required.";
		
		if(name.trim().length() == 0)
			return "Your name is required.";
		
		if(repassword.trim().length() == 0)
			return "The password confirmation is required.";
		
		if(last_name.trim().length() == 0)
			return "The last name is required.";
		
		if(!password.trim().equals(repassword.trim()))
			return "The password does not match with its confirmation.";
		
			
		if( !is_accepted("[A-Za-z0-9_]{4,12}", username.trim()))
			return "Invalid username. It must contains only characters and digets.";
		
		if( !is_accepted("[A-Za-z0-9.-_%]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", email.trim())) 
			return "Invalid email.";
		
		if( !is_accepted("[A-Za-z0-9.-_]{6,20}", password.trim())) 
			return "Invalid passowrd. It must be more then 6 characters and digets.";
		
		if( !is_accepted("[0-9\\+]{8,14}", phone.trim())) 
			return "Invalid phone number.";
		
		if( !is_accepted("[A-Za-z]{2,20}", name.trim())) 
			return "Invalid name. It must contains only characters.";
		
		if( !is_accepted("[A-Za-z]{2,20}", last_name.trim())) 
			return "Invalid lastname. It must contains only characters.";
						
		return "valid";
	}
	
	public boolean is_accepted(String the_regexp, String str) {
		Pattern pattern = Pattern.compile(the_regexp);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {
			if(matcher.group().trim().length() == str.trim().length()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean client_email_exists(String email) {
		if(clientService.client_email_exists(email))
			return true;
		else
			return false;
	}
	
	public boolean agent_email_exists(String email) {
		if(agentService.agent_email_exists(email))
			return true;
		else
			return false;
	}
	
	public boolean operator_email_exists(String email) {
		if(operatorService.operator_email_exists(email))
			return true;
		else
			return false;
	}
	
	public boolean admin_email_exists(String email) {
		if(adminService.admin_email_exists(email))
			return true;
		else
			return false;
	}
	
	
	private JavaMailSender javaMailSender = this.mailSender();
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setProtocol("SMTP");
        javaMailSender.setHost("smtp.mail.yahoo.com");
        javaMailSender.setPort(587);
        javaMailSender.setJavaMailProperties(new Properties());
        
        return javaMailSender;
    }
	
	public boolean send_confirmation_email(String email_to, String key) {
		
	
		String emailSubject = "Realestate | Email confirmation.";
		String emailMessage = "Your account has been Successfully in the realestate website."
				+ " Please click the link to confirm you email address http://154.121.251.212:8080/email_confirm?key="+key;

		javaMailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
				mimeMsgHelperObj.setTo(email_to);
				mimeMsgHelperObj.setFrom("amine.griche77@gmail.com");				
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);	
			}
		});
		
		System.out.println("\nMessage Send Successfully.... !\n");
		
		return  true;	
	}
	
	@GetMapping("email_confirm")
	public String get_email_confirm(@RequestParam("key") String key, HttpSession session) {
		
		if(clientService.get_client_by_confirmation_key(key)) {
		
			session.setAttribute("client", clientService.get_client_by_confirmation_key(key));
		
		}else {
			
			if(agentService.get_agent_by_confirmation_key(key)) {
			
				session.setAttribute("agent", agentService.get_agent_by_confirmation_key(key));
			
			}else {
				
				if(operatorService.get_operator_by_confirmation_key(key)) {
				
					session.setAttribute("operator", operatorService.get_operator_by_confirmation_key(key));
			
				}
		
			}
		
		}
		
		return "/";
	}
	
	
	
	
}
