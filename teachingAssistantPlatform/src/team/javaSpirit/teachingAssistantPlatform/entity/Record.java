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
 * <p>Title:请假</p>
 * <p>content:请假类对应record表</p>
 * @author 张鼎
 *@date 2018年12月10日
 */
/*
 * 签到表
 */
@Entity
@Table(name="record")
public class Record {
	private int id;
	private Students sid;//学生学号
	private int state;//签到状态
	private Date record_date;//签到时间
	private ClassCourse class_id;//上课班级号
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="sid")
	public Students getSid() {
		return sid;
	}
	public void setSid(Students sid) {
		this.sid = sid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}
	@ManyToOne
	@JoinColumn(name="class_id")
	public ClassCourse getClass_id() {
		return class_id;
	}
	public void setClass_id(ClassCourse class_id) {
		this.class_id = class_id;
	}
}
