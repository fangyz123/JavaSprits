package team.javaSpirit.teachingAssistantPlatform.teacher.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.entity.Course;
import team.javaSpirit.teachingAssistantPlatform.teacher.course.dao.CourseDao;

@Service
@Transactional(readOnly=true)
public class CourseService {
	@Resource
	private CourseDao courseDao;
	
	public String courseList(String coursename){
		return this.courseDao.findAll(coursename);
	}
}
