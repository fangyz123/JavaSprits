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
* <p>Description: ����֤B/S�˵ĵ�¼�Ŀ�����</p>
* @author �λ�ϼ
* @date 2018��12��11��
 */
@Controller
public class LoginController {
	//�ж��Ƿ��Ѿ�ע��
	
	@Resource
	private LoginService loginservice;
	
	@RequestMapping(value="/judgeUserName",method=RequestMethod.POST)
	public void judgeUserName(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("control");
		String name=request.getParameter("username");
		String role=request.getParameter("role");
		System.out.println(role);
		boolean exist=loginservice.IsUserName(name,role);
		if(exist) {
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("false");
		}
	}
	//����û����������Ƿ���ȷ
	@RequestMapping(value="/judgeLogin",method=RequestMethod.POST)
	public void judgeLogin(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("login");
		String name=request.getParameter("username");
		String word=request.getParameter("password");
		String role=request.getParameter("role");
		boolean exist=loginservice.canLogin(name, word, role);
		if(exist) {
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("false");
		}
	}
	
	//��¼�ɹ���������ݺ������ת
	@RequestMapping(value="/login")
	public void login(HttpServletRequest request) {
		System.out.println("insert");
		String name=request.getParameter("username");
		String word=request.getParameter("password");
		String role=request.getParameter("identity");
		loginservice.insertLogin(name, role);
	}
	

}
