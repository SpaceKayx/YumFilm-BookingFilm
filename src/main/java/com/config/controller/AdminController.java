package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.config.entity.Film;
import com.config.service.AdminFimlService;


@Controller
@RequestMapping("/manager")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController 
{
	@Autowired
	AdminFimlService adminFilmService;
	
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
	
	@ModelAttribute("listAdminFilm")
	public List<Film> getFilms(){
		return adminFilmService.finAll();	
	}
}
