package com.microService.course.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microService.course.entity.CourseEntity;

@Service
public class CourseInterfaceImpl implements CourseService{

	@Value("${spring.application.url.saveStudentCourseDetail}")
	String saveStudentCourseDetail;
	
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public ResponseEntity<CourseEntity> saveCourseDetails(CourseEntity course) {
		//save Course Details
		ResponseEntity<CourseEntity> responseCourseEntity = restTemplate.postForEntity(saveStudentCourseDetail, course, CourseEntity.class);
		//CourseEntity courseEntity = responseCourseEntity.getBody();
		return responseCourseEntity;
	}

}
