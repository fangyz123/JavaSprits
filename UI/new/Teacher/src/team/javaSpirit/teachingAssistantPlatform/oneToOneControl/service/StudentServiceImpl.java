package team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service;

import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.dao.StudentDaoImpl;

public class StudentServiceImpl {

	private StudentDaoImpl studentDao=new StudentDaoImpl();
	
	/**
	 * <p>Title: findIp</p>
	 * <p>Description: 通过学生的名字，找到学生的IP</p>
	 * @param ip 学生的ip
	 * @return 学生的名字
	 */
	public String findName(String ip) {
		return studentDao.getNameByIp(ip);
	}
}