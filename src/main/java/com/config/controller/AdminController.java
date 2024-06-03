package com.config.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.config.entity.Film;
import com.config.entity.FilmAdminDetail;
import com.config.entity.Food;
import com.config.repository.AdminFimlRepository;
import com.config.service.AdminFimlService;
import com.config.service.AdminFoodService;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;


@Controller
@RequestMapping("/manager")
public class AdminController 
{
	
	@Autowired
	AdminFimlService adminFilmService;
	
	@Autowired
	AdminFoodService adminFoodService;
	
	@GetMapping("/film-detail/edit")
	public String filmDetail(@RequestParam("filmId") Integer filmId, Model model) throws ParseException {
		
		model.addAttribute("adminFilm", adminFilmService.findById(filmId));
		FilmAdminDetail obj =  adminFilmService.detailFimlAdmin(filmId);
		
		Date premiereDate = (Date) obj.getPremiereDate(); 
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormatter.format(premiereDate);
//		System.out.println(obj.getFilmImage().toString());
		model.addAttribute("detailFimlAdmin", obj);
		
		return "admin_film_detail";
	}
	
	
	@GetMapping("/film-detail")
	public String filmDetail1() {
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
	public List<Object[]> getFilms(){
		return adminFilmService.findAll();	
	}

	
}
