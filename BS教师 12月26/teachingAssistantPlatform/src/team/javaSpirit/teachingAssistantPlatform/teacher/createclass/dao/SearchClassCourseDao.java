package team.javaSpirit.teachingAssistantPlatform.teacher.createclass.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SearchClassCourseDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public String searchClassCourse(String name){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select class_name from ClassCourse classcourse where classcourse.class_name=?");
		query.setParameter(0, name);
		return (String)query.uniqueResult();
	}
}
