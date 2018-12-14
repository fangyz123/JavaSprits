package team.javaSpirit.teachingAssistantPlatform.login.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import team.javaSpirit.teachingAssistantPlatform.entity.LoadStudent;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.util.BaseDao;

/**
 * <p>
 * Title: LoadStudentDaoImpl
 * </p>
 * <p>
 * Description: 登录时，需要跟数据库交互的类。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月13日
 */
public class LoadStudentDaoImpl {
	private SessionFactory sessionFactory = BaseDao.getSessionFactory();

	/**
	 * <p>
	 * Title: saveLoadStudent
	 * </p>
	 * <p>
	 * Description: 登录成功，往登录表里插入一条数据。
	 * </p>
	 * 
	 * @param ls 登录对象
	 */
	public void saveLoadStudent(LoadStudent ls) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ls);
		session.getTransaction().commit();
	}

	/**
	 * <p>
	 * Title: getStudentById
	 * </p>
	 * <p>
	 * Description: 根据Students主键sid查找Students对象
	 * </p>
	 * 
	 * @param sid 学号
	 * @return Students 学生对象
	 */
	public Students getStudentById(String sid) {
		Session session = sessionFactory.openSession();
		return session.get(Students.class, sid);
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
	 * @param ip ip地址
	 */
	public Students updateStudentIp(Students s, String ip) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Students p = session.get(Students.class, s.getSid());
		p.setIp(ip);
		session.getTransaction().commit();
		return p;
	}

	/**
	 * <p>
	 * Title: updateStudentPassword
	 * </p>
	 * <p>
	 * Description: 学生修改密码。
	 * </p>
	 * 
	 * @param s   学生对象
	 * @param pwd 新密码
	 */
	public void updateStudentPassword(Students s, String pwd) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Students p = session.get(Students.class, s.getSid());
		p.setPassword(pwd);
		session.getTransaction().commit();
	}
}
