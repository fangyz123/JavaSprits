package com.ryy.ui.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
* <p>Title: LoadStudent</p>
* <p>Description: 学生登录表对应loadStudent</p>
* @author renyuyuan
* @date 2018年12月10日
 */
@Entity
@Table(name="loadStudent")
public class LoadStudent {
	private int id;//序列号
	private Date login_time;//登录时间
	private Students student;//学号
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}
	@ManyToOne
	@JoinColumn(name="sid")
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
}
