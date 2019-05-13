package team.javaSpirit.teachingAssistantPlatform.teacher.createclass.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.teacher.createclass.dao.CreateClassDao;

@Service
@Transactional(readOnly=false)
public class CreateClassService {
	@Resource
	private CreateClassDao createClassDao;
	
	public void createclassServiceImpl(String className,String courseName,String tid) {
		this.createClassDao.createClass(className, courseName, tid);
	}
	
	public void addTimesServiceImpl(String weeks,String node,String date,String className) {
		this.createClassDao.addTimes(weeks, node, date, className);
	}
}
