package org.springmvcdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springmvcdemo.util.LoginUser;

@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
		
	@GetMapping("/")
	public String showWelcome(Model theModel) {
		LOG.debug("inside show welcome handler method");
		String account = LoginUser.getLoggedInUserName();
		if(account!=null) {
			theModel.addAttribute("account", account);
		}
		return "home";
	}
	
	@GetMapping("/home")
	public String showHome(Model theModel) {
		LOG.debug("inside show home handler method");
		String account = LoginUser.getLoggedInUserName();
		if(account!=null) {
			theModel.addAttribute("account", account);
		}
		return "home";
	}
	
	@GetMapping("/403")
	public String show403(Model theModel) {
		LOG.debug("inside 403 handler method");
		String account = LoginUser.getLoggedInUserName();
		if(account!=null) {
			theModel.addAttribute("account", account);
		}
		return "403";
	}
	
	
}
