package com.microService.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microService.student.entity.CourseEntity;
import com.microService.student.entity.StudentEntity;

@Service
public interface StudentService {

	void saveData(StudentEntity student);

	List<StudentEntity> viewDetails();

	String saveStudentCourseDetail(CourseEntity courseEntity);

}
