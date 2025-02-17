package com.sathya.springMVC3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sathya.springMVC3.Model.StudentModel;


@org.springframework.stereotype.Controller
public class Controller
{
	@Autowired
	Service service;
	@GetMapping("/studentform")
	public String getStudentForm() {
		return "Student-List";
	}
	@PostMapping("/savestudentform")
	public String saveStudentDetails(StudentModel studentModel)
	{
		service. saveStudentDetailsForm(studentModel);
		
		return "Success";
	}
	
	

}
