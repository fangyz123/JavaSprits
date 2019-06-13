package team.javaSpirit.teachingAssistantPlatform.feedback.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import team.javaSpirit.teachingAssistantPlatform.entity.FeedBack;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

public class FeedBackDaoImpl {
	public void setTxtById(Students sid, String txt) {
		Session session = HibernateUtil.getSession();
		FeedBack fb = new FeedBack();
		Transaction tx = session.beginTransaction();
		fb.setStudent(sid);
		fb.setTxt(txt);
		fb.setStatus(0);
		fb.setTime(new Date());
		session.save(fb);
		tx.commit();
		session.close();
	}
}
