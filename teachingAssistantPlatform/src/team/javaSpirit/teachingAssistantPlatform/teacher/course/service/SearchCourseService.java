package team.javaSpirit.teachingAssistantPlatform.teacher.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.teacher.course.dao.SearchCourseDao;

@Service
@Transactional(readOnly=true)
public class SearchCourseService {
	@Resource
	private SearchCourseDao searchCourseDao;
	
	public List<String> searchCourse(String cname){
		return this.searchCourseDao.SearchCourse(cname);
	}
}
