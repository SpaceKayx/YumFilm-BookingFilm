package com.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.entity.Food;
import com.config.repository.FoodRepository;
import com.config.service.FoodService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	FoodService foodService;

	@GetMapping()
	public String showOder() {
		return "order";
	}
	
	@PostMapping("/orderFood")
	public String showOderFood() {
		return "orderFood";
	} 
	@PostMapping("/pay")
	public String pay()
	{
		return"pay";
	}
	
	@ModelAttribute("listFood")
	public List<Food> findAll(){
		return foodService.findAll();
	}
}
