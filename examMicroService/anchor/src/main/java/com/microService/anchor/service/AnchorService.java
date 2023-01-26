package com.microService.anchor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microService.anchor.entity.CourseEntity;
import com.microService.anchor.entity.StudentEntity;

@Service
public interface AnchorService {

	public List<StudentEntity> getAllStudents();

	public StudentEntity getStudentById(int studentId);

	public CourseEntity saveCourseDetails(CourseEntity course);

}
