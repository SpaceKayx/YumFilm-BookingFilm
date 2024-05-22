package com.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oder")
public class oder_Controller {

	@GetMapping
	public String showOder() {
		return "oder";
	}
	
	@PostMapping("/oderFood")
	public String showOderFood() {
		return "oderFood";
	} 
}
