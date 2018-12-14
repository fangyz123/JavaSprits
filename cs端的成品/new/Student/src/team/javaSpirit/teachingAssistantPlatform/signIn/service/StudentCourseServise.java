package team.javaSpirit.teachingAssistantPlatform.signIn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.entity.Times;
import team.javaSpirit.teachingAssistantPlatform.signIn.dao.StudentCourseDao;

public class StudentCourseServise {

	private StudentCourseDao studentCourse = new StudentCourseDao();

	public void findCurrentCourse(String sid) throws ParseException {
		// 开学日期
		Date begin = studentCourse.getStartTime();
		String startT=studentCourse.getBeginTime(2);
		System.out.println("开学" + begin);
		Date current = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t=dateFormat.format(current);
		System.out.println("当前"+t);
		long days=(current.getTime()-begin.getTime())/(1000*60*60*24)+1;
		System.out.println("相差多少天："+days);
		long week=days/7;
		System.out.println("第几周："+week);
		long w=days%7;
		System.out.println("星期几"+w);
		String t1=t+" "+startT;
		Date d=dateFormat1.parse(t1);
		long m=(current.getTime()-d.getTime())/(1000*60);
		System.out.println("相差多少分："+m);
		// 这个学生所上的课
		List<Integer> course = studentCourse.allCourseBysid(sid);
//		for (Integer cid : course) {
//			List<Times> courseTime = studentCourse.allTimeBycid(cid);
//
//		}
		studentCourse.closeSessionFactory();
	}

	public static void main(String[] args) {
		StudentCourseServise ss=new StudentCourseServise();
		try {
			ss.findCurrentCourse("2016011357");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

	}

}
