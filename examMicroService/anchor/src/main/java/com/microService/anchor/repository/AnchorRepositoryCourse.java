package com.microService.anchor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microService.anchor.entity.CourseEntity;

public interface AnchorRepositoryCourse extends JpaRepository<CourseEntity, Integer>{
	
}