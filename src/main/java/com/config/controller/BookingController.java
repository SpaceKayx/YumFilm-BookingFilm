package com.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingController {

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
}
