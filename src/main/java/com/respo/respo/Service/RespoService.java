package com.respo.respo.Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respo.respo.Entity.RespoEntity;
import com.respo.respo.Repository.RespoRepository;

@Service
public class RespoService {

	@Autowired
	RespoRepository rrepo;
	
	//Create or insert user record in tblUsers
	public RespoEntity insertUser(RespoEntity user) {
		return rrepo.save(user);
	}
	
	//Read all records in tblUsers
	public List<RespoEntity> getAllUsers() {
		return rrepo.findAll();
	}
	
	//U - update a user
	@SuppressWarnings("finally")
	public RespoEntity updateUser(int userId, RespoEntity newUserDetails) {
		RespoEntity user = new RespoEntity();
		try {
			//search the id number of the handset that will be updated
			user = rrepo.findById(userId).get();
					
			//update the record
			user.setfName(newUserDetails.getfName());
			user.setlName(newUserDetails.getlName());
			user.setpNum(newUserDetails.getpNum());
			user.setGender(newUserDetails.getGender());
			user.seteMail(newUserDetails.geteMail());
			user.setpWord(newUserDetails.getpWord());
					
		} catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Handset " + userId + " does not exist!");
		} finally {
			return rrepo.save(user);
		}
	}
	
	//D - delete a user
	public String deleteUser(int userId) {
		String msg = "";
					
		if (rrepo.findById(userId) != null) {
			rrepo.deleteById(userId);
			msg = "User " + userId + " is successfully deleted!";
		} else 
			msg = "User " + userId + " does not exist!";
			return msg;
	}
}
