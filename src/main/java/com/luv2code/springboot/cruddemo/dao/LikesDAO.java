package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Likes;
@RepositoryRestResource(path = "like")
public interface LikesDAO extends JpaRepository<Likes, Integer> {

}
