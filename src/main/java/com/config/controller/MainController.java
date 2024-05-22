package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		User user = new User();
		
		List<User> list = repo.findAll();
		for (User u : list) {
			System.out.println(u.getUsername());
		}
		return "index";
	}
	
	@GetMapping("/film-detail")
	public String filmDetail()
	{
		return "filmdetail";
	}
}
