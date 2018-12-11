package team.javaSpirit.teachingAssistantPlatform.login.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;



import team.javaSpirit.teachingAssistantPlatform.entity.LoadStudent;
import team.javaSpirit.teachingAssistantPlatform.entity.LoadTeacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
/**
 * 
* <p>Title: LoginDao</p>
* <p>Description: B/S�˵�¼��֤��dao</p>
* @author �λ�ϼ
* @date 2018��12��11��
 */
@Repository
public class LoginDao {

	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 
	 * <p>Title: findUserName</p>
	 * <p>Description:�������ݿ����Ƿ��е�ǰ�û�����Ϣ���з���true </p>
	 * @param username
	 * @param role
	 * @return
	 */
	public boolean findUserName(String username,String role) {
		System.out.println(","+role+",");
		
		if(role.equals("student")) {
			
			String sql="select u.sid from Students u where u.sid = ?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, username);
			String str=(String)query.uniqueResult();
			
			if(str==null||str=="null") {
				System.out.println("meiyouzhoadao");
				return false;//û���ҵ��û�
			}
			System.out.println("zhoadaoyonghu");
			return true;//�ҵ����û�
		}else if(role.equals("teacher")) {
			String sql="select u.tid from Teacher u where u.tid = ?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, username);
			String str=(String)query.uniqueResult();
			
			if(str==null||str=="null") {
				System.out.println("meiyouzhoadao");
				return false;//û���ҵ��û�
			}
			System.out.println("zhoadaoyonghu");
			return true;//�ҵ����û�
		}else {
			String sql="select u.m_id from Manager u where u.m_id = ?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, username);
			String str=(String)query.uniqueResult();
			
			if(str==null||str=="null") {
				System.out.println("meiyouzhoadao");
				return false;//û���ҵ��û�
			}
			System.out.println("zhoadaoyonghu");
			return true;//�ҵ����û�
		}
		
		
	}
	/**
	 * 
	 * <p>Title: findLogin</p>
	 * <p>Description: �����ݿ�����֤�Ƿ��ܹ���¼</p>
	 * @param name
	 * @param word
	 * @param role
	 * @return
	 */
	public boolean findLogin(String name,String word,String role) {
		System.out.println("dao:"+role);
		if(role.equals("student")) {
			String sql="select u.password from Students u where u.sid = ?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, name);
			String str=(String)query.uniqueResult();
			
			if(str==word) {
				System.out.println("zhoadaoyonghu");
				return true;//ƥ��
			}
			System.out.println("meiyouzhoadao");
			return false;//��ƥ��
		}else if(role.equals("teacher")) {
			String sql="select u.password from Teacher u where u.tid = ?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, name);
			String str=(String)query.uniqueResult();
			
			if(str==word) {
				System.out.println("zhoadaoyonghu");
				return true;//ƥ��
			}
			System.out.println("meiyouzhoadao");
			return false;//��ƥ��
		}else {
			String sql="select u.password from Manager u where u.m_id = ?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(sql);
			query.setParameter(0, name);
			String str=(String)query.uniqueResult();
			
			if(str==word) {
				System.out.println("zhoadaoyonghu");
				return true;//ƥ��
			}
			System.out.println("meiyouzhoadao");
			return false;//��ƥ��
		}
	}
	
	/**
	 * 
	 * <p>Title: putLogin</p>
	 * <p>Description: �ѵ�¼����Ϣ������ؽ�ɫ��¼��Ϣ��</p>
	 * @param name
	 * @param role
	 */
	public void putLogin(String name,String role) {
		Session session=this.sessionFactory.getCurrentSession();
		System.out.println(role+"!!!!");
		System.out.println("student".equals(role));
		if("student".equals(role)) {
			LoadStudent ls=new LoadStudent();
			Timestamp date=new Timestamp(System.currentTimeMillis());
			Students s=new Students();
			s.setSid(name);
			ls.setSid(s);
			ls.setLogin_time(date);
			Serializable query=session.save(ls);
			session.flush();
		}else if(role.equals("teacher")) {
			LoadTeacher lt=new LoadTeacher();
			Timestamp date=new Timestamp(System.currentTimeMillis());
			lt.setLogin_time(date);
			Teacher t=new Teacher();
			t.setTid(name);
			lt.setTid(t);
			Serializable query=session.save(lt);
			session.flush();
		}else {
			
		}
		
	}

}
