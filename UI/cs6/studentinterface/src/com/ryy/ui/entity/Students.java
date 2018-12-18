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
@Table(name="students")
public class Students {
	private String sid;
	private String password;
	private int state;
	private String name;
	private Integer c_a_id;
	private String ip;
	private Set<LoadStudent> loadStudents = new HashSet<LoadStudent>();
	@Id
	@GeneratedValue(generator="sid")
	@GenericGenerator(name="sid",strategy="assigned")
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
	public Integer getC_a_id() {
		return c_a_id;
	}
	public void setC_a_id(Integer c_a_id) {
		this.c_a_id = c_a_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@OneToMany(
			mappedBy="student",
			cascade= {CascadeType.ALL}
			)
	public Set<LoadStudent> getLoadStudents() {
		return loadStudents;
	}
	public void setLoadStudents(Set<LoadStudent> loadStudents) {
		this.loadStudents = loadStudents;
	}
}
