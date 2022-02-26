package com.in28minutes.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String loginMessage(){
		return "login";
	}
	
	@PostMapping("/login")
	public String handleLogin(ModelMap model,@RequestParam String name) {
		model.put("name", name);
		return "welcome";
	}
	
}
