package com.microService.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microService.student.entity.CourseEntity;
import com.microService.student.entity.StudentEntity;
import com.microService.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Value("${spring.application.url.getAllStudent}")
	String getAllStudents;
	
	@Value("${spring.application.url.getStudentById}")
	String getStudentById;
	
	@Value("${spring.application.url.saveStudentCourseDetail}")
	String saveStudentCourseDetail;
	
	RestTemplate restTemplate = new RestTemplate();

	
	@Override
	public void saveData(StudentEntity student) {
		studentRepository.save(student);
		
	}
	@Override
	public List<StudentEntity> viewDetails() {
		ResponseEntity<StudentEntity[]> responseEntityStudentList = restTemplate.getForEntity(getAllStudents, StudentEntity[].class);
		StudentEntity students[] = responseEntityStudentList.getBody();
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		for(StudentEntity student : students) {
			studentList.add(student);
		}
		return studentList;
	}
	@Override
	public String saveStudentCourseDetail(CourseEntity courseEntity) {
		
		//Fetch Student details
		StudentEntity studentEntity = new StudentEntity();
		ResponseEntity<StudentEntity> responseEntityStudent = restTemplate.getForEntity(getStudentById+courseEntity.getStudentId(), StudentEntity.class);
		studentEntity = responseEntityStudent.getBody();
		
		courseEntity.setStudentEmail(studentEntity.getStudentEmail());
		courseEntity.setStudentName(studentEntity.getStudentName());
		
		//save Course Details
		ResponseEntity<CourseEntity> responseCourseEntity = restTemplate.postForEntity(saveStudentCourseDetail, courseEntity, CourseEntity.class);
		if(responseCourseEntity.getBody().getCourseId() != null) {
			return "success";
		}
		
		return "failure";
	}

}
