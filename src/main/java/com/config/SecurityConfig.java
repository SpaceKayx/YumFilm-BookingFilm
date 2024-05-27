package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.config.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {
    @Autowired
    UserService userService;

    @Autowired
    HttpServletResponse resp;
    
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
        		.requestMatchers("/manager", "/manager/**").hasAuthority("ROLE_ADMIN")
            .requestMatchers("/booking", "/manager", "/booking/**", "/manager/**").authenticated()
            .requestMatchers("/**").permitAll()
        )
        .formLogin((form) -> form
            .loginPage("/signin")
            .defaultSuccessUrl("/home", true)
            .permitAll()
        )
        .userDetailsService(userService)
        .logout((logout) -> logout
        		.logoutUrl("/signout")
        		.permitAll()
        )
        .exceptionHandling()
        .accessDeniedHandler((request, response, AccessDeniedHandler) ->
        {
        	response.sendRedirect("/home");
        })
        ;

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
