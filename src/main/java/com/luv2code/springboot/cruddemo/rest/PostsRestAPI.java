package com.luv2code.springboot.cruddemo.rest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.entity.Post;
import com.luv2code.springboot.cruddemo.entity.User;

@RestController
@RequestMapping("/plant")
public class PostsRestAPI {
	
	
	
	
	@Autowired
	UserDAO userDAO;
	
	
	 
	@GetMapping("/post/{userId}")
	public List<Post> showUsersPosts(@PathVariable int userId) {
			 User user = userDAO.findById(userId).get();
			
			  return user.getPosts() ;
	}

}
