package com.luv2code.springboot.cruddemo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.MeetingDAO;
import com.luv2code.springboot.cruddemo.dao.PostsDAO;
import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.entity.Meeting;
import com.luv2code.springboot.cruddemo.entity.Post;
import com.luv2code.springboot.cruddemo.entity.User;
import com.luv2code.springboot.cruddemo.entity.UserPlant;
import com.luv2code.springboot.cruddemo.service.IUserServer;
 
@RestController
@RequestMapping("/plant")
public class usersRestAPI {
 @Autowired
	IUserServer iUserServer;
	
	
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	UserDAO userDAO;

	@Autowired
	MeetingDAO meetingDAO;
	
	

	@Autowired
	PostsDAO postsDAO; 
	
	
	
	@GetMapping("/meeting/{userId}")
	public List<Meeting> showUsersMeeting(@PathVariable int userId) {
	try {
		User user = userDAO.findById(userId).get();
		return user.getMeetings();
	} catch (Exception e) {
		return null;
	}
		
	}

	@GetMapping("/user")
	public List<User> showAllUsers() {
		List<User> userList = userDAO.findAll();
		return userList;
	}

	@GetMapping("/profile/{userId}")
	public User editeProfile(@PathVariable int userId) {
		 
		return  iUserServer.editeProfile(userId);
	}
	
	
    //نتاكد ان الاكسبرت ده اكسبرت اصلا وال ID بتاعه موجود 
	@PostMapping("/apponitment/{userId}")
	public int bookMeeting(@PathVariable int userId, @RequestBody Meeting meeting) {
		try {
			User user = userDAO.findById(userId).get();
			user.addMeeting(meeting);
			userDAO.save(user);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	 //نتاكد ان الاكسبرت ده اكسبرت اصلا وال ID بتاعه موجود 
		@PostMapping("/adduser")
		public int adduser(@RequestBody User usre) {
			try {
				userDAO.save(usre);
				return 1;
			} catch (Exception e) {
				return 0;
			}

		}
	
	
	
	
	
	
	//500 bsd request 
	@GetMapping("/profile/posts/{userId}")
	public List<Post> showMyPosts(@PathVariable int userId) {
		try {
			 
		User user = userDAO.findById(userId).get();
		
		return user.getPosts();
		} catch (Exception e) {
			return new ArrayList<Post>();
		}

	}

	
	
	@GetMapping("/myplant/{userId}")
	public Set<UserPlant> myPlants(@PathVariable int userId) {
	 	try {
			 
		User user = userDAO.findById(userId).get();
 

		return user.getUserPlants();
	 	} catch (Exception e) {
			 return null;
			
	 	}
	}	
	
	
	
	
	
	@GetMapping("/follow/{userId}/{followed}")
	public  int follow(@PathVariable int userId,@PathVariable int followed) {
		try {
		User user =userDAO.findById(userId).get();
		User userFollower =userDAO.findById(followed).get();	
	 user.getFriends().add(user);
	 user.getFriends().add(userFollower);
		 userDAO.save(user);
		return 1;
		 } catch (Exception e) {
		return 0;
			
		}

	}	
	
	
	
	//TODO here

	@GetMapping("/followers/{userId}")
	public  int followers(@PathVariable int userId) {
		try {
		User user =userDAO.findById(userId).get();
		List<User> userList= user.getFriends();
		return userList.size();
		 } catch (Exception e) {
		return 0;
			
		}
 
	}	
	
	
	@GetMapping("/following/{userId}")
	public  int following(@PathVariable int userId) {
	 
		return -1;
			 
	}	
	
	
	
	
	//500 bsd request 
	@GetMapping("/posts/{userId}")
	public List<User> Posts(@PathVariable int userId) {
		try {
	
			 User user = userDAO.findById(userId).get();
			 return user.getFriends();
		} catch (Exception e) {
			return null;
		}

	}
	
 }
