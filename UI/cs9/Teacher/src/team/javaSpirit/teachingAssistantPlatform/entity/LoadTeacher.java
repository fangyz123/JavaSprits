package team.javaSpirit.teachingAssistantPlatform.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>
 * Title:上教师登陆
 * </p>
 * <p>
 * content:教师登录类对应loadTeacher表
 * </p>
 * 
 * @author 张鼎
 * @date 2018年12月10日
 */
/*
 * 教师登录类
 */
@Entity
@Table(name = "loadteacher")
public class LoadTeacher {
	private int id;// 流水号
	private Date login_time;// 登录时间
	private Teacher teacher;// 教师

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JoinColumn(name = "tid")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
