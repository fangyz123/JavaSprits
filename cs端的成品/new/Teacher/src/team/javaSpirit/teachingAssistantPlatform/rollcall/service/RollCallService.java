package team.javaSpirit.teachingAssistantPlatform.rollcall.service;

import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.rollcall.dao.RollCallDao;

public class RollCallService {
	private RollCallDao rollcalldao = new RollCallDao();
	
	public List<Students> searchSid() {
		return rollcalldao.searchSidByClasscourse(Constant.cid);
	}
	
}
