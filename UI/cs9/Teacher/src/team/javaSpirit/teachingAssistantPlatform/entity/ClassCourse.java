package team.javaSpirit.teachingAssistantPlatform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <p>
 * Title:上课班级
 * </p>
 * <p>
 * content:上课班级类对应classCourse表
 * </p>
 * 
 * @author 张鼎
 * @date 2018年12月10日
 */
/*
 * 上课班级
 */
@Entity
@Table(name = "classcourse")
public class ClassCourse {
	private int class_id;// 上课班级号
	private String class_name;// 班级名字
	private Teacher teacher;// 任课老师
	private Course course;// 课程
	/*学生班级*/
	private Set<StudentClass> studentClasses = new HashSet<StudentClass>(0);
	/* 上课时间 */
	private Set<Times> times = new HashSet<Times>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	@ManyToOne
	@JoinColumn(name = "tid")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@OneToMany(mappedBy = "classin", cascade = { CascadeType.ALL })
	public Set<StudentClass> getStudentClasses() {
		return studentClasses;
	}

	public void setStudentClasses(Set<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}

	@OneToMany(mappedBy = "classin", cascade = { CascadeType.ALL })
	public Set<Times> getTimes() {
		return times;
	}

	public void setTimes(Set<Times> times) {
		this.times = times;
	}

}
