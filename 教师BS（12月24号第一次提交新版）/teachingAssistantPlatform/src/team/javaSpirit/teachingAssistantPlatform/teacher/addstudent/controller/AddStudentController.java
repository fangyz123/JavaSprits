package team.javaSpirit.teachingAssistantPlatform.teacher.addstudent.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AddStudentController {
	
	@RequestMapping("Teacher/addStudent")
	public String addStudentControllerImpl(HttpServletRequest request,Model model) {
		String classname = request.getParameter("className");
		model.addAttribute("classname", classname);
		
		return "Teacher/addstudent";
	}
	
	@RequestMapping("Teacher/upload")
	public String uploadFile(MultipartFile uploadFile,HttpServletRequest request) {
		//获取文件名
		String filename = uploadFile.getOriginalFilename();
		String rootpath = request.getServletContext().getRealPath("/");

		System.out.println(filename);
		
		File newFile = new File(rootpath+"upload",filename);
		
		try {
			System.out.println("123");
			uploadFile.transferTo(newFile);
			System.out.println("上传完成");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Teacher/successupload";
	}
}
