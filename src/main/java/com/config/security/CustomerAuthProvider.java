package com.config.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.config.service.UserService;

@Component
public class CustomerAuthProvider implements AuthenticationProvider{

	@Autowired
	private UserService userService;
	
	@Autowired @Lazy
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String passWord = authentication.getCredentials().toString().trim();

		CustomerUserDetails userDetail = (CustomerUserDetails) userService.loadUserByUsername(userName);
		if(userDetail == null)
		{
			System.out.println("Provider userdetail == null : Invalid username or password");
			throw new BadCredentialsException("Invalid username or password");
		}
		
		if(!passwordEncoder.matches(passWord, userDetail.getPassword()))
		{
			System.out.println("Provider password fail: Invalid username or password");
			throw new BadCredentialsException("Invalid username or password");
		}
		return new UsernamePasswordAuthenticationToken(userName, passWord, userDetail.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
