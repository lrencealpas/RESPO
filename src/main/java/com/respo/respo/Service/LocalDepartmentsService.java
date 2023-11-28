package com.respo.respo.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respo.respo.Entity.LocalDepartmentsEntity;
import com.respo.respo.Repository.LocalDepartmentsRepository;

@Service
public class LocalDepartmentsService {

	@Autowired
	LocalDepartmentsRepository lrepo;
	
	public LocalDepartmentsEntity insertUser(LocalDepartmentsEntity user) {
		return lrepo.save(user);
	}
	
	public List<LocalDepartmentsEntity> getAllUsers() {
		return lrepo.findAll();
	}
	
	@SuppressWarnings("finally")
	public LocalDepartmentsEntity updateUser(int DeptId, LocalDepartmentsEntity newUserDetails) {
		LocalDepartmentsEntity user = new LocalDepartmentsEntity();
		try {
			//search the id number of the handset that will be updated
			user = lrepo.findById(DeptId).get();
					
			//update the record
			user.setDeptName(newUserDetails.getDeptName());
			user.setLoc(newUserDetails.getLoc());
			user.setpNum(newUserDetails.getpNum());
		
					
		} catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Department " + DeptId + " does not exist!");
		} finally {
			return lrepo.save(user);
		}
	}
		
		public String deleteUser(int DeptId) {
			String msg = "";
						
			if (lrepo.findById(DeptId) != null) {
				lrepo.deleteById(DeptId);
				msg = "User " + DeptId + " is successfully deleted!";
			} else 
				msg = "User " + DeptId + " does not exist!";
				return msg;
		}
	}
	
	

