package com.config.utils;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.config.entity.User;

import lombok.Data;

@Service
@Data
public class Auth
{
	private Authentication auth;
	private User user;
	
	public Collection<? extends GrantedAuthority> getAuthorties()
	{
		return auth.getAuthorities();
	}
	
	public boolean hasRole(String role)
	{
		return auth.getAuthorities().stream().anyMatch(authority -> authority.equals("ROLE_" + role));
	}
	
	public boolean isAdmin()
	{
		return hasRole("ADMIN");
	}
}
