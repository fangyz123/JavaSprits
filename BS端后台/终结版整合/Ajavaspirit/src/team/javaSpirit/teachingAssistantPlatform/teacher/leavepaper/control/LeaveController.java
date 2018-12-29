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
	 * <p>Description:点击审核假条时跳转到此，展示所有未审核的假条 </p>
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
	 * <p>Description: 教师每审核一张图片就会跳转到这里，更改数据库然后再跳转回去</p>
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
	 * <p>Description:点击查看所有图片的时候就跳转到这里，查看所有的图片然后展示 </p>
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
