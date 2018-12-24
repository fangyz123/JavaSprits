package team.javaSpirit.teachingAssistantPlatform.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * <p>Title:学期时间</p>
 * <p>content:学期时间类对应term表</p>
 * @author 张鼎
 *@date 2018年12月10日
 */
/*
 * 学期时间
 */
@Entity
@Table(name="term")
public class Term {
	private int term_id;//序列号
	private Date time_begin;//学期开始日期
	private Date time_end;//学期结束日期
	private int status;//学期状态
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTerm_id() {
		return term_id;
	}
	public void setTerm_id(int term_id) {
		this.term_id = term_id;
	}
	public Date getTime_begin() {
		return time_begin;
	}
	public void setTime_begin(Date time_begin) {
		this.time_begin = time_begin;
	}
	public Date getTime_end() {
		return time_end;
	}
	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
