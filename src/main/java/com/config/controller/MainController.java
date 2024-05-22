package com.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {

	@GetMapping()
	public String init()
	{
		return "index";
	}
	
	@GetMapping("/film-detail")
	public String filmDetail()
	{
		return "filmdetail";
	}
}
