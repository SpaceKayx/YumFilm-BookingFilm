package com.config.service;


import java.util.Optional;

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
    
    public void createUser(User user)
    {
    	User opt_user = userRepository.findByUserName(user.getUsername());
    	if(opt_user == null)
    	{
    		userRepository.save(user);
    	}
    	else
    	{
    		throw new IllegalArgumentException("User da ton tai !!");
    	}
    }

//    public void updateUser(User user)
//    {
//    	User opt_user = userRepository.findByUserName(user.getUsername());
//    	if(opt_user != null)
//    	{
//    		userRepository.save(user);
//    	}
//    	else
//    	{
//    		throw new IllegalArgumentException("User chua ton tai !!");
//    	}
//    }
    
}