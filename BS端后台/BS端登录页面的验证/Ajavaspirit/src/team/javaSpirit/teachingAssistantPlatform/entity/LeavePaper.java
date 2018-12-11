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
 * <p>content:请假类对应leavePaper表</p>
 * @author 郭程媛
 *@date 2018年12月10日
 */
/*
 * 请假类
 */
@Entity
@Table(name="leavePaper")
public class LeavePaper {
	private int id;
	private Students sid;//学号
	private Date apply_time;//上传时间
	private String img_src;//图片路径
	private int status;//是否审核
	
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
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
