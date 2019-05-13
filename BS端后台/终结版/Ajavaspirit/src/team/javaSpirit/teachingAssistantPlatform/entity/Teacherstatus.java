package team.javaSpirit.teachingAssistantPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="teacherstatus")
public class Teacherstatus {
	/* 教工号 */
	private String tid;
	/* 是否开启远程控制 */
	private int status;
	
	@Id
	@GenericGenerator(name="my",strategy = "assigned")
	@GeneratedValue(generator="my")
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
