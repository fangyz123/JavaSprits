package team.javaSpirit.teachingAssistantPlatform.oneToOneControl.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * <p>
 * Title: StudentDaoImpl
 * </p>
 * <p>
 * Description: 学生查询对数据库的相关操作。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月19日
 */
public class StudentDaoImpl {

	/**
	 * <p>
	 * Title: getIpByName
	 * </p>
	 * <p>
	 * Description: 通过学生的名字，查询学生的IP。
	 * </p>
	 * 
	 * @param name 学生的名字
	 * @return 学生的IP
	 */
	public String getIpByName(String name) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select ip from Students where name=?");
		q.setParameter(0, name);
		String ip = (String) q.uniqueResult();
		return ip;
	}
}
