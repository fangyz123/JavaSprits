package com.ryy.ui.login.dao;

import org.hibernate.Session;

import com.ryy.ui.entity.LoadTeacher;
import com.ryy.ui.util.HibernateUtil;
/**
 * 
* <p>Title: LoadTeacherDaoImpl</p>
* <p>Description:LoadTeacher实体的数据库操作 </p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class LoadTeacherDaoImpl {
	/**
	 * 
	 * <p>Title: saveLoadTeacher</p>
	 * <p>Description: 向loadteacher表中插入登录信息</p>
	 * @param t
	 */
	public void saveLoadTeacher(LoadTeacher t) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
}
