package team.javaSpirit.teachingAssistantPlatform.teacher.createclass.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Course;
import team.javaSpirit.teachingAssistantPlatform.entity.NodeNumber;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Times;

@Repository
public class CreateClassDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void createClass(String className,String courseName,String tid) {
//		String hql = "update ClassCourse classcourse set classcourse.class_name=:var1, classcourse.course.course_id=("
//				+ "select course.course_id from Course course where course.cname =:var2"
//				+ ")"
//				+", classcourse.teacher.tid =("
//				+"select teacher.tid from Teacher teacher where teacher.tid=:var3"
//				+ ")";
		Session session = this.sessionFactory.getCurrentSession();
//		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("from Course where cname=?");
		query.setParameter(0, courseName);
		Course c=(Course)query.uniqueResult();
		
		Query query1 = session.createQuery("from Teacher where tid=?");
		query1.setParameter(0, tid);
		Teacher t=(Teacher)query1.uniqueResult();
		
		ClassCourse cc=new ClassCourse();
		cc.setClass_name(className);
		cc.setCourse(c);
		cc.setTeacher(t);
		
		session.save(cc);
		
		
//		tx.commit();
		System.out.println("createClass");
	}
	
	public void addTimes(String weeks,String node,String date,String className) {
//		String hql = "update Times times set times.c_week =:var1 ,"
//				+ "times.c_date =:var2 ,"
//				+ "times.nodeNumber.node_id = ("
//				+ "select nodenumber.node_id from NodeNumber nodenumber where nodenumber.node =:var3 ),"
//				+ "times.classin.class_id = ("
//				+ "select classcourse.class_id from ClassCourse classcourse where classcourse.class_name =:var4 )";
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ClassCourse where class_name=?");
		query.setParameter(0,className);
		ClassCourse classCourse = (ClassCourse)query.uniqueResult();
		
		Query query1 = session.createQuery("from NodeNumber where node=?");
		query1.setParameter(0,node);
		NodeNumber  nodeNumber = (NodeNumber)query1.uniqueResult();
		
		Times times = new Times();
		times.setC_week(weeks);
		times.setC_date(date);
		times.setClassin(classCourse);
		times.setNodeNumber(nodeNumber);
		
		session.save(times);
		
		System.out.println("addTimes");
	}
	
}
