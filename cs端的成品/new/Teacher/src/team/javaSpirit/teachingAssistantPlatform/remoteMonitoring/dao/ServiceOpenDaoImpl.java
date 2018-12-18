package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacherstatus;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
* <p>Title: ServiceOpenDaoImpl</p>
* <p>Description: 老师开启服务时，对数据库做相关的操作。</p>
* @author Fang Yuzhen
* @date 2018年12月17日
 */
public class ServiceOpenDaoImpl {

	/**
	 * <p>Title: name</p>
	 * <p>Description:老师开启服务时，把teacherStatus的状态改为1。 </p>
	 */
	public void reviseStatus() {
		Session session=HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String tid=Constant.myTeacher.getTid();
		Teacherstatus ts=session.get(Teacherstatus.class, tid);
		ts.setStatus(1);
		tx.commit();
	}
}
