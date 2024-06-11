package com.config.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.config.entity.Film;
import com.config.entity.Food;
import com.config.service.AdminFimlService;
import com.config.service.FoodService;

import jakarta.servlet.ServletContext;

@Controller
@RequestMapping("/manager")
public class AdminController {
	@Autowired
	AdminFimlService adminFilmService;

	@Autowired
	FoodService foodService;

	@Autowired
	ServletContext application;

	@GetMapping("/film-detail")
	public String filmDetail() {
		return "admin_film_detail";
	}

	@GetMapping("/food-detail")
	public String foodDetail() {
		return "admin_food_detail";
	}

	@GetMapping("/food-detail/edit/{id}")
	public String foodDetail(Model model, @PathVariable("id") int id ) {
		System.out.println("hihi");
		Food newFood = foodService.findById(id);
		model.addAttribute("newFood", newFood);
		return "admin_food_detail";
	}

	@GetMapping()
	public String init(Model model) {
		model.addAttribute("listAdminFood", foodService.selectAll());
		return "admin_film";
	}

	@ModelAttribute("listAdminFilm")
	public List<Film> getFilms() {
		return adminFilmService.finAll();
	}

	@ModelAttribute("newFood")
	public Food getFood() {
		return Food.builder().build();
	}

	@PostMapping("/food-detail/update")
	public String update(@ModelAttribute("newFood") Food food , @RequestParam("fileImage") MultipartFile file) throws IllegalStateException, IOException {
		File saveImageFood = new File(application.getRealPath("/images/"));
		if (!saveImageFood.exists()) {
			saveImageFood.mkdirs();
		}
		System.out.println("file name: " +file.getOriginalFilename());
		String fileName = file.getOriginalFilename();
		saveImageFood = new File(saveImageFood + "/" + fileName);
		file.transferTo(saveImageFood);
		food.setFoodImage(fileName);
		System.out.println("aloalo");
		foodService.save(food);
		return "redirect:/manager";
	}

	@PostMapping("/food-detail/add")
	public String createFood(@ModelAttribute Food food, @RequestParam("fileImage") MultipartFile file) throws IllegalStateException, IOException {
		File saveImageFood = new File(application.getRealPath("/images/"));
		if (!saveImageFood.exists()) {
			saveImageFood.mkdirs();
		}
		System.out.println("file name: " +file.getOriginalFilename());
		String fileName = file.getOriginalFilename();
		saveImageFood = new File(saveImageFood + "/" + fileName);
		file.transferTo(saveImageFood);
		food.setFoodImage(fileName);
		try {
			
			foodService.save(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/manager";
	}
	
	@PostMapping("food-detail/delete")
	public String delete(@RequestParam("foodId") int id)
	{
		foodService.deleteById(id);
		return "redirect:/manager";
	}
}
