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
	
	
	
}
