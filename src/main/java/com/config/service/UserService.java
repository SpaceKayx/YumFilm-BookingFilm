package com.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.config.entity.User;
import com.config.repository.UserRepository;
import com.config.security.CustomerUserDetails;
import com.config.utils.Auth;

@Service
public class UserService implements UserDetailsService {

	
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("userService");
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng với tên: " + username);
        }
        user.setPassword(user.getPassword().trim());
        return new CustomerUserDetails(user);
    }
    
    public User findByUsername(String username)
    {
    	return userRepository.findByUserName(username);
    	
    }
    
}