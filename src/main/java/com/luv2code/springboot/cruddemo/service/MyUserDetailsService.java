package com.luv2code.springboot.cruddemo.service;

//import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.dao.UserRepository;
import com.luv2code.springboot.cruddemo.entity.User;
import com.luv2code.springboot.cruddemo.entity.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;
	//private UserDAO userDAO;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
    }
    
    public User save(UserValidation userValidation) {
    	
    	User user = new User();
    	user.setId(userValidation.getId());
    	user.setUserName(userValidation.getUsername());
    	user.setPassword(userValidation.getPassword());
    	
		return userRepository.save(user);
    	
    }
}
