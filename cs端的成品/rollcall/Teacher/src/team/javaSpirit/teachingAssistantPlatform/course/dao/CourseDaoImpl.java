package team.javaSpirit.teachingAssistantPlatform.course.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Times;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * <p>
 * Title: CourseDaoImpl
 * </p>
 * <p>
 * Description: 查找课程的数据库操作。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月18日
 */
public class CourseDaoImpl {

	/**
	 * <p>
	 * Title: findCidByTid
	 * </p>
	 * <p>
	 * Description: 找出这个老师所教的所有课程。
	 * </p>
	 * 
	 * @param tid 老师的教工号
	 * @return 老师所教的所有课程
	 */
	public List<Integer> findCidByTid(String tid) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select class_id from ClassCourse where teacher.tid=?");
		q.setParameter(0, tid);
		return q.list();
	}

	/**
	 * <p>
	 * Title: getClassCourseBycid
	 * </p>
	 * <p>
	 * Description: 通过课程班级号，查班级课程
	 * </p>
	 * 
	 * @param cid 课程班级号
	 * @return 课程班级对象
	 */
	public ClassCourse getClassCourseBycid(int cid) {
		Session session = HibernateUtil.getSession();
		return session.get(ClassCourse.class, cid);
	}

	/**
	 * <p>
	 * Title: allTimeBycid
	 * </p>
	 * <p>
	 * Description: 通过课程号，查到这门课的具体上课时间。
	 * </p>
	 * 
	 * @param class_id 课程班级id
	 * @return 所有的时间
	 */
	public List<Times> allTimeBycid(int class_id) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from Times where classin.class_id=?");
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
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select time_begin from Term where status=1");
		return (Date) q.uniqueResult();
	}

	/**
	 * <p>
	 * Title: getBeginTime
	 * </p>
	 * <p>
	 * Description: 通过节数id,查找相对应的上课的开始时间。
	 * </p>
	 * 
	 * @param node_id id
	 * @return 上课的开始时间
	 */
	public String getBeginTime(int node_id) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select start_time from NodeNumber where node_id=?");
		q.setParameter(0, node_id);
		return (String) q.uniqueResult();
	}

	/**
	 * <p>
	 * Title: getEndTime
	 * </p>
	 * <p>
	 * Description: 通过id,查找相对应的上课的结束时间。
	 * </p>
	 * 
	 * @param node_id id
	 * @return 上课的结束时间
	 */
	public String getEndTime(int node_id) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select end_time from NodeNumber where node_id=?");
		q.setParameter(0, node_id);
		return (String) q.uniqueResult();
	}
	
	/**
	 * <p>Title: findCname</p>
	 * <p>Description: 通过课程号，找到课程班级名</p>
	 * @param cid 课程班级号
	 * @return 课程班级名
	 */
	public String findCname(int cid) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select class_name from ClassCourse where class_id=?");
		q.setParameter(0, cid);
		return (String)q.uniqueResult();
	}
}
