package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Title:行政班
 * </p>
 * <p>
 * content:行政班类对应classAdministration表
 * </p>
 * 
 * @author 郭程媛
 * @date 2018年12月10日
 */
/*
 * 行政班
 * 
 */
@Entity
@Table(name = "classadministration")
public class ClassAdministration {
	private int c_a_id;// 流水号
	private String name;// 班名

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getC_a_id() {
		return c_a_id;
	}

	public void setC_a_id(int c_a_id) {
		this.c_a_id = c_a_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
