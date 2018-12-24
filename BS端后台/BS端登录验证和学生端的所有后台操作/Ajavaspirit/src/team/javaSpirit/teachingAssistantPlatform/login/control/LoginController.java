package team.javaSpirit.teachingAssistantPlatform.login.control;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team.javaSpirit.teachingAssistantPlatform.login.service.LoginService;
/**
 * 
* <p>Title: LoginController</p>
* <p>Description: </p>
* @author 何慧霞
* @date 2018年12月13日
 */
@Controller
public class LoginController {
	//登录控制器
	
	@Resource
	private LoginService loginservice;
	//判断用户名是否在数据库中
	@RequestMapping(value="/judgeUserName",method=RequestMethod.POST)
	public void judgeUserName(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("control");
		String name=request.getParameter("username");
		String role=request.getParameter("role");
		System.out.println(role);
		boolean exist=loginservice.IsUserName(name,role);
		if(exist) {
			System.out.println("ok");
			response.getWriter().print("ok");
		}else {
			System.out.println("buok");
			response.getWriter().print("false");
		}
	}
	//判断用户名和密码是否一致
	@RequestMapping(value="/judgeLogin",method=RequestMethod.POST)
	public void judgeLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("login");
		String name=request.getParameter("username");
		String word=request.getParameter("password");
		String role=request.getParameter("role");
		boolean exist=loginservice.canLogin(name, word, role);
		if(exist) {
			System.out.println("密码正确");
			response.getWriter().print("ok");
		}else {
			System.out.println("密码错误");
			response.getWriter().print("false");
		}
	}
	
	//登录后把登录信息插入表中并且跳转页面
	@RequestMapping(value="/login")
	public String  login(HttpServletRequest request) {
		System.out.println("insert");
		String name=request.getParameter("username");
		String word=request.getParameter("password");
		String role=request.getParameter("identity");
		loginservice.insertLogin(name, role);
		//把学号存入数据
		request.getServletContext().setAttribute("username", name);
		String username=this.loginservice.findNameUsing(name, role);
		//把名字存入
		request.getServletContext().setAttribute("name", username);
		if(role.equals("teacher")) {
			return "redirect:teacher/index.jsp";
			
		}else if(role.equals("student")) {
			return "redirect:student/index.jsp";
		}else {
			return null;
		}
	}
	

}
