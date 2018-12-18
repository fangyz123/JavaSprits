package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * <p>
 * Title: TeacherClassDaoImpl
 * </p>
 * <p>
 * Description: 对学生要连接老师的操作进行查询。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class TeacherClassDaoImpl {

	/**
	 * <p>
	 * Title: searchTeacher
	 * </p>
	 * <p>
	 * Description: 利用三表的等值连接，找到正在上这门课且服务已经开了的老师。
	 * </p>
	 * 
	 * @param c_id 课程id
	 * @return 教这门课的老师
	 */
	public Teacher searchTeacher(int c_id) {
		Session session = HibernateUtil.getSession();
		String sql = "select t from Teacher t,ClassCourse cc,Teacherstatus ts " + 
				"where cc.course.course_id=? and ts.status=1"
				+ "and t.tid=cc.teacher.tid and t.id=ts.tid";
		Query q = session.createQuery(sql);
		q.setParameter(0, c_id);
		Teacher t = (Teacher) q.uniqueResult();
		return t;
	}
}
