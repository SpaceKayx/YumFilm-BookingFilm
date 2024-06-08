package com.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.entity.User;
import com.config.repository.UserRepository;
import com.config.service.UserService;
@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	private final BCryptPasswordEncoder  passwordEncoder;
	 public SignUpController(BCryptPasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }
	@Autowired
	UserService service;
	
	@GetMapping()
	public String init()
	{
		return"signup";
	}
	@PostMapping()
	public String regis(@ModelAttribute User u)
	{
		String encoder = passwordEncoder.encode(u.getPassword().trim());
		u.setPassword(encoder);
		service.createUser(u);
		return "redirect:/signin";
	}
}
