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
 * Title:学生登陆
 * </p>
 * <p>
 * content:学生登录类对应loadStudent表
 * </p>
 * 
 * @author 郭程媛
 * @date 2018年12月10日
 */
/*
 * 学上登录类 对应 学上登录表
 */
@Entity
@Table(name = "loadstudent")
public class LoadStudent {
	private int id;// 序列号
	private Date login_time;// 登录时间
	private Students student;// 学号

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
	@JoinColumn(name = "sid")
	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
}
