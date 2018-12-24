package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>
 * Title:学生
 * </p>
 * <p>
 * content:学生类对应students表
 * </p>
 * 
 * @author 郭程媛
 * @date 2018年12月10日
 */
/*
 * 学生类 对应 学生表
 */
@Entity
@Table(name = "students")
public class Students {
	/* 学号 */
	private String sid;
	/* 密码 */
	private String password;
	/* 是否在校 */
	private int state;
	/* 学生姓名 */
	private String name;
	/* 行政班级 */
	private ClassAdministration classAdministrantion;
	/* 学生ip */
	private String ip;

	@Id
	@GenericGenerator(name = "myincrement", strategy = "assigned")
	@GeneratedValue(generator = "myincrement")
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

	@ManyToOne
	@JoinColumn(name = "c_a_id")
	public ClassAdministration getClassAdministrantion() {
		return classAdministrantion;
	}

	public void setClassAdministrantion(ClassAdministration classAdministrantion) {
		this.classAdministrantion = classAdministrantion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
