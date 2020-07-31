package com.todo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.todo.project.entity.User;
import com.todo.project.repository.UserRepository;
import com.todo.project.service.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLoginPage() {
		return "welcome";
	}
	/*
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String redirectToWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {
		if(loginService.checkUser(username, password) == true) {
			User user = userRepository.findUserByUserId(username);
			model.put("name", user.getName());
			model.put("username", username);
			return "welcome";
		}
		model.put("validation", "Invalid User ID and Password!");
		return "login";
	}
	*/
}
