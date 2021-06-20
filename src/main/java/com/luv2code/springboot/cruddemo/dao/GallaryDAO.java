package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Gallary;
@RepositoryRestResource(path = "gallary")
public interface GallaryDAO extends JpaRepository<Gallary, Integer> {

}
