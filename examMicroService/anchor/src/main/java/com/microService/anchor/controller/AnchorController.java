package com.microService.anchor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microService.anchor.entity.CourseEntity;
import com.microService.anchor.entity.StudentEntity;
import com.microService.anchor.service.AnchorService;

@RestController
@RequestMapping("/Anchor")
public class AnchorController {
	
	@Autowired
	private AnchorService anchorService;
	
	@RequestMapping("/getAllStudents")
	public List<StudentEntity> getAllStudents(){
		return anchorService.getAllStudents();
	}

	@RequestMapping("/getStudentById/{studentId}")
	public StudentEntity getStudentById(@PathVariable Integer studentId){
		return anchorService.getStudentById(studentId);
	}
	
	@RequestMapping("/saveCourseDetails")
	public CourseEntity saveCourseDetails(@RequestBody CourseEntity course) {
		return anchorService.saveCourseDetails(course);
	}
}
