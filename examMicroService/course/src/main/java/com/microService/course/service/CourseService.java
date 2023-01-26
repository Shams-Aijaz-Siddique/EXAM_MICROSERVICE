package com.microService.course.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microService.course.entity.CourseEntity;

@Service
public interface CourseService {

	ResponseEntity<CourseEntity> saveCourseDetails(CourseEntity course);

}
