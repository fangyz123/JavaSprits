package team.javaSpirit.teachingAssistantPlatform.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * <p>Title:行政班</p>
 * <p>content:行政班类对应classAdministration表</p>
 * @author 郭程媛
 *@date 2018年12月10日
 */
/*
 * 行政班
 * 
 */
@Entity
@Table(name="classAdministration")
public class ClassAdministration {
	private int c_a_id;//流水号
	private String name;//班名
	private Set<Students> students = new HashSet<Students>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@OneToMany(
			mappedBy="c_a_id",
			cascade= {CascadeType.ALL}
			)
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
}
