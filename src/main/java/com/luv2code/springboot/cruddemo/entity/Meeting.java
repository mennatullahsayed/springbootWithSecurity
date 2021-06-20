package com.luv2code.springboot.cruddemo.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="meeting")
public class Meeting {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id ;
	
	@Column(name ="expert_ID")
	String expert_ID;
	
	@Column(name ="link")
	String link;
	
	@Column(name ="time")
	LocalDateTime time;
	
	
	
	public Meeting() {
		
	}

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH} )
	@JoinColumn(name="user_ID")
	User   userId;
	
	
	public Meeting(String expert_ID, String link, LocalDateTime time) {
		this.expert_ID = expert_ID;
		this.link = link;
		this.time = time;
	}
    
	@JsonIgnore
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpert_ID() {
		return expert_ID;
	}

	public void setExpert_ID(String expert_ID) {
		this.expert_ID = expert_ID;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Metting [id=" + id + ", expert_ID=" + expert_ID + ", link=" + link + ", time=" + time + "]";
	}
	

}
