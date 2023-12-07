package com.respo.respo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblDepartments")
public class LocalDepartmentsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DeptId;

	@Column(name= " DepartmentName")
	private String DeptName;

	@Column(name = "Location")
	private String Loc;

	@Column(name = "ContactInformation")
	private String pNum;

	@Column(name = "is_deleted")
	private boolean isDeleted = false;
	
	public LocalDepartmentsEntity() {}

	public LocalDepartmentsEntity(int deptId, String deptName, String loc, String pNum, boolean isDeleted) {
		super();
		DeptId = deptId;
		DeptName = deptName;
		Loc = loc;
		this.pNum = pNum;
		this.isDeleted = isDeleted;
	}

	public int getDeptID() {
		return DeptId;
	}

	public void setDeptID(int deptID) {
		DeptId = deptID;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getLoc() {
		return Loc;
	}

	public void setLoc(String loc) {
		Loc = loc;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public boolean getisDeleted(){
		return isDeleted;
	}

	public void setisDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}
}
