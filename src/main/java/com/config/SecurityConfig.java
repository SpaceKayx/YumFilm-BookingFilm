package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.config.security.CustomerAuthProvider;
import com.config.security.SuccessHandler;
import com.config.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Configuration
public class SecurityConfig {
    @Autowired
    UserService userService;

    private final CustomerAuthProvider provider;
    
    private final SuccessHandler successHandler;
    

	public SecurityConfig(CustomerAuthProvider provider, SuccessHandler successHandler) {
		super();
		this.provider = provider;
		this.successHandler = successHandler;
	}

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeHttpRequests((requests) -> requests
	            .requestMatchers("/manager", "/manager/**").hasAuthority("ROLE_ADMIN")
	            .requestMatchers("/booking", "/manager", "/booking/**", "/manager/**").authenticated()
	            .requestMatchers("/**").permitAll()
	        )
	        .userDetailsService(userService)
	        .formLogin((form) -> form
	            .loginPage("/signin")
	            .successHandler(successHandler)
	            .permitAll()
	        )
	        .authenticationProvider(provider)
	        .logout((logout) -> logout
	            .logoutUrl("/signout")
	            .permitAll()
	        )
	        .exceptionHandling()
	        .accessDeniedHandler((request, response, ex) -> {
	            response.sendRedirect("/home");
	        });

	    return http.build();
	}

    @Bean
    @Primary
    @Lazy
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
