package com.respo.respo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblTutorials")
public class TutorialsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int videoId;
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String desc;
	@Column(name = "Content")
	private String content;
	
	public TutorialsEntity() {}

	public TutorialsEntity(int videoId, String title, String desc, String content) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.desc = desc;
		this.content = content;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
