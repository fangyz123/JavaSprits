package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>
 * Title:上课时间
 * </p>
 * <p>
 * content:上课时间类对应times表
 * </p>
 * 
 * @author 张鼎
 * @date 2018年12月10日
 */
/*
 * 上课时间表
 */
@Entity
@Table(name = "times")
public class Times {
	private int id;// 流水号
	private String c_week;// 上课周数
	private String c_date;// 上课日期
	private NodeNumber nodeNumber;// 上课节数
	private ClassCourse classin;// 课程班级

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_week() {
		return c_week;
	}

	public void setC_week(String c_week) {
		this.c_week = c_week;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	@ManyToOne
	@JoinColumn(name = "node_id")
	public NodeNumber getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(NodeNumber nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	@ManyToOne
	@JoinColumn(name = "class_id")
	public ClassCourse getClassin() {
		return classin;
	}

	public void setClassin(ClassCourse classin) {
		this.classin = classin;
	}

}
