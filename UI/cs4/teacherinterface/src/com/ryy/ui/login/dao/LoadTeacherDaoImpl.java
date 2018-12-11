package com.ryy.ui.login.dao;

import org.hibernate.Session;

import com.ryy.ui.entity.LoadTeacher;
import com.ryy.ui.util.HibernateUtil;

public class LoadTeacherDaoImpl {
	public void saveLoadTeacher(LoadTeacher t) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
}
