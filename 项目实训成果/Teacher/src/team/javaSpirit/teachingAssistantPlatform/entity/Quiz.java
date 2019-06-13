package team.javaSpirit.teachingAssistantPlatform.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="quiz")
public class Quiz {
	private int id;
	private String oldname;
	private String newfile;
	private ClassCourse classcourse;
	private Date uploadtime;
	private String chapter;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOldname() {
		return oldname;
	}
	public void setOldname(String oldname) {
		this.oldname = oldname;
	}
	public String getNewfile() {
		return newfile;
	}
	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}
	@ManyToOne
	@JoinColumn(name="classid")
	public ClassCourse getClasscourse() {
		return classcourse;
	}
	public void setClasscourse(ClassCourse classcourse) {
		this.classcourse = classcourse;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	
}
