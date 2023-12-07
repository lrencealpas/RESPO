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

import com.respo.respo.Entity.RespoEntity;
import com.respo.respo.Service.RespoService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = ("http://localhost:3000"))
public class RespoController {
	
	@Autowired
	RespoService rserv;
	
	@GetMapping("/print")
	public String itWorks() {
		return "It works";
	}
	
	//Create
	@PostMapping("/insertUser")
	public RespoEntity insertUser(@RequestBody RespoEntity user) {
		return rserv.insertUser(user);
	}
	
	//Read
	@GetMapping("/getAllUsers")
	public List<RespoEntity> getAllUsers() {
		return rserv.getAllUsers();
	}
	
	//U - Update a user record
	@PutMapping("/updateUser")
	public RespoEntity updateUser(@RequestParam int userId, @RequestBody RespoEntity newUserDetails) {
		return rserv.updateUser(userId, newUserDetails);
	}
				
	//D - Delete a user record
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return rserv.deleteUser(userId);
	}
}
