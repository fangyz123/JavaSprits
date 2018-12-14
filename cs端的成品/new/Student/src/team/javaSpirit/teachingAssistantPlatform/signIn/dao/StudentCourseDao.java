package team.javaSpirit.teachingAssistantPlatform.signIn.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import team.javaSpirit.teachingAssistantPlatform.entity.Times;
import team.javaSpirit.teachingAssistantPlatform.util.BaseDao;

public class StudentCourseDao {

	private SessionFactory sessionFactory = BaseDao.getSessionFactory();

	/**
	 * <p>
	 * Title: allCourse
	 * </p>
	 * <p>
	 * Description: 通过学号，查询本学生所上的所有课程号。
	 * </p>
	 * 
	 * @param sid 学号
	 * @return 所有的课程号
	 */
	public List<Integer> allCourseBysid(String sid) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select classin.class_id from StudentClass where student.sid=?");
		q.setParameter(0, sid);
		return q.list();
	}

	/**
	 * <p>
	 * Title: allTimeBycid
	 * </p>
	 * <p>
	 * Description: 获取这门课的上课时间
	 * </p>
	 * 
	 * @param class_id 课程班级id
	 * @return 所有的时间
	 */
	public List<Times> allTimeBycid(int class_id) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select nodeNumber from Times where classin.class_id=?");
		q.setParameter(0, class_id);
		return q.list();
	}

	/**
	 * <p>
	 * Title: getStartTime
	 * </p>
	 * <p>
	 * Description: 返回开学日期。
	 * </p>
	 * 
	 * @return
	 */
	public Date getStartTime() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select time_begin from Term where status=1");
		return (Date) q.uniqueResult();
	}

	/**
	 * <p>
	 * Title: getBeginTime
	 * </p>
	 * <p>
	 * Description: 通过id,查找相对应的上课的开始时间。
	 * </p>
	 * 
	 * @param node_id id
	 * @return 上课的开始时间
	 */
	public String getBeginTime(int node_id) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select start_time from NodeNumber where node_id=?");
		q.setParameter(0, node_id);
		return (String) q.uniqueResult();
	}

	/**
	 * <p>
	 * Title: closeSessionFactory
	 * </p>
	 * <p>
	 * Description: 关闭session工厂。
	 * </p>
	 */
	public void closeSessionFactory() {
		sessionFactory.close();
	}

}
