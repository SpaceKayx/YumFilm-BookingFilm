package com.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.entity.User;
import com.config.security.CustomerUserDetails;
import com.config.service.UserService;

@Controller
@RequestMapping("/signin")
public class SignInController {
	
	
	@Autowired
	UserService userService;
	
	CustomerUserDetails details;
	
	@GetMapping()
	public String init()
	{
		return"signin";
	}
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PostMapping()
	public String login(@ModelAttribute User user_form) {
		System.out.println(0);
	    try {
	        String username = user_form.getUsername();
	        String rawPassword = user_form.getPassword();

	        details = (CustomerUserDetails) userService.loadUserByUsername(username);
	        
	        if (passwordEncoder.matches(rawPassword, details.getPassword())) {
	            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
	            		details, null, details.getAuthorities());
	            SecurityContextHolder.getContext().setAuthentication(authToken);
	            	System.out.println("role: " +details.getAuthorities());
	            return "redirect:/manager";
	        } else {
	            return "signin";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "error";
	    }
	}
}
