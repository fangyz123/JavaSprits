package team.javaSpirit.teachingAssistantPlatform.teacher.addstudent.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.teacher.addstudent.dao.AddStudentDao;

@Service
@Transactional(readOnly=false)
public class AddStudentService {
	@Resource
	private AddStudentDao addStudentDao;
	
	public void addStudentServiceImpl(String sid,String className) {
		this.addStudentDao.addStudent(sid, className);
	}
}
