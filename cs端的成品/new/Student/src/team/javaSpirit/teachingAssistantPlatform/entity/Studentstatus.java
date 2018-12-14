package team.javaSpirit.teachingAssistantPlatform.entity;

public class Studentstatus {
	/* 学号 */
	private String sid;
	/* 是否进行了人脸签到 */
	private int record_status;

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
