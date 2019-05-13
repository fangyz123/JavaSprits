package team.javaSpirit.teachingAssistantPlatform.teacher.changepassword.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import team.javaSpirit.teachingAssistantPlatform.teacher.changepassword.service.PasswordService;

@Controller
public class PasswordController {
	@Resource
	private PasswordService passwordservice;
	
	@RequestMapping("/Teacher/password")
	public String changeTeacherWord(HttpServletRequest request) {
		System.out.println("gaimima");
		String word=request.getParameter("password");
		String tid=(String)request.getSession().getAttribute("username");
		this.passwordservice.changeWord(tid, word);
		return "redirect:../Teacher/index.jsp";
	}
	

}
