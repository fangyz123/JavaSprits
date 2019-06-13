package team.javaSpirit.teachingAssistantPlatform.quiz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentClass;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * 完成关于设计课堂小测业务逻辑的所有数据库查询
* <p>Title: QuizDao</p>
* <p>Description: </p>
* @author renyuyuan
* @date 2019年5月8日
 */
public class QuizDao {
	/**
	 * 查询studentclass这个表，查询所有的课程
	 * <p>Title: quitCourses</p>
	 * <p>Description: </p>
	 * @return
	 */
	public List<StudentClass> searchClasses(){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from StudentClass where student.sid=?");
		q.setParameter(0, Constant.myStudent.getSid());
		List<StudentClass> list=q.list();
		session.close();
		return list;
	}
	/**
	 * 根据学生ID和课程ID查找所有小测
	 * <p>Title: searchStudentQuizBySid</p>
	 * <p>Description: </p>
	 * @param class_id
	 * @return
	 */
	public List<StudentQuiz> searchStudentQuizBySid(int class_id){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from StudentQuiz sq where sq.student.sid=? and sq.quiz.classcourse.class_id=?");
		q.setParameter(0, Constant.myStudent.getSid());
		q.setParameter(1, class_id);
		List<StudentQuiz> list=q.list();
		session.close();
		return list;
		
	}
	/**
	 * 做完小测后改变小测状态和答案
	 * <p>Title: saveStudentQuiz</p>
	 * <p>Description: </p>
	 * @param studentQuiz
	 * @param answers
	 * @param time
	 * @param acc
	 */
	public void saveStudentQuiz(StudentQuiz studentQuiz,String[] answers,float time,String acc) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query q = session.createQuery("from StudentQuiz where id=?");
		q.setParameter(0,studentQuiz.getId());
		StudentQuiz sq=(StudentQuiz)q.uniqueResult();
		String answer="";
		for(int i=1;i<answers.length;i++) {
			if(answers[i]==null)
				break;
			answer=answer+i+"."+answers[i];
		}
		sq.setState(1);sq.setAnswer(answer);sq.setAcc(acc);sq.setTime(time);
		session.getTransaction().commit();
		session.close();
	}
	/**
	 * 查找所有做了同一个小测的小测序列
	 * <p>Title: searchStudentQuizs</p>
	 * <p>Description: </p>
	 * @param sq
	 * @return
	 */
	public List<StudentQuiz> searchStudentQuizs(StudentQuiz sq){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("from StudentQuiz sq where sq.state=1 and sq.quiz.id=?");
		q.setParameter(0, sq.getQuiz().getId());
		List<StudentQuiz> list=q.list();
		session.close();
		return list;
	}
	/**
	 * 查找同一个学生每门课不同章节的平均正确率
	 * <p>Title: searchAvgAccGroupByChapter</p>
	 * <p>Description: </p>
	 * @param cc
	 * @return
	 */
	public List<Object[]> searchAvgAccGroupByChapter(ClassCourse cc) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select sq.quiz.chapter,avg(sq.acc) from StudentQuiz sq where sq.quiz.classcourse.class_id=? and sq.student.sid=? and sq.state=1 group by sq.quiz.chapter");
		q.setParameter(0, cc.getClass_id());
		q.setParameter(1, Constant.myStudent.getSid());
		List<Object[]> list=q.list();
		session.close();
		return list;
	}
	/**
	 * 查找所有学生某门课某个章节的平均争取率
	 * <p>Title: searchAvgAccCountByChapter</p>
	 * <p>Description: </p>
	 * @param cc
	 * @param chapter
	 * @return
	 */
	public List<Object []> searchAvgAccCountByChapter(ClassCourse cc,String chapter){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select sq.student.sid,avg(sq.acc) from StudentQuiz sq where sq.quiz.classcourse.class_id=? and sq.quiz.chapter=? group by sq.student.sid");
		q.setParameter(0, cc.getClass_id());
		q.setParameter(1, chapter);
		List<Object []> list=q.list();
		session.close();
		return list;
	}
	/**
	 * 获得指定学生的每门课的平均正确率
	 * <p>Title: searchAvgAccGroupByCourse</p>
	 * <p>Description: </p>
	 * @param cc
	 * @return
	 */
	public Double searchAvgAccGroupByCourse(ClassCourse cc) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select avg(sq.acc) from StudentQuiz sq where sq.quiz.classcourse.class_id=? and sq.student.sid=?");
		q.setParameter(0, cc.getClass_id());
		q.setParameter(1, Constant.myStudent.getSid());
		Double d=(Double)q.uniqueResult();
		session.close();
		return d;
	} 
	/**
	 * 获得所有学生指定科目的平均争取率
	 * <p>Title: searchAvgAccCountByCourse</p>
	 * <p>Description: </p>
	 * @param cc
	 * @return
	 */
	public List<Object []> searchAvgAccCountByCourse(ClassCourse cc){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select sq.student.sid,avg(sq.acc) from StudentQuiz sq where sq.quiz.classcourse.class_id=? group by sq.student.sid");
		q.setParameter(0, cc.getClass_id());
		List<Object []> list=q.list();
		session.close();
		return list;
	}
}
