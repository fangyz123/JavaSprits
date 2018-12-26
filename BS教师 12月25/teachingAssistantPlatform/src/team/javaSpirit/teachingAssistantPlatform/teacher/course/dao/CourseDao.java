package team.javaSpirit.teachingAssistantPlatform.teacher.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import team.javaSpirit.teachingAssistantPlatform.entity.Course;

@Repository
public class CourseDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<String> findAll(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select course.cname from Course course");
		return q.list();
	}
}
