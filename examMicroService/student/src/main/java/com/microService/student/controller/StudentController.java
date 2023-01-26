package com.microService.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microService.student.entity.CourseEntity;
import com.microService.student.entity.StudentEntity;
import com.microService.student.service.StudentService;

@Controller
@RequestMapping("/studentWeb")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		return "add";
	}
	
	@RequestMapping("/saveStudentData")
	public String saveData(@ModelAttribute StudentEntity student, Model model) {
		String name = student.getStudentName();
		String email = student.getStudentEmail();
		if(name == null || name.isBlank() || name.isEmpty() ||
	       email == null || email.isBlank() || email.isEmpty()) {
			model.addAttribute("msg","emptyFiled");
		}else {
			studentService.saveData(student);
			model.addAttribute("msg", "success");
		}
//		return "redirect:/studentWeb/";
		return "add";
	}
	
	@RequestMapping("/viewDetails")
	public String viewDetails(Model model) {
		List<StudentEntity> studentList = new ArrayList<StudentEntity>();
		studentList=studentService.viewDetails();
		model.addAttribute("details", studentList);
		return "view";
	}

	@RequestMapping("/saveStudentCourseDetail")
	public String saveStudentCourseDetail(@ModelAttribute CourseEntity courseEntity, Model model) {

			String msg = studentService.saveStudentCourseDetail(courseEntity);
			model.addAttribute("msg",msg);
			
			List<StudentEntity> studentList = new ArrayList<StudentEntity>();
			studentList=studentService.viewDetails();
			model.addAttribute("details", studentList);
		
		return "view";
	}
}
