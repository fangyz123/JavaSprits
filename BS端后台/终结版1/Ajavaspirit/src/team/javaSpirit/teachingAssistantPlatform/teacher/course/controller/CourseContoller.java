package team.javaSpirit.teachingAssistantPlatform.teacher.course.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import team.javaSpirit.teachingAssistantPlatform.teacher.course.service.CourseService;
import team.javaSpirit.teachingAssistantPlatform.teacher.course.service.SearchCourseService;

@Controller
@ResponseBody
public class CourseContoller {
	@Resource
	private CourseService courseService;
	@Resource
	private SearchCourseService searchCourse;
	
	@RequestMapping("/create")
	public void course(HttpServletResponse respone,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		respone.setCharacterEncoding("utf-8");
		String cname = request.getParameter("course");
		System.out.println(cname);
		System.out.println("1");
//		List<String> course=courseService.courseList();
		List<String> searchCourse = this.searchCourse.searchCourse(cname);
		System.out.println(searchCourse);
		StringBuffer s=new StringBuffer();
		s.append("[");
		for (int i = 0; i < searchCourse.size(); i++) {
			if (i==searchCourse.size()-1) {
				s.append("'"+searchCourse.get(i)+"'"+"]");
			}else {
				s.append("'"+searchCourse.get(i)+"'"+",");
			}
		}
		respone.getWriter().print(s);	
		
	}
	
	@RequestMapping("Teacher/Courses")
	public void acquier(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String cname = request.getParameter("course");
		System.out.println(cname);
		String acquier = this.courseService.courseList(cname);
		if(acquier==null) {
			response.getWriter().print("f");
		}else {
			response.getWriter().print("ok");
		}
	}
	
}
