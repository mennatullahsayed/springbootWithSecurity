package com.luv2code.springboot.cruddemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
 import javax.persistence.Id;
 import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="plant")
@JsonIdentityInfo(
		   generator = ObjectIdGenerators.IntSequenceGenerator.class 
		  )
public class Plant {

 

	@Id
	@Column(name="plant_name")
	String id;
	
	@Column(name="description")
	String description;


	@OneToMany (mappedBy = "plant" )
	List<UserPlant> userPlants;
	
	
	@JsonIgnore
	public List<UserPlant> getUserPlants() {
		return userPlants;
	}

	public void setUserPlants(List<UserPlant> userPlants) {
		this.userPlants = userPlants;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Plant [id=" + id + ", description=" + description + "]";
	}

	public Plant() {
		 
	}

	public Plant(String id) {
		  
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
