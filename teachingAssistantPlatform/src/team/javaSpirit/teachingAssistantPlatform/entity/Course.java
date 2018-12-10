package team.javaSpirit.teachingAssistantPlatform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * <p>Title:课程</p>
 * <p>content:课程类对应course表</p>
 * @author 张鼎
 *@date 2018年12月10日
 */
/*
 * 课程表
 */
@Entity
@Table(name="course")
public class Course {
	private int course_id;//课程号
	private String cname;//课程名
	private Set<ClassCourse> classCourses = new HashSet<ClassCourse> (0);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@OneToMany(
			mappedBy="course",
			cascade= {CascadeType.ALL}
			)
	public Set<ClassCourse> getClassCourses() {
		return classCourses;
	}
	public void setClassCourses(Set<ClassCourse> classCourses) {
		this.classCourses = classCourses;
	}
}
