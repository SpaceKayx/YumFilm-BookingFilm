package com.config.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.entity.User;
import com.config.repository.UserRepository;

@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	UserRepository repo;
	
	@GetMapping()
	public String init()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		System.out.println(authorities);
		return "index";
	}
	
	@GetMapping("/film-detail")
	public String filmDetail()
	{
		return "filmdetail";
	}
	@GetMapping("/list-film")
	public String listfilm()
	{
		return "listfilm";
	}
}
