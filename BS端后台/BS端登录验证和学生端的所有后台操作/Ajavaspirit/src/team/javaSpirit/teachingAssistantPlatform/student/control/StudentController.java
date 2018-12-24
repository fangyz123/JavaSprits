package team.javaSpirit.teachingAssistantPlatform.student.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.student.service.StudentService;

@Controller
public class StudentController {
	@Resource
	private StudentService studentservice;
	
	@RequestMapping("/change")
	public void changeNews(HttpServletRequest request) {
		System.out.println("change");
		Object obj=request.getServletContext().getAttribute("username");
		String sid=(String)obj;
		String password=request.getParameter("password");
		studentservice.changePassword(sid, password);
		System.out.println(password);
	}
	
	
	
	
	@RequestMapping("/leave")
	public String tosubmit(@RequestParam(value="file") MultipartFile file,
            HttpServletRequest request) throws IllegalStateException, IOException {
		String values=request.getParameter("file");//�ϴ��ļ���value���ǿյ�
		String course=request.getParameter("course");
		String teacher=request.getParameter("tea");
		System.out.println("leaev");
		//�ϴ�ͼƬ
		String rootPath=request.getServletContext().getRealPath("/");
		String o=rootPath+"/"+"upload/";
		String name=(String)request.getServletContext().getAttribute("username");
		//Random ra =new Random();
		
		//(int)(1+Math.random()*(10-1+1));
		String nameNow=name+file.getOriginalFilename();
		File targetFile = new File(o, nameNow);
		if (!targetFile.exists()) {
		    targetFile.mkdirs();
		}
		file.transferTo(targetFile);
		
		//�������Ϣ�������ݿ���
		String path="upload/"+nameNow;
		//String path="upload/"+file.getOriginalFilename();
		this.studentservice.addLeavePaper(name, path,course,teacher);
		
		return "redirect:student/qingjia.jsp";
		//��ȡ����·�������Һ��������/
		/*if(!file.isEmpty()){
			try {
				//+"/"
				
				InputStream is=file.getInputStream();
				String o=rootPath+"/"+"upload/"+file.getOriginalFilename();
				//ע��\��ת���ַ�����˼��
				System.out.println(o);
				FileOutputStream fos=new FileOutputStream(o);
				byte []cache=new byte[is.available()];
				fos.write(cache);
				fos.flush();
				is.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	@RequestMapping("/qingjia")
	public String changeDiv(HttpServletRequest request) {
		String exists="up";
		request.getServletContext().setAttribute("exists", exists);
		return "redirect:student/qingjia.jsp";
	}
	@RequestMapping("/changedown")
	public String changedown(HttpServletRequest request,HttpServletResponse response) {
		String exists="down";
		request.getServletContext().setAttribute("exists", exists);
		String username=(String)request.getServletContext().getAttribute("username");
		List<LeavePaper> set=this.studentservice.searchPicture(username);
		request.getServletContext().setAttribute("pictures", set);
		return "redirect:student/papers.jsp";
	}
	@RequestMapping("/judgeCourse")
	public void judgeCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String course=request.getParameter("course");
		//�����ݿ��в�������γ��Ƿ����
		boolean exist=this.studentservice.searchCourse(course);
		if(exist) {
			System.out.println("ok");
			response.getWriter().print("ok");
		}else {
			System.out.println("buok");
			response.getWriter().print("false");
		}
		
	}
	@RequestMapping("/judgeTeacher")
	public void judgeTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String teacher=request.getParameter("teacher");
		//�����ݿ��в��������ʦ�Ƿ����
		boolean exist=this.studentservice.searchTeacher(teacher);
		if(exist) {
			System.out.println("ok");
			response.getWriter().print("ok");
		}else {
			System.out.println("buok");
			response.getWriter().print("false");
		}
	}

}
