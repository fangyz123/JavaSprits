package team.javaSpirit.teachingAssistantPlatform.rollcall.service;

import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.rollcall.dao.RollCallDao;

/**
 * <p>
 * Title: RollCallService
 * </p>
 * <p>
 * Description: 服务层，找到本课程的所有学生。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月25日
 */
public class RollCallService {
	private RollCallDao rollcalldao = new RollCallDao();

	/**
	 * <p>
	 * Title: searchSid
	 * </p>
	 * <p>
	 * Description: 通过课程号找到所有的学生。
	 * </p>
	 * 
	 * @return
	 */
	public List<Students> searchSid() {
		return rollcalldao.searchSidByClasscourse(Constant.cid);
	}

}
