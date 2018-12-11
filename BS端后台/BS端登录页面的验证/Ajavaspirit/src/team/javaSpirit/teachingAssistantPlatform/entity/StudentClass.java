package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * <p>Title:学生班级</p>
 * <p>content:学生班级对应studentClass表</p>
 * @author 郭程媛
 *@date 2018年12月10日
 */
@Entity
@Table(name="studentClass")
public class StudentClass {
	private int id;//id
	private ClassCourse class_id;//上课班级
	private Students sid;//学号
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="class_id")
	public ClassCourse getClass_id() {
		return class_id;
	}
	public void setClass_id(ClassCourse class_id) {
		this.class_id = class_id;
	}
	@ManyToOne
	@JoinColumn(name="sid")
	public Students getSid() {
		return sid;
	}
	public void setSid(Students sid) {
		this.sid = sid;
	}
}
