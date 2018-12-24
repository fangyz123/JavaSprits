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
@Table(name="shareresource")
public class ShareResource {
	private Integer id;
	private String oldfile;
	private String newfile;
	private Students stu;
	private Date uploadtime;
	private Teacher teacher;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOldfile() {
		return oldfile;
	}
	public void setOldfile(String oldfile) {
		this.oldfile = oldfile;
	}
	public String getNewfile() {
		return newfile;
	}
	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}
	@ManyToOne
	@JoinColumn(name="sid")
	public Students getStu() {
		return stu;
	}
	public void setStu(Students stu) {
		this.stu = stu;
	}
	@ManyToOne
	@JoinColumn(name="tid")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
}
