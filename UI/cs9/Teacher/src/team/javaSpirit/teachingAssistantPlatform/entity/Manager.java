package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>
 * Title:管理员班级
 * </p>
 * <p>
 * content:管理员类对应manager表
 * </p>
 * 
 * @author 张鼎
 * @date 2018年12月10日
 */
/*
 * 管理员
 */
@Entity
@Table(name = "manager")
public class Manager {
	private String m_id;
	private String password;

	@Id
	@GenericGenerator(name = "myincrement", strategy = "assigned")
	@GeneratedValue(generator = "myincrement")
	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
