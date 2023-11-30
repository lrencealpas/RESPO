package com.respo.respo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.respo.respo.Entity.LocalDepartmentsEntity;
import com.respo.respo.Service.LocalDepartmentsService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = ("http://localhost:3000"))
public class LocalDepartmentsController {
	
	@Autowired
	LocalDepartmentsService lserv;
	
	@GetMapping("/print")
	public String itWorks() {
		return "It works";
	}
	
	@PostMapping("/insertDepartment")
	public LocalDepartmentsEntity insertDepartment(@RequestBody LocalDepartmentsEntity user) {
		return lserv.insertDepartment(user);
	}
	
	@GetMapping("/getAllDepartments")
	public List<LocalDepartmentsEntity> getAllDepartment() {
		return lserv.getAllDepartments();
	}
	
	//U - Update a department record
	@PutMapping("/updateDepartment")
	public LocalDepartmentsEntity updateDepartment(@RequestParam int DeptId, @RequestBody LocalDepartmentsEntity newDepartmentDetails) {
		return lserv.updateDepartment(DeptId, newDepartmentDetails);
	}
				
	//D - Delete a handset record
	@DeleteMapping("/deleteDepartment/{DeptId}")
	public String deleteDepartment(@PathVariable int DeptId) {
		return lserv.deleteDepartment(DeptId);
	}
}
	
	

