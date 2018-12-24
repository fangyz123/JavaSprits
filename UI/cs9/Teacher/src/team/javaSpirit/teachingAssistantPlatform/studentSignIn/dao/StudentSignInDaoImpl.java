package team.javaSpirit.teachingAssistantPlatform.studentSignIn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
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
	 * <p>
	 * Title: searchSignInStudent
	 * </p>
	 * <p>
	 * Description: 通过课程id，查看学生签到的情况,利用三表连接，返回学生的信息。
	 * </p>
	 * 
	 * @return
	 */
	public List<Object[]> searchSignInStudent() {
		Session session = HibernateUtil.getSession();
		String sql = "select s.sid,s.name,s1.record_status from Students s,Studentstatus s1,StudentClass s2 "
				+ "where s2.classin.class_id=? and s1.sid=s2.student.sid and s.sid=s1.sid ";
		Query q = session.createQuery(sql);
		q.setParameter(0, Constant.cid);
		return q.list();
	}

}
