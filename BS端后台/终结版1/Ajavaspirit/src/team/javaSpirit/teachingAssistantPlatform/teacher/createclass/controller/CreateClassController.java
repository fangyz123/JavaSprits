package team.javaSpirit.teachingAssistantPlatform.teacher.createclass.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import team.javaSpirit.teachingAssistantPlatform.teacher.createclass.service.CreateClassService;
import team.javaSpirit.teachingAssistantPlatform.teacher.createclass.service.SearchClassCourseService;

@Controller
public class CreateClassController {
	@Resource
	private CreateClassService createClassService;
	@Resource
	private SearchClassCourseService searchclasscourseservice;
	
	@RequestMapping("Teacher/searchClassName")
	public void searchClassName(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String className = request.getParameter("className");
		System.out.println(className);
		String li = this.searchclasscourseservice.searchClassServiceImpl(className);
		System.out.println("li:"+li);
		if(li==null) {
			response.getWriter().print("ok");
			
		}else {
			response.getWriter().print("fail");
		}
		
		
	}
	
	
	@RequestMapping("Teacher/createClass")
	public String createClass(HttpServletRequest request,HttpServletResponse response,Model model) {
		String className = request.getParameter("className");	
		String courseName = request.getParameter("cname");
		String weeks = request.getParameter("weekcount");
		String cishu = request.getParameter("cishu");
		String tid =(String)request.getSession().getAttribute("username");
		createClassService.createclassServiceImpl(className, courseName, tid);
		System.out.println(className);
		System.out.println(courseName);
		System.out.println(weeks);
		System.out.println(cishu);
		for (int i = 0; i < Integer.parseInt(cishu) ; i++) {
			String date = request.getParameter("weekdate"+String.valueOf(i+1));
			System.out.println(date);
			String node = request.getParameter("nodeselect"+String.valueOf(i+1));
			System.out.println(node);
			createClassService.addTimesServiceImpl(weeks, node, date, className);
		}
		request.setAttribute("classname", className);
		//model.addAttribute("classname", className);
		//return "Teacher/successcreateclass";
		return "Teacher/addstudent";
	}
}
