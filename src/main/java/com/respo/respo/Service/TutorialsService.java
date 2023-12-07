package com.respo.respo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respo.respo.Entity.TutorialsEntity;
import com.respo.respo.Repository.TutorialsRepository;

@Service
public class TutorialsService {

	@Autowired
	TutorialsRepository trepo;
	
	//Create or insert user record in tblTutorials
	public TutorialsEntity insertTutorial(TutorialsEntity tutorial) {
		return trepo.save(tutorial);
	}
		
	//Read all records in tblUsers
	public List<TutorialsEntity> getAllTutorials() {
		return trepo.findAll();
	}
	
	//U - update a tutorials
	@SuppressWarnings("finally")
	public TutorialsEntity updateTutorial(int videoId, TutorialsEntity newTutorialDetails) {
		TutorialsEntity tutorial = new TutorialsEntity();
		try {
			//search the id number of the tutorial that will be updated
			tutorial = trepo.findById(videoId).get();
						
			//update the record
			tutorial.setTitle(newTutorialDetails.getTitle());
			tutorial.setDesc(newTutorialDetails.getDesc());
			tutorial.setContent(newTutorialDetails.getContent());
						
		} catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Tutorial " + videoId + " does not exist!");
		} finally {
			return trepo.save(tutorial);
		}
	}
	
	//D - delete a tutorial
	public String deleteTutorial(int videoId) {
		TutorialsEntity tutorial = trepo.findById(videoId)
			.orElseThrow(() -> new NoSuchElementException("Tutorial " + videoId + "does not exist"));

		if (tutorial.getisDeleted()) {
			return "Tutorial #" + videoId + " is already deleted!";
		} else {
			tutorial.setisDeleted(true);
			trepo.save(tutorial);
			return "Tutorial #" + videoId + "has been deleted";
		}
	}
}
