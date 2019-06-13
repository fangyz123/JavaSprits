package team.javaSpirit.teachingAssistantPlatform.quiz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Quiz;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
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

	public Object saveQuiz(Quiz quiz) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Object o = session.save(quiz);
		session.getTransaction().commit();
		session.close();
		return o;
	}
	/**
	 * 将学生小测保存到数据库
	 * <p>Title: saveStudentQuiz</p>
	 * <p>Description: </p>
	 * @param squiz
	 * @return
	 */
	public Object saveStudentQuiz(StudentQuiz squiz) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Object o = session.save(squiz);
		session.getTransaction().commit();
		session.close();
		return o;
	}
	public List<String> searchQuizChapterByClass(ClassCourse cc){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select q.chapter from Quiz q where q.classcourse.class_id=?");
		q.setParameter(0,cc.getClass_id());
		List<String> list = q.list();
		session.close();
		return list;
	}
	public List<Quiz> searchQuizAsChapter(ClassCourse cc,String chapter){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from Quiz q where q.classcourse.class_id=? and q.chapter=?");
		q.setParameter(0,cc.getClass_id());
		q.setParameter(1, chapter);
		List<Quiz> list = q.list();
		session.close();
		return list;
	}
}
