package com.luv2code.springboot.cruddemo.entity;



 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="userplant")
@JsonIdentityInfo(
		   generator = ObjectIdGenerators.IntSequenceGenerator.class 
		  )
public class UserPlant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id ;
	
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="user_ID")
	User user;

@ManyToOne 
@JoinColumn(name="plant_name")	
	Plant plant;


@Column(name="day")
int day;

/*
Format f = new SimpleDateFormat("hh:mm:ss a");
String strResult = f.format(new Date());
*/



@Column(name="time")
String time;

@Column(name="done")
int done;








@Override
public String toString() {
	return "UserPlant [id=" + id + ", user=" + user + ", plant=" + plant + ", day=" + day + ", time=" + time + ", done="
			+ done + "]";
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
@JsonIgnore
public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
@JsonIgnore 
public Plant getPlant() {
	return plant;
}

public void setPlant(Plant plant) {
	this.plant = plant;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public int getDone() {
	return done;
}

public void setDone(int done) {
	this.done = done;
}
	
	
}
