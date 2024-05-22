package com.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileAdminController {
	
		@GetMapping("/admin")
		public String profile()
		{
			return "profileAdmin";
		}
		@GetMapping("/user")
		public String profileUser()
		{
			return "profileUser";
		}
	
}
