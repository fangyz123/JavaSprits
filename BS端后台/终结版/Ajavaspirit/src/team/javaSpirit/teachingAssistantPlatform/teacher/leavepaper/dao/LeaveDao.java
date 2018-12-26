package team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.dao;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
/**
 * 
* <p>Title: LeaveDao</p>
* <p>Description: </p>
* @author 何慧霞
* @date 2018年12月25日
 */
@Repository
@Transactional(readOnly=false)
public class LeaveDao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 
	 * <p>Title: findPicture</p>
	 * <p>Description:查询所有符合class——id的假条 </p>
	 * @param name
	 * @return
	 */
	public List<LeavePaper> findPicture(List name) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("name:"+name);
		Query q=session.createQuery(" from LeavePaper s  where s.status=0 and s.class_id in (:id)");
		q.setParameterList("id", name);//注意这里设置集合的读取。
		List<LeavePaper> list=q.list();	
		System.out.println(list);
		return list;
	}
	/**
	 * 
	 * <p>Title: findclass</p>
	 * <p>Description:查询当前老师所有课程 </p>
	 * @param name
	 * @return
	 */
	public Set<ClassCourse> findclass(String name) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("name:"+name);
		Query q=session.createQuery("  from Teacher s  where s.tid=?");
		q.setParameter(0, name);
		Teacher t=(Teacher)q.uniqueResult();
		Set<ClassCourse> set=t.getClassCourses();
		System.out.println("size:"+set.size());
		return set;
		
	}
	/**
	 * 
	 * <p>Title: findAllId</p>
	 * <p>Description:查询当前老师上课的所有class——id </p>
	 * @param name
	 * @return
	 */
	public List findAllId(String name) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("name:"+name);
		Query q=session.createQuery(" select s.class_id from Teacher s  where s.tid=?");
		q.setParameter(0, name);
		List l=q.list();
		
		return l;
		
	}
	/**
	 * 
	 * <p>Title: findAllOther</p>
	 * <p>Description:查询所有class——id的所有课程 </p>
	 * @param l
	 * @return
	 */
	public List findAllOther(List l) {
		Session session=sessionFactory.getCurrentSession();
		
		Query q=session.createQuery(" from ClassCourse s  where  s.class_id in (:id)");
		q.setParameterList("id", l);//注意这里设置集合的读取。
		List<LeavePaper> list=q.list();	
	
		return list;
	}
	public void updatePaper(int status,int id) {
		Session session=sessionFactory.getCurrentSession();
		
		Query q=session.createQuery(" update LeavePaper s set  s.status=? where s.id=?");
		q.setParameter(0, status);
		q.setParameter(1, id);
		q.executeUpdate();
		
		
	}
	public void updateStudent(String sid) {
		Session session=sessionFactory.getCurrentSession();
		
		Query q=session.createQuery(" update Studentstatus s set  s.record_status=3 where s.sid=?");
		q.setParameter(0, sid);
		
		q.executeUpdate();
	}
	//下面的是展示该老师所有图片的内容
	public List<LeavePaper> findAllPicture(List name) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("name:"+name);
		Query q=session.createQuery(" from LeavePaper s  where  s.class_id in (:id)");
		q.setParameterList("id", name);//注意这里设置集合的读取。
		List<LeavePaper> list=q.list();	
		System.out.println(list);
		return list;
	}
	
}
