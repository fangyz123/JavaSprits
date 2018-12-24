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
* <p>Title: LoadTeacher</p>
* <p>Description:老师登录表 </p>
* @author renyuyuan
* @date 2018年12月13日
 */
@Entity
@Table(name="loadteacher")
public class LoadTeacher {
	private int id;//流水号
	private Date login_time;//登录时间
	private Teacher teacher;//教师
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
	@JoinColumn(name="tid")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
