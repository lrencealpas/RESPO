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
	private int DeptID;
	@Column(name="DepartmentName")
	private String DeptName;
	@Column(name="Location")
	private String Loc;
	@Column(name="ContactInformation")
	private String pNum;
	
	public LocalDepartmentsEntity() {}

	public LocalDepartmentsEntity(int deptID, String deptName, String loc, String pNum) {
		super();
		DeptID = deptID;
		DeptName = deptName;
		Loc = loc;
		this.pNum = pNum;
	}

	public int getDeptID() {
		return DeptID;
	}

	public void setDeptID(int deptID) {
		DeptID = deptID;
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
}
