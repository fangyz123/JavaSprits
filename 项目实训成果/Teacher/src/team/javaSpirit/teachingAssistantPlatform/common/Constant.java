package team.javaSpirit.teachingAssistantPlatform.common;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;

public class Constant {
	/*老师对象*/
	public static Teacher myTeacher;
	/* 课程号 */
	public static int cid;
	/* session连接时，保存所有的名字对应的session */
	public static ConcurrentHashMap<String, IoSession> studentSession = new ConcurrentHashMap<>(10);
}
