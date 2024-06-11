package com.config.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.config.entity.Actor;
import com.config.entity.Film;
import com.config.entity.FilmAdminDetail;
import com.config.entity.Food;
import com.config.repository.AdminFimlRepository;
import com.config.repository.FilmRepository;
import com.config.service.AdminFimlService;
import com.config.service.AdminFoodService;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;

@Controller
@RequestMapping("/manager")
public class AdminController {
	
	@Autowired
	ServletContext application;

	@Autowired
	AdminFimlService adminFilmService;

	@Autowired
	AdminFoodService adminFoodService;

	@Autowired
	FilmRepository filmRepository;
	
	@GetMapping("/film-detail/edit")
	public String filmDetail(@RequestParam("filmId") Integer filmId, Model model) throws ParseException {

		model.addAttribute("adminFilm", adminFilmService.findById(filmId));
		FilmAdminDetail obj = adminFilmService.detailFimlAdmin(filmId);

//		Date premiereDate = (Date) obj.getPremiereDate();
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
//		String strDate = dateFormatter.format(premiereDate);
//		System.out.println(obj.getFilmImage().toString());
		
		Double	price = obj.getPrice();
		model.addAttribute("detailFimlAdmin", obj);
		return "admin_film_detail";
	}
	
	@PostMapping("/film-detail/add")
	public String addFilm( @ModelAttribute("detailFimlAdmin") FilmAdminDetail filmAdminDetail,@RequestParam("fileImage") MultipartFile file) throws IllegalStateException, IOException {
		
		File saveImageFilm = new File(application.getRealPath("/images/"));
		
		if(!saveImageFilm.exists()) {
			saveImageFilm.mkdirs();
		}
		System.out.println(file);
		String fileName = file.getOriginalFilename();
		saveImageFilm = new File(saveImageFilm+"/"+fileName);
		file.transferTo(saveImageFilm);
		filmAdminDetail.setFilmImage(fileName);
		filmAdminDetail.setFilmImage(fileName);
		
		
		 List<String> actors = Arrays.stream(filmAdminDetail.getACTORS().split(","))
                 .map(String::trim)
                 .collect(Collectors.toList());
		 
		 List<String> filmType = Arrays.stream(filmAdminDetail.getFILMTYPES().split(","))
                 .map(String::trim)
                 .collect(Collectors.toList());
		adminFilmService.addFilm(
				filmAdminDetail.getFilmName(), 
				filmAdminDetail.getYearProduction(),
				filmAdminDetail.getFilmTime(), 
				filmAdminDetail.getDirectorName(), 
				filmAdminDetail.getFILMTYPES(),
				filmAdminDetail.getPremiereDate(), 
				filmAdminDetail.getCountryId(), 
				filmAdminDetail.getACTORS(),
				filmAdminDetail.getDescription(),
				filmAdminDetail.getFilmImage(),
				filmAdminDetail.getPrice(),
				filmAdminDetail.getAge()
				);
		
		return "redirect:/manager/film-detail";
	}
	
	@PostMapping("/film-detail/delete")
	public String deleteFilm(@RequestParam("filmId") Integer filmId) {
		System.out.println(filmId);
		System.out.println(filmId);
		System.out.println(filmId);
		adminFilmService.deleteFilm(filmId);
		return "redirect:/manager/film-detail";
	}
	
	@PostMapping("/film-detail/update")
	public String update(@ModelAttribute("detailFimlAdmin") FilmAdminDetail filmAdminDetail,
			@RequestParam("fileImage") MultipartFile file,
			@RequestParam(value = "showImage", required = false) String showImage
			) throws IllegalStateException, IOException {
		
		File saveImageFilm = new File(application.getRealPath("/images/"));
		
		if(!saveImageFilm.exists()) {
			saveImageFilm.mkdirs();
		}
		if(!file.isEmpty()) 
		{
			if(!showImage.equalsIgnoreCase(file.getOriginalFilename()))
			{
				System.out.println("hhi: "+file.getOriginalFilename());
				String fileName = file.getOriginalFilename();
				saveImageFilm = new File(saveImageFilm+"/"+fileName);
				file.transferTo(saveImageFilm);
				filmAdminDetail.setFilmImage(fileName);
			}
		}else {
			Optional<Film> OptionalFilm = filmRepository.findById(filmAdminDetail.getFilmId());
			filmAdminDetail.setFilmImage(OptionalFilm.get().getFilmImage());
		}
		
		Optional<Film> OptionalFilm = filmRepository.findById(filmAdminDetail.getFilmId());
		if(OptionalFilm.isPresent()) {
			adminFilmService.updateFilm(
					filmAdminDetail.getFilmId(),
					filmAdminDetail.getFilmName(), 
					filmAdminDetail.getYearProduction(),
					filmAdminDetail.getFilmTime(), 
					filmAdminDetail.getDirectorName(), 
					filmAdminDetail.getFILMTYPES(),
					filmAdminDetail.getPremiereDate(), 
					filmAdminDetail.getCountryId(), 
					filmAdminDetail.getACTORS(),
					filmAdminDetail.getDescription(),
					filmAdminDetail.getFilmImage(),
					filmAdminDetail.getPrice(),
					filmAdminDetail.getAge()
					);
			}
		return "redirect:/manager" ;
		
	}

	@GetMapping("/film-detail")
	public String filmDetail1(Model model) {
		model.addAttribute("detailFimlAdmin", new FilmAdminDetail());
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
	public List<Object[]> getFilms() {
		return adminFilmService.findAll();
	}

}
