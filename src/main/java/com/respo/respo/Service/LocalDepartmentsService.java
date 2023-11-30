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
	
	//Create
	public LocalDepartmentsEntity insertDepartment(LocalDepartmentsEntity department) {
		return lrepo.save(department);
	}
	
	//Read
	public List<LocalDepartmentsEntity> getAllDepartments() {
		return lrepo.findAll();
	}
	
	//Update
	@SuppressWarnings("finally")
	public LocalDepartmentsEntity updateDepartment(int DeptId, LocalDepartmentsEntity newDepartmentDetails) {
		LocalDepartmentsEntity department = new LocalDepartmentsEntity();
		try {
			//search the id number of the department that will be updated
			department = lrepo.findById(DeptId).get();
					
			//update the record
			department.setDeptName(newDepartmentDetails.getDeptName());
			department.setLoc(newDepartmentDetails.getLoc());
			department.setpNum(newDepartmentDetails.getpNum());
		
					
		} catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Department " + DeptId + " does not exist!");
		} finally {
			return lrepo.save(department);
		}
	}
	
	//Delete
	public String deleteDepartment(int DeptId) {
		String msg = "";
						
		if (lrepo.findById(DeptId) != null) {
			lrepo.deleteById(DeptId);
			msg = "Department " + DeptId + " is successfully deleted!";
		} else 
			msg = "Department " + DeptId + " does not exist!";
			return msg;
	}
}
	
	

