package com.ryy.ui.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="teacher")
public class Teacher {
	private String tid;//教工号
	private String password;//密码
	private int state;//是否可用
	private String tname;//教师名字
	private String ip;//ip
	private Set<LoadTeacher> teachers = new HashSet<LoadTeacher> (0);
	@Id
	@GeneratedValue(generator="tid")
	@GenericGenerator(name="tid",strategy="assigned")
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
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
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@OneToMany(
			mappedBy="teacher",
			cascade= {CascadeType.ALL}
			)
	public Set<LoadTeacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<LoadTeacher> teachers) {
		this.teachers = teachers;
	}
}
