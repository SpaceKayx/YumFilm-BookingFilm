package com.config.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/manager")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController 
{
	@PostMapping("/film-detail")
	public String filmDetail() {
		return "admin_film_detail";
	}
	@GetMapping("/food-detail")
	public String foodDetail() {
		return "admin_food_detail";
	}

	@GetMapping()
	public String init() {
		return "admin_film";
	}
}
