package team.javaSpirit.teachingAssistantPlatform.student.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.student.dao.StudentDao;

@Service
@Transactional(readOnly=false)
public class StudentService {
	@Resource
	private StudentDao  studentdao;
	public void changePassword(String sid,String word) {
		studentdao.updatePassword(sid, word);
	}
	public void addLeavePaper(String name,String path,String course,String teacher) {
		//int class_id=this.studentdao.findClassId(course, teacher);
		int class_id=this.studentdao.findSubmit(teacher, course, name);
		this.studentdao.insertLeavePaper(name, path,class_id);
	}
	public List<LeavePaper> searchPicture(String username){
		return this.studentdao.findPicture(username);
	}
	public boolean searchCourse(String course) {
		return this.studentdao.findCourse(course);
	}
	public boolean searchTeacher(String teacher) {
		return this.studentdao.findTeacher(teacher);
	}
	public boolean searchSubmit(String teacher,String course,String sid) {
		int key=this.studentdao.findSubmit(teacher,course,sid);
		if(key==0) {
			return false;
		}else {
			return true;
		}
	}
}
