package team.javaSpirit.teachingAssistantPlatform.login.dao;

import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.LoadTeacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacherstatus;
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
		session.close();
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
		Teacher t=session.get(Teacher.class, id);
		session.close();
		return t;
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
		session.close();
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
		session.close();
	}
	public Teacherstatus checkStatus(String sno) {
		Session session = HibernateUtil.getSession();
		Teacherstatus ts=session.get(Teacherstatus.class, sno);
		session.close();
		return ts;
	}
	public void updateStatus(String sno) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Teacherstatus ts=session.get(Teacherstatus.class, sno);
		ts.setStatus(4);
		session.getTransaction().commit();
		session.close();
	}
}
