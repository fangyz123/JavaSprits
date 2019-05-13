package team.javaSpirit.teachingAssistantPlatform.teacher.addstudent.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.StudentClass;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;

@Repository
public class AddStudentDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public void addStudent(String sid,String className) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ClassCourse where class_name=?");
		query.setParameter(0, className);
		ClassCourse classcourse = (ClassCourse)query.uniqueResult();
		Query query1 = session.createQuery("from Students where sid=?");
		query1.setParameter(0, sid);
		Students student = (Students)query1.uniqueResult();
		
		StudentClass studentclass = new StudentClass();
		studentclass.setClassin(classcourse);
		studentclass.setStudent(student);
		
		session.save(studentclass);
	}
}
