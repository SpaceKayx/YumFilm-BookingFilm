package com.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class Error404Controller {
	
	@GetMapping(value = "/{urlFail}")
	public ModelAndView error404(@PathVariable("urlFail") String invalid) throws NoHandlerFoundException
	{
		throw new NoHandlerFoundException("GET", "/"+invalid, null);
	}
}
