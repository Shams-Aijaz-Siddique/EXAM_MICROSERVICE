package com.microService.anchor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microService.anchor.entity.CourseEntity;
import com.microService.anchor.entity.StudentEntity;

public interface AnchorRepositoryStudent extends JpaRepository<StudentEntity, Integer>{

	List<StudentEntity> findAll();
}
