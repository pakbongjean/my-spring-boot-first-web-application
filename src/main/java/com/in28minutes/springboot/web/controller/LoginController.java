package com.in28minutes.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.springboot.web.service.LoginService;

@Controller
public class LoginController {
	
	
	@Autowired
	private LoginService service;
	
	@GetMapping("/login")
	public String loginMessage(){
		return "login";
	}
	
	@PostMapping("/login")
	public String handleLogin(ModelMap model,@RequestParam String name
			,@RequestParam String password) {

		if(!service.validateUser(name, password)) {
			model.put("errorMessage", "Invalid Credentials!!");
			return "login";
		}
		
		model.put("name", name);
		return "welcome";
	}
	
}
