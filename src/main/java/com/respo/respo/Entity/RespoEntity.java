package com.respo.respo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblUsers")
public class RespoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "fName")
	private String fName;

	@Column(name = "lName")
	private String lName;

	@Column(name = "pNum")
	private String pNum;

	@Column(name = "gender")
	private String gender;

	@Column(name = "eMail")
	private String eMail;

	@Column(name = "pWord")
	private String pWord;

	@Column(name = "is_admin")
    private boolean isAdmin;

	@Column(name = "is_deleted")
	private boolean isDeleted = false;
	
	public RespoEntity() {}

	public RespoEntity(int userId, String fName, String lName, String pNum, String gender, String eMail, String pWord, boolean isAdmin, boolean isDeleted) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.pNum = pNum;
		this.gender = gender;
		this.eMail = eMail;
		this.pWord = pWord;
		this.isAdmin = isAdmin;
		this.isDeleted = isDeleted;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public boolean getisAdmin(){
		return isAdmin;
	}

	public void setisAdmin(boolean isAdmin){
		this.isAdmin = isAdmin;
	}

	public boolean getisDeleted(){
		return isDeleted;
	}

	public void setisDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}
}
