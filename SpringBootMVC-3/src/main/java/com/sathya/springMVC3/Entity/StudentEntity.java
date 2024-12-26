package com.sathya.springMVC3.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String dept;
	private String gender;
	private int age;
	private String school;
	

}
