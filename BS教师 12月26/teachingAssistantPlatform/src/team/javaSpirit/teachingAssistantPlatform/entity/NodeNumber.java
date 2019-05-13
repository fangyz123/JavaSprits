package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Title:上课节数
 * </p>
 * <p>
 * content:上课节数类对应nodeNumber表
 * </p>
 * 
 * @author 张鼎
 * @date 2018年12月10日
 */
/*
 * 节数类
 */
@Entity
@Table(name = "nodenumber")
public class NodeNumber {
	private int node_id;// 序列号
	private String node;// 节数
	private String start_time;// 节数开始时间
	private String end_time;// 节数结束时间
	private int sign_range;// 签到时间差值

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getSign_range() {
		return sign_range;
	}

	public void setSign_range(int sign_range) {
		this.sign_range = sign_range;
	}
}
