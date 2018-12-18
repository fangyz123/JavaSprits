package com.ryy.ui.teacher.dao;

import org.hibernate.Session;

import com.ryy.ui.entity.Teacher;
import com.ryy.ui.util.HibernateUtil;
/**
 * 
* <p>Title: TeacherDaoImpl</p>
* <p>Description:Techer表的操作 </p>
* @author renyuyuan
* @date 2018年12月11日
 */
public class TeacherDaoImpl {
	/**
	 * 
	 * <p>Title: getTeacherById</p>
	 * <p>Description:根据Teacher主键tid查找Teacher对象 </p>
	 * @param id
	 * @return
	 */
	 public Teacher getTeacherById(String id) {
		 Session session=HibernateUtil.getSession();
		return session.get(Teacher.class, id);
	 }
	 /**
	  * 
	  * <p>Title: updateTeacherIp</p>
	  * <p>Description:修改Teacher表的IP </p>
	  * @param t
	  * @param ip
	  * @return
	  */
	 public Teacher updateTeacherIp(Teacher t,String ip) {
		 Session session=HibernateUtil.getSession();
		 session.beginTransaction();
		 Teacher s=session.get(Teacher.class, t.getTid());
		 s.setIp(ip);
		 session.getTransaction().commit();
		 return s;
	 }
	 /**
	  * 
	  * <p>Title: updateTeacherPassword</p>
	  * <p>Description:修改老师Teacher表的password </p>
	  * @param t
	  * @param password
	  */
	 public void updateTeacherPassword(Teacher t,String password) {
		 Session session=HibernateUtil.getSession();
		 session.beginTransaction();
		 Teacher s=session.get(Teacher.class, t.getTid());
		 s.setPassword(password);
		 session.getTransaction().commit();
	 }
}
