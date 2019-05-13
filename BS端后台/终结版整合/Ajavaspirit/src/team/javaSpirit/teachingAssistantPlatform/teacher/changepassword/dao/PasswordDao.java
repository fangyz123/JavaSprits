package team.javaSpirit.teachingAssistantPlatform.teacher.changepassword.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository

public class PasswordDao {
	@Resource
	private SessionFactory sessionfactory;
	public void updatePassword(String tid,String word) {
		Session session=sessionfactory.getCurrentSession();
		Query q=session.createQuery("update Teacher s set s.password=? where s.tid=?");
		q.setParameter(0, word);
		q.setParameter(1, tid);
		q.executeUpdate();
	}
	

}
