package com.microService.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microService.course.entity.CourseEntity;
import com.microService.course.service.CourseService;


@RestController
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/saveCourseDetails")
	public ResponseEntity<CourseEntity> saveCourseDetails(@RequestBody CourseEntity course) {
		return courseService.saveCourseDetails(course);
	}
}
