package team.javaSpirit.teachingAssistantPlatform.signIn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.login.dao.LoadStudentDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.signIn.dao.RecordDao;

public class SignRankService {
	/**
	 * 获取每周签到排名
	 * <p>Title: getEveSingRank</p>
	 * <p>Description: </p>
	 */
	public List<Students> getEveSignRank() {
		StudentCourseService scs=new StudentCourseService();
		Date begin=scs.getBegin();
		Long week=scs.getWeek();
		Date date1=new Date(begin.getTime()+(week-3)*7*24*60*60*1000);
		Date date2=new Date(begin.getTime()+((week-3)*7+5)*24*60*60*1000);
		List<String> list=new RecordDao().SearchSignRank(date1, date2);
		List<Students> students=new ArrayList<Students>();
		for(String sid:list) {
			Students student=new LoadStudentDaoImpl().getStudentById(sid);
			students.add(student);
		}
		return students;
	}
}
