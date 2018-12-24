package team.javaSpirit.teachingAssistantPlatform.teacher.createclass.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.teacher.createclass.dao.SearchClassCourseDao;

@Service
@Transactional(readOnly=true)
public class SearchClassCourseService {
	@Resource
	private SearchClassCourseDao searchclasscoursedao;
	
	public String searchClassServiceImpl(String name){
		return this.searchclasscoursedao.searchClassCourse(name);
	}
	
}
