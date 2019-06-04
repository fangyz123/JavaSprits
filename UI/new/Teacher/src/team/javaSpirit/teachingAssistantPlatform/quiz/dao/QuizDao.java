package team.javaSpirit.teachingAssistantPlatform.quiz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacherstatus;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

public class QuizDao {

	public QuizDao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * <p>
	 * Title: searchCoursenameByTid
	 * </p>
	 * <p>
	 * Description: 通过老师找课程名
	 * </p>
	 * 
	 * @return class_name
	 */
	public List<ClassCourse> searchSidByClasscourse(String tid) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from ClassCourse sc where sc.teacher.tid=? ");
		q.setParameter(0,tid);
		List<ClassCourse> list = q.list();
		
		session.close();
		return list;
	}

	
}
