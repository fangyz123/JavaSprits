package team.javaSpirit.teachingAssistantPlatform.common;

import java.util.List;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.Course;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;

/**
 * 
 * <p>
 * Title: Constant
 * </p>
 * <p>
 * Description: 程序中一些静态量的设置
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月13日
 */
public class Constant {
	/* 学生对象 */
	public static Students myStudent;
	/* 上课班级 */
	public static int cid;
	/* 该学生所有的课程 */
	public static List<Course> myCourses;
	/* 老师对象 */
	public static Teacher teacher;
	/* 图片路径 */
	public static String imgsrc;
	/* 下课时间 */
	public static String endT;
	/* 连接老师端的会话 */
	public static IoSession session = null;
}
