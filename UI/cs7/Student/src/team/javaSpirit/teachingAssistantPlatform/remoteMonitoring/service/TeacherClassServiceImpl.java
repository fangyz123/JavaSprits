package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.dao.TeacherClassDaoImpl;

public class TeacherClassServiceImpl {
	/* Dao类的对象 */
	private TeacherClassDaoImpl teacherClass = new TeacherClassDaoImpl();

	/**
	 * <p>Title: findTeacher</p>
	 * <p>Description: 利用三表的等值连接，通过课程id，查找开启服务的老师。</p>
	 * @param c_id 课程id
	 * @return
	 */
	public Teacher findTeacher(int c_id) {
		return teacherClass.searchTeacher(c_id);
	}
}
