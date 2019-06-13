package team.javaSpirit.teachingAssistantPlatform.feedback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import team.javaSpirit.teachingAssistantPlatform.entity.FeedBack;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

public class FeedBackDaoImpl {
	public List<FeedBack> showTxtByStatus(int status) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery(" from FeedBack where status=?");
		q.setParameter(0, status);
		List<FeedBack> list = q.list();
		session.close();
		return list;
		
	}

	public void changeStatus(FeedBack fb) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		FeedBack fb1=session.get(FeedBack.class ,fb.getId());
		fb1.setStatus(1);
		session.save(fb1);
		tx.commit();
		session.close();
	}
	
	public void changeStatusTozero(FeedBack fb) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		FeedBack fb1=session.get(FeedBack.class ,fb.getId());
		fb1.setStatus(0);
		session.save(fb1);
		tx.commit();
		session.close();
	}
}
