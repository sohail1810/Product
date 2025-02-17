package com.sathya.springMVC3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.sathya.springMVC3.Entity.StudentEntity;
import com.sathya.springMVC3.Model.StudentModel;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@org.springframework.stereotype.Service

@Getter
public class Service 
{
	@Autowired
	Repository repository;
	public void saveStudentDetailsForm(StudentModel studentModel)
	{
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setDept(studentModel.getDept());
		studentEntity.setName(studentModel.getName());
		studentEntity.setGender(studentModel.getGender());
		studentEntity.setAge(studentModel.getAge());
		studentEntity.setSchool(studentModel.getSchool());
		repository.save(studentEntity);
	}
	

}
