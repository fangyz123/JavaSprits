package team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.dao.LeaveDao;

@Service
public class LeaveService {
	@Resource
	private LeaveDao dao;
	//查询当前老师所有上的课程
	public Set<ClassCourse> searchClassCourse(String tid){
		return this.dao.findclass(tid);
	}
	/**
	 * 
	 * <p>Title: searchClassId</p>
	 * <p>Description:查询当前老师的所有class_id </p>
	 * @param tid
	 * @return
	 */
	public List<Integer> searchClassId(String tid) {
		
		Set<ClassCourse> s=  this.searchClassCourse(tid);
		List list=new ArrayList();
		for(ClassCourse i:s) {
			list.add(i.getClass_id());
		}
		return list;
	}
	/**
	 * 
	 * <p>Title: searchPicture</p>
	 * <p>Description:查询所有的假条 </p>
	 * @param tid
	 * @return
	 */
	public List<LeavePaper> searchPicture(String tid){
		List<Integer> list=this.searchClassId(tid);
		System.out.println(list);
		List<LeavePaper> l= this.dao.findPicture(list);
		return l;
	}
	public void judgeInsert(String check,String sid,String iid) {
		int status=0;
		if(check.equals("agree")) {
			status=1;
		}else {
			status=2;
		}
		int id=0;
		if(iid!=null) {
			
			 id=Integer.parseInt(iid);
		}
		this.dao.updatePaper(status,id);
		this.dao.updateStudent(sid);
	}
	/**
	 * 
	 * <p>Title: searchAllPicture</p>
	 * <p>Description:展示所有的图片 </p>
	 * @param tid
	 * @return
	 */
	public List<LeavePaper> searchAllPicture(String tid){
		List<Integer> list=this.searchClassId(tid);
		
		List<LeavePaper> l= this.dao.findAllPicture(list);
		return l;
	}

}
