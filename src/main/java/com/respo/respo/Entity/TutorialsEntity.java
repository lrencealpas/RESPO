package com.respo.respo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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

    @Lob
    @Column(name = "Content", columnDefinition = "LONGBLOB")
    private byte[] content; // Representing video content as byte array

    @Column(name = "VideoUrl") // Add a new field for video URL
    private String videoUrl;

    @Column(name = "is_deleted")
	private boolean isDeleted = false;

    public TutorialsEntity() {}

    public TutorialsEntity(int videoId, String title, String desc, byte[] content, String videoUrl, boolean isDeleted) {
        this.videoId = videoId;
        this.title = title;
        this.desc = desc;
        this.content = content;
        this.videoUrl = videoUrl;
        this.isDeleted = isDeleted;
    }

    // Getters and setters for all fields

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public boolean getisDeleted(){
		return isDeleted;
	}

	public void setisDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}
}
