package com.luv2code.springboot.cruddemo.service;

 
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.luv2code.springboot.cruddemo.dao.UserDAO;
 import com.luv2code.springboot.cruddemo.entity.User;

@Service
public class UserService implements IUserServer {
	@Autowired
	UserDAO userDAO ;

	@Override
	@Transactional
	public User editeProfile(int userId) {
		User  user=null;
	 	Optional<User>  result = userDAO.findById(userId);
			 
	 	 if(result.isPresent())
	 			user = result.get();
	 			
			return user ;
	 
	}
	
	
 
}
