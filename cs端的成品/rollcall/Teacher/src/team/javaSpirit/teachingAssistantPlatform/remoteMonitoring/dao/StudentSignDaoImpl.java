package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * <p>
 * Title: StudentSignDaoImpl
 * </p>
 * <p>
 * Description: 查询所有的学生签到情况。不管是不是迟到。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class StudentSignDaoImpl {

	/**
	 * <p>
	 * Title: searchSignInStudent
	 * </p>
	 * <p>
	 * Description: 查看签到的所有学生,利用两表连接，返回学生表的信息。
	 * </p>
	 * 
	 * @return
	 */
	public List<Students> searchAllStudent() {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery(
				"select s from Students s,Studentstatus s1 where (s1.record_status=1 or s1.record_status=2) and s.sid=s1.sid");
		return q.list();
	}
}
