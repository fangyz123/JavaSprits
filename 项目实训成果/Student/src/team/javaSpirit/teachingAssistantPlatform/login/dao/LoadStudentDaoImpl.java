package team.javaSpirit.teachingAssistantPlatform.login.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import team.javaSpirit.teachingAssistantPlatform.entity.LoadStudent;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Studentstatus;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * 
 * <p>
 * Title: StudentsDaoImpl
 * </p>
 * <p>
 * Description: Students数据库操作
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月10日
 */
public class LoadStudentDaoImpl {

	/**
	 * <p>
	 * Title: saveLoadStudent
	 * </p>
	 * <p>
	 * Description: 王登录表里插入一条数据。
	 * </p>
	 * 
	 * @param ls 登录表的对象
	 */
	public void saveLoadStudent(LoadStudent ls) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(ls);
		tx.commit();
		session.close();
	}

	/**
	 * <p>
	 * Title: getStudentById
	 * </p>
	 * <p>
	 * Description: 根据Students主键sid查找Students对象
	 * </p>
	 * 
	 * @param sid
	 * @return Students
	 */
	public Students getStudentById(String sid) {
		Session session = HibernateUtil.getSession();
		Students s = session.get(Students.class, sid);
		session.close();
		return s;
	}

	/**
	 * 
	 * <p>
	 * Title: updateStudentIp
	 * </p>
	 * <p>
	 * Description:修改学表Students的ip保持到数据库
	 * </p>
	 * 
	 * @param ip
	 */
	public Students updateStudentIp(Students s, String ip) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Students p = session.get(Students.class, s.getSid());
		p.setIp(ip);
		tx.commit();
		session.close();
		return p;
	}
	/**
	 * 修改学生密码
	 * <p>Title: updateStudentPassword</p>
	 * <p>Description: </p>
	 * @param s
	 * @param pwd
	 */
	public void updateStudentPassword(Students s, String pwd) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Students p = session.get(Students.class, s.getSid());
		p.setPassword(pwd);
		tx.commit();
		session.close();
	}
	/**
	 * 查询学生登录状态保证只有一人登录
	 * <p>Title: checkStatus</p>
	 * <p>Description: </p>
	 * @param sno
	 * @return
	 */
	public Studentstatus checkStatus(String sno) {
		Session session = HibernateUtil.getSession();
		Studentstatus ss=session.get(Studentstatus.class, sno);
		session.close();
		return ss;
	}
	/**
	 * 改变学生状态保证只有一人登录
	 * <p>Title: updateStatus</p>
	 * <p>Description: </p>
	 * @param sno
	 */
	public void updateStatus(String sno) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Studentstatus ss=session.get(Studentstatus.class, sno);
		ss.setRecord_status(4);
		tx.commit();
		session.close();
	}
	/**
	 * 改变学生取消的登录状态重新置为0
	 * <p>Title: updateCancelStatus</p>
	 * <p>Description: </p>
	 * @param sno
	 */
	public void updateCancelStatus(String sno) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Studentstatus ss=session.get(Studentstatus.class, sno);
		ss.setRecord_status(4);
		tx.commit();
		session.close();
	}
}
