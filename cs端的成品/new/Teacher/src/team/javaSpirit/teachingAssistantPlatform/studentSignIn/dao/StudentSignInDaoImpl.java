package team.javaSpirit.teachingAssistantPlatform.studentSignIn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * <p>
 * Title: StudentSignInDaoImpl
 * </p>
 * <p>
 * Description: 查看学生签到的情况。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class StudentSignInDaoImpl {

	/**
	 * <p>Title: searchSignInStudent</p>
	 * <p>Description: 查看学生正常签到的情况,利用两表连接，返回学生表的信息。</p>
	 * @return
	 */
	public List<Students> searchSignInStudent() {
		Session session = HibernateUtil.getSession();
		Query q = session
				.createQuery("select s from Students s,Studentstatus s1 where s1.record_status=1 and s.sid=s1.sid");
		return q.list();
	}
	
	/**
	 * <p>Title: searchSignInStudent</p>
	 * <p>Description: 查看学生签到迟到的情况,利用两表连接，返回学生表的信息。</p>
	 * @return
	 */
	public List<Students> searchLateStudent() {
		Session session = HibernateUtil.getSession();
		Query q = session
				.createQuery("select s from Students s,Studentstatus s1 where s1.record_status=2 and s.sid=s1.sid");
		return q.list();
	}

}
