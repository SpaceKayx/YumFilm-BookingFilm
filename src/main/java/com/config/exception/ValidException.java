package com.config.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidException 
{
	@ExceptionHandler(BadCredentialsException.class)
	public ModelAndView validLogin(BadCredentialsException ex)
	{
		System.out.println("validException");
		ModelAndView view = new ModelAndView("signin");
		if(ex.getMessage().equals("Invalid username or password"))
			view.addObject("invalidInfo", "Invalid username or password");
		return view;
	}
}
