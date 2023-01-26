package com.microService.anchor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microService.anchor.entity.CourseEntity;
import com.microService.anchor.entity.StudentEntity;
import com.microService.anchor.repository.AnchorRepositoryCourse;
import com.microService.anchor.repository.AnchorRepositoryStudent;

@Service
public class AnchorServiceImpl implements AnchorService{

	@Autowired
	private AnchorRepositoryStudent anchorRepositoryStudent;
	
	@Autowired
	private AnchorRepositoryCourse anchorRepositoryCourse;
	
	@Override
	public List<StudentEntity> getAllStudents() {
		return anchorRepositoryStudent.findAll();
	}

	@Override
	public StudentEntity getStudentById(int studentId) {
		return anchorRepositoryStudent.findById(studentId).get();
	}

	@Override
	public CourseEntity saveCourseDetails(CourseEntity course) {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity = anchorRepositoryCourse.save(course);
		return courseEntity;
	}

}
