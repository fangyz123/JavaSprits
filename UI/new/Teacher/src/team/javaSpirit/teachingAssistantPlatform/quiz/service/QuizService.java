package team.javaSpirit.teachingAssistantPlatform.quiz.service;

import java.util.ArrayList;
import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.Course;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.quiz.dao.QuizDao;


public class QuizService {
	
	
	public QuizService() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	/**
	 * <p>
	 * Title: searchSid
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	public List<String> searchclassname(String tid) {
		QuizDao quizdao=new QuizDao();
		List<ClassCourse> list =quizdao.searchSidByClasscourse(tid);
		List<String> l = new ArrayList<String>();
		for(ClassCourse i:list) {
			String cln=i.getClass_name();
			String cn=i.getCourse().getCname();
			l.add(cn+" "+cln);
			}
	
		return l;
	}


	
}
