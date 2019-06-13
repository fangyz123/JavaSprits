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
	 * Description: 通过学生的ip，查询学生的名字。
	 * </p>
	 * 
	 * @param ip 学生的ip
	 * @return 学生的名字
	 */
	public String getNameByIp(String ip) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("select name from Students where ip=?");
		q.setParameter(0, ip);
		String name = (String) q.uniqueResult();
		session.close();
		return name;
	}
}
