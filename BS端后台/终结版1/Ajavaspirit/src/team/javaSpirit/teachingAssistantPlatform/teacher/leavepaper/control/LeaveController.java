package team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.control;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import team.javaSpirit.teachingAssistantPlatform.entity.ClassCourse;
import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.service.LeaveService;

@Controller
public class LeaveController {
	@Resource
	private LeaveService service;
	/**
	 * 
	 * <p>Title: turn</p>
	 * <p>Description:�����˼���ʱ��ת���ˣ�չʾ����δ��˵ļ��� </p>
	 * @param request
	 * @return
	 */
	@RequestMapping("/Teacher/turn")
	public String turn (HttpServletRequest request) {
		String tid=(String)request.getSession().getAttribute("username");
		List<LeavePaper> list=this.service.searchPicture(tid);
		Set<ClassCourse> l=this.service.searchClassCourse(tid);
		request.getSession().setAttribute("teacherother", l);
		request.getSession().setAttribute("teacherpaper",list);
		return "redirect:papers.jsp";
		//return "redirect:leave.jsp";
	}
	
	/**
	 * 
	 * <p>Title: check</p>
	 * <p>Description: ��ʦÿ���һ��ͼƬ�ͻ���ת������������ݿ�Ȼ������ת��ȥ</p>
	 * @param request
	 * @return
	 */
	@RequestMapping("/Teacher/check")
	public String check (HttpServletRequest request) {
		String check=request.getParameter("check");
		String sid=request.getParameter("sid");
		String id=request.getParameter("id");
		this.service.judgeInsert(check,sid,id);
		return "redirect:turn";
	}
	/**
	 * 
	 * <p>Title: showall</p>
	 * <p>Description:����鿴����ͼƬ��ʱ�����ת������鿴���е�ͼƬȻ��չʾ </p>
	 * @param request
	 * @return
	 */
	@RequestMapping("/Teacher/showall")
	public String showall (HttpServletRequest request) {
		String tid=(String)request.getSession().getAttribute("username");
		List<LeavePaper> list=this.service.searchAllPicture(tid);
		Set<ClassCourse> l=this.service.searchClassCourse(tid);
		request.getSession().setAttribute("allother", l);
		request.getSession().setAttribute("allpaper",list);
		//return "redirect:havechecked.jsp";
		return "redirect:allpapers.jsp";
	}

}
