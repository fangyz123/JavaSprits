package team.javaSpirit.teachingAssistantPlatform.upload.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import team.javaSpirit.teachingAssistantPlatform.entity.ShareResource;
import team.javaSpirit.teachingAssistantPlatform.util.HibernateUtil;

/**
 * 
 * <p>
 * Title: ShareResourceDaoImpl
 * </p>
 * <p>
 * Description: 对共享资源ShareResource所做的数据库操作
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月20日
 */
public class ShareResourceDaoImpl {
	/**
	 * 
	 * <p>
	 * Title: getAllResources
	 * </p>
	 * <p>
	 * Description: 获得所有共享资源数据库中所有的资源
	 * </p>
	 * 
	 * @return
	 */
	public static List<ShareResource> getAllResources() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from ShareResource");
		List<ShareResource> list = query.list();
		session.close();
		return list;
	}

	/**
	 * 
	 * <p>
	 * Title: saveUploadResource
	 * </p>
	 * <p>
	 * Description: 将指定的资源保存到数据库
	 * </p>
	 * 
	 * @param sr
	 * @return
	 */
	public static Object saveUploadResource(ShareResource sr) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Object o = session.save(sr);
		session.getTransaction().commit();
		session.close();
		return o;
	}
}
