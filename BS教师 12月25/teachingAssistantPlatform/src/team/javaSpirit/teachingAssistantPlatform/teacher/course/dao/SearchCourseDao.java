package team.javaSpirit.teachingAssistantPlatform.teacher.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SearchCourseDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<String> SearchCourse(String cname){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select course.cname from Course course where course.cname like :var1");
		q.setString("var1", cname+"%");
		return q.list();
	}
}
