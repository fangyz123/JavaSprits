package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "studentstatus")
public class Studentstatus {
	/* 学号 */
	private String sid;
	/* 是否进行了人脸签到 */
	private int record_status;

	@Id
	@GenericGenerator(name = "my", strategy = "assigned")
	@GeneratedValue(generator = "my")
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getRecord_status() {
		return record_status;
	}

	public void setRecord_status(int record_status) {
		this.record_status = record_status;
	}

}
