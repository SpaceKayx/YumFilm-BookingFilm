package com.config.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.config.entity.Film;
import com.config.entity.FilmGenres;
import com.config.entity.User;
import com.config.repository.FilmDetailRepository;
import com.config.repository.FilmRepository;
import com.config.repository.UserRepository;
import com.config.service.FilmDetailService;
import com.config.service.FilmService;
import com.config.security.CustomerUserDetails;
import com.config.utils.Auth;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	UserRepository repo;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	FilmDetailService filmDetailService;
	@GetMapping()
	public String init()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		System.out.println(authorities);
		return "index";
	}
	
	@GetMapping("/fimlDetail")
	public String filmDetail(@RequestParam("idFilm") int idFilm, Model model)
	{
		Object[] object = filmDetailService.findFilmDetailById(idFilm);
		model.addAttribute("listFilmDetailById", object);
		return "/filmdetail";
	}
	@GetMapping("/list-film")
	public String listfilm()
	{
		return "listfilm";
	}
	
	
	@ModelAttribute("listFilm")
	public List<Object[]> getFilmsHotinMonth(){
		return filmService.findFilmsHot();
	}
	
	
	@ModelAttribute("listAllFilms")
	public List<Object[]> getAllFilms(){
		return filmDetailService.findAllFilms();
	}
	
	@ModelAttribute("listFilmsUpComing")
	public List<Object[]> getFindFilmsUpComing(){
		return filmService.findFimlupComing();
	}
	

}
