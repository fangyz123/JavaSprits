package team.javaSpirit.teachingAssistantPlatform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * <p>Title:学生</p>
 * <p>content:学生类对应students表</p>
 * @author 郭程媛
 *@date 2018年12月10日
 */
/*
 * 学生类
 * 对应
 * 学生表
 */
@Entity
@Table(name="students")
public class Students {
	private String sid;//学号
	private String password;//密码
	private int state;//是否可用
	private String name;//学生姓名
	private  ClassAdministration c_a_id;//行政班级号
	private String ip;//学生ip
	private Set<LeavePaper> leavePapers = new HashSet<LeavePaper>();
	private Set<LoadStudent> loadStudents = new HashSet<LoadStudent>();
	private Set<StudentClass> studentClasses = new HashSet<StudentClass>();
	private Set<Record> records = new HashSet<Record>();
	@Id
	@GenericGenerator(name="myincrement",strategy="increment")
	@GeneratedValue(generator="myincrement")
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	@JoinColumn(name="c_a_id")
	public ClassAdministration getC_a_id() {
		return c_a_id;
	}
	public void setC_a_id(ClassAdministration c_a_id) {
		this.c_a_id = c_a_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@OneToMany(
			mappedBy="sid",
			cascade= {CascadeType.ALL}
			)
	public Set<LeavePaper> getLeavePapers() {
		return leavePapers;
	}
	public void setLeavePapers(Set<LeavePaper> leavePapers) {
		this.leavePapers = leavePapers;
	}
	@OneToMany(
			mappedBy="sid",
			cascade= {CascadeType.ALL}
			)
	public Set<LoadStudent> getLoadStudents() {
		return loadStudents;
	}
	public void setLoadStudents(Set<LoadStudent> loadStudents) {
		this.loadStudents = loadStudents;
	}
	@OneToMany(
			mappedBy="sid",
			cascade= {CascadeType.ALL}
			)
	public Set<StudentClass> getStudentClasses() {
		return studentClasses;
	}
	public void setStudentClasses(Set<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}
	@OneToMany(
			mappedBy="sid",
			cascade= {CascadeType.ALL}
			)
	public Set<Record> getRecords() {
		return records;
	}
	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	
}
