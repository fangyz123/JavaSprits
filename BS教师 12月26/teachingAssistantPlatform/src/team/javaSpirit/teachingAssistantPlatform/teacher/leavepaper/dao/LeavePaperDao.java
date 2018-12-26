package team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;

@Repository
public class LeavePaperDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<LeavePaper> findALL(){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from LeavePaper");
		return query.list();
	}
}
