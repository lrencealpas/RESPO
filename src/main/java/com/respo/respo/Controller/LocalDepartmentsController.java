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
	
	@PostMapping("/insertUser")
	public LocalDepartmentsEntity insertUser(@RequestBody LocalDepartmentsEntity user) {
		return lserv.insertUser(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<LocalDepartmentsEntity> getAllUsers() {
		return lserv.getAllUsers();
	}
	
	//U - Update a department record
	@PutMapping("/updateUser")
	public LocalDepartmentsEntity updateDepartment(@RequestParam int DeptId, @RequestBody LocalDepartmentsEntity newUserDetails) {
		return lserv.updateUser(DeptId, newUserDetails);
	}
				
	//D - Delete a handset record
	@DeleteMapping("/deleteUser/{DeptId}")
	public String deleteDepartment(@PathVariable int DeptId) {
		return lserv.deleteUser(DeptId);
	}
}
	
	

