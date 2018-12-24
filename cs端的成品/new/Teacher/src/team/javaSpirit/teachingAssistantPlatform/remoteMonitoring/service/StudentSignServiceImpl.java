package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.dao.StudentSignDaoImpl;

/**
 * <p>
 * Title: StudentSignServiceImpl
 * </p>
 * <p>
 * Description: 为远程控制提供服务。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class StudentSignServiceImpl {
	private StudentSignDaoImpl studentSign=new StudentSignDaoImpl();

	/**
	 * <p>Title: allSignStu</p>
	 * <p>Description: 返回所有签到的学生。</p>
	 * @return
	 */
	public List<Students> allSignStudent() {
		return studentSign.searchAllStudent();
	}
}
