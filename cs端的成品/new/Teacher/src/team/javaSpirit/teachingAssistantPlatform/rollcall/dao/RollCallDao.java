package team.javaSpirit.teachingAssistantPlatform.rollcall.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * <p>
 * Title: RollCallDao
 * </p>
 * <p>
 * Description: 找到本课程的所有学生。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月25日
 */
public class RollCallDao {
	/**
	 * <p>
	 * Title: searchSidByClasscourse
	 * </p>
	 * <p>
	 * Description: 通过班级课程找学生对象
	 * </p>
	 * 
	 * @param tid
	 * @return class_id
	 */
	public List<Students> searchSidByClasscourse(int class_id) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select sc.student from StudentClass sc where sc.classin.class_id=? ");
		q.setParameter(0, class_id);
		List<Students> list = q.list();
		session.close();
		return list;
	}

	/**
	 * <p>
	 * Title: getClassCourseByCid
	 * </p>
	 * <p>
	 * Description: 通过课程号找班级课程
	 * </p>
	 * 
	 * @return 课程班级类
	 */
	public ClassCourse getClassCourseByCid(int cid) {
		Session session = HibernateUtil.getSession();
		ClassCourse c = session.get(ClassCourse.class, cid);
		session.close();
		return c;
	}

}
