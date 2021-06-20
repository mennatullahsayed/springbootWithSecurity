package com.luv2code.springboot.cruddemo.rest;



import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.GallaryDAO;
import com.luv2code.springboot.cruddemo.entity.Gallary;

@RestController
@RequestMapping("/plant")
public class GallaryRestAPI {
	
	@Autowired
	GallaryDAO gallaryDao;
	
	@Autowired
	EntityManager entityManager;
	
	
	@GetMapping("/gallary/{plantId}")
	public Gallary showPlantInGallary(@PathVariable int plantId) {
		// plantId=1;
	return  gallaryDao.findById(plantId).get();	
		
	}

	@GetMapping("/gallary")
	public List<Gallary> showAllGallary() {
		
	
	return  gallaryDao.findAll();	
		
	}
	
	
}
