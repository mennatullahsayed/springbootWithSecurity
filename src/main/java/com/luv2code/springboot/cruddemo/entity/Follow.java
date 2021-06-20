package com.luv2code.springboot.cruddemo.entity;

import java.time.LocalDateTime;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.Table;
@Entity
@Table(name="followers")
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int FollowerId;

 

	@Column(name="createAt")
	LocalDateTime createdAt;
 
	public int getFollowerId() {
		return FollowerId;
	}


	@Override
	public String toString() {
		return "Follow [ ,    created_At="
				+ createdAt + "]";
	}


	public void setFollowerId(int followerId) {
		FollowerId = followerId;
	}
 


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
 
	public Follow() {
	}
	
	
}
