package team.javaSpirit.teachingAssistantPlatform.login.dao;

import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.LoadTeacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;



/**
 * 
 * <p>
 * Title: LoadTeacherDaoImpl
 * </p>
 * <p>
 * Description:LoadTeacher实体的数据库操作
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月13日
 */
public class LoadTeacherDaoImpl {
	/**
	 * 
	 * <p>
	 * Title: saveLoadTeacher
	 * </p>
	 * <p>
	 * Description: 向loadteacher表中插入登录信息
	 * </p>
	 * 
	 * @param t
	 */
	public void saveLoadTeacher(LoadTeacher t) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	/**
	 * 
	 * <p>
	 * Title: getTeacherById
	 * </p>
	 * <p>
	 * Description:根据Teacher主键tid查找Teacher对象
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public Teacher getTeacherById(String id) {
		Session session = HibernateUtil.getSession();
		return session.get(Teacher.class, id);
	}

	/**
	 * 
	 * <p>
	 * Title: updateTeacherIp
	 * </p>
	 * <p>
	 * Description:修改Teacher表的IP
	 * </p>
	 * 
	 * @param t
	 * @param ip
	 * @return
	 */
	public Teacher updateTeacherIp(Teacher t, String ip) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Teacher s = session.get(Teacher.class, t.getTid());
		s.setIp(ip);
		session.getTransaction().commit();
		return s;
	}

	/**
	 * 
	 * <p>
	 * Title: updateTeacherPassword
	 * </p>
	 * <p>
	 * Description:修改老师Teacher表的password
	 * </p>
	 * 
	 * @param t
	 * @param password
	 */
	public void updateTeacherPassword(Teacher t, String password) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Teacher s = session.get(Teacher.class, t.getTid());
		s.setPassword(password);
		session.getTransaction().commit();
	}
}
