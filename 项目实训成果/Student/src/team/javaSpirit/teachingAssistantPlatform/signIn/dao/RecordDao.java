package team.javaSpirit.teachingAssistantPlatform.signIn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

public class RecordDao {
	public List<String> SearchSignRank(Date begin,Date end) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select r.student.sid from Record r where r.date between ? and ? and r.state=1 group by r.student.sid order by count(*)");
		q.setParameter(0, begin);
		q.setParameter(1, end);
		q.setFirstResult(0);
		q.setMaxResults(10);
		List<String> list = q.list();
		session.close();
		return list;
		
	}
}
