package com.sathya.springMVC2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springMVC2.EmpEntity.EmpEntity;
import com.sathya.springMVC2.EmpModel.EmpModel;
import com.sathya.springMVC2.Service.EmpService;
import org.springframework.web.bind.annotation.PostMapping;



@org.springframework.stereotype.Controller
public class Controller
{
	@Autowired
	EmpService empService;
	private Long empId;
	@GetMapping("/employeeform")
	public String getEmployeeform() 
	{
		return "add-Emp";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmpDetails(EmpModel empModel) {
		//TODO: process POST request
		empService.saveEmpDetails( empModel) ;
		
		return "Success" ;
	}
	@GetMapping("/getallEmployees")
	public String getAllEmployeeDetails(Model model) {
		List<EmpEntity> employees=empService.getAllEmployeeDetails();
		model.addAttribute("employees", employees);
		return "Employee-list";
	}
	@GetMapping("/getsearchform")
	public String searchById() {
		return "Search-Emp";
	}
	@PostMapping("/searchbyempid")
	public String searchEmpById(@RequestParam Long empId, Model model)
	{
		EmpEntity emp=empService.searchEmpById(empId);
		model.addAttribute("emp", emp);
		
		return "Search-Emp";
	}
	@GetMapping("/delete/{empId}")
	public String deleteByEmpId(@PathVariable("empId") Long empId) 
	{
		empService.deleteByEmpId(empId);
		return "redirect:/getallEmployees";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
