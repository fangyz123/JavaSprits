package team.javaSpirit.teachingAssistantPlatform.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BaseDao {
	private static SessionFactory sf = null;

	static {
		// 注册服务的创建
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry sr = ssrb.configure().build();
		// SessionFactory的创建。
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	public BaseDao() {
	
	}

}
