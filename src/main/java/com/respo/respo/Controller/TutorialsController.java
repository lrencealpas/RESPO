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

import com.respo.respo.Entity.TutorialsEntity;
import com.respo.respo.Service.TutorialsService;

@RestController
@RequestMapping("/tutorial")
@CrossOrigin(origins = ("http://localhost:3000"))
public class TutorialsController {

	@Autowired
	TutorialsService tserv;
	
	@GetMapping("/print")
	public String itWorks() {
		return "It works";
	}
	
	//Create
	@PostMapping("/insertTutorial")
	public TutorialsEntity inserTutorial(@RequestBody TutorialsEntity tutorial) {
		return tserv.insertTutorial(tutorial);
	}
	
	//Read
	@GetMapping("/getAllTutorials")
	public List<TutorialsEntity> getAllTutorials() {
		return tserv.getAllTutorials();
	}
	
	//U - Update a tutorial record
	@PutMapping("/updateUser")
	public TutorialsEntity updateTutorial(@RequestParam int videoId, @RequestBody TutorialsEntity newTutorialDetails) {
		return tserv.updateTutorial(videoId, newTutorialDetails);
	}
					
	//D - Delete a tutorial record
	@DeleteMapping("/deleteTutorial/{videoId}")
	public String deleteTutorial(@PathVariable int videoId) {
		return tserv.deleteTutorial(videoId);
	}
}
