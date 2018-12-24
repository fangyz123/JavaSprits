package com.ryy.ui.login.dao;

import org.hibernate.Session;

import com.ryy.ui.entity.LoadStudent;
import com.ryy.util.HibernateUtil;

public class LoadStudentDaoImpl {
	public void saveLoadStudent(LoadStudent ls) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(ls);
		session.getTransaction().commit();
	}
}
