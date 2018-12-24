package team.javaSpirit.teachingAssistantPlatform.student.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.entity.LoadStudent;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;

@Repository
public class StudentDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public void updatePassword(String sid,String word) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("update Students s set s.password=? where s.sid=?");
		q.setParameter(0, word);
		q.setParameter(1, sid);
		q.executeUpdate();
		//session.close();
	}
	/**
	 * 
	 * <p>Title: insertLeavePaper</p>
	 * <p>Description: 把信息插入到假条表中</p>
	 * @param name
	 * @param path
	 * @param class_id
	 */
	public void insertLeavePaper(String name,String path,int class_id) {
		Session session=sessionFactory.getCurrentSession();
		LeavePaper paper=new LeavePaper();
		Timestamp date=new Timestamp(System.currentTimeMillis());
		Students s=new Students();
		s.setSid(name);
		paper.setStudent(s);
		paper.setApply_time(date);
		paper.setStatus(0);
		paper.setImg_src(path);
		paper.setClass_id(class_id);
		Serializable query=session.save(paper);
		session.flush();
	}
	public int findClassId(String course,String teacher) {
		System.out.println(course);
		System.out.println(teacher);
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery(" select s.class_id from ClassCourse s  where s.teacher.tname=? and s.course.cname=?");
		q.setParameter(0, teacher);
		q.setParameter(1, course);
		Object obj=q.uniqueResult();
		if(obj==null) {
			System.out.println("classid is null");
			return 0;
		}else {
			System.out.println(obj);
			System.out.println("classid not null");
			int i=(int)obj;
			System.out.println(i);
			return i;
		}
		
	}
	/**
	 * 
	 * <p>Title: findPicture</p>
	 * <p>Description:查找所有的假条 </p>
	 * @param name
	 * @return
	 */
	public List<LeavePaper> findPicture(String name) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println("name:"+name);
		//name="2016011395";
		//Query q=session.createQuery("select s.leavePapers from Students s  where s.sid=?");
		Query q=session.createQuery(" from LeavePaper s  where s.student.sid=?");
		q.setParameter(0, name);
		List<LeavePaper> list=q.list();
		
		//Set<LeavePaper> set=(Set<LeavePaper>)list;
		//System.out.println(list);
		
		return list;
	}
	/**
	 * 
	 * <p>Title: findCourse</p>
	 * <p>Description:查找所输入的课程是否存在 </p>
	 * @param course
	 * @return
	 */
	public boolean findCourse(String course) {
		System.out.println(course);
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery(" from Course s  where s.cname=?");
		q.setParameter(0, course);
		Object obj=q.uniqueResult();
		System.out.println(obj);
		if(obj==null) {
			return false;
		}else {
			return true;
		}

		
	}
	/**
	 * 
	 * <p>Title: findTeacher</p>
	 * <p>Description:查找所输入的老师是否存在 </p>
	 * @param teacher
	 * @return
	 */
	public boolean findTeacher(String teacher) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery(" from Teacher s  where s.tname=?");
		q.setParameter(0, teacher);
		Object obj=q.uniqueResult();
		if(obj==null) {
			return false;
		}else {
			return true;
		}
	}
}
