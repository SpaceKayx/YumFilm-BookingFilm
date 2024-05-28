package com.config.security;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> author = authentication.getAuthorities();
		for (GrantedAuthority authority : author) 
		{
			if(authority.getAuthority().equals("ROLE_ADMIN"))
			{
				response.sendRedirect("/manager");
				return;
			}
			else if (authority.getAuthority().equals("ROLE_USER"))
			{
				response.sendRedirect("/home");
				return;
			}
		}
		response.sendRedirect("/");
	}

}
