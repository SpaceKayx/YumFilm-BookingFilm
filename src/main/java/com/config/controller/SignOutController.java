package com.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signout")
public class SignOutController 
{
	@Autowired
	HttpServletRequest req;
	
	@GetMapping()
	public String signout()
	{
		req.getSession().invalidate();
		
		SecurityContextHolder.clearContext();
		return"redirect:/home";
	}
}
