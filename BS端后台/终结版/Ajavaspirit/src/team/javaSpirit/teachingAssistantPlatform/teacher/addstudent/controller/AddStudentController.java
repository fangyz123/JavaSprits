package team.javaSpirit.teachingAssistantPlatform.teacher.addstudent.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import team.javaSpirit.teachingAssistantPlatform.teacher.addstudent.service.AddStudentService;

@Controller
public class AddStudentController {
	
	@SuppressWarnings("finally")
	public static List<String> readExcel(String path){
		String filetype = path.substring(path.lastIndexOf(".")+1);
		//return a list contains many list
		List<String> list = new ArrayList<String>();
		//读取excel文件
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			//获取工作簿
			Workbook wb = null;
			if(filetype.equals("xls")) {
				wb = new HSSFWorkbook(is);
			}else if(filetype.equals("xlsx")) {
				wb = new XSSFWorkbook(is);
			}else {
				return null;
			}
			
			//读取第一个工作页sheet
			Sheet sheet = wb.getSheetAt(0);
			//总行数
			int rowLength = sheet.getLastRowNum();
			//工作表的行
			Row row = sheet.getRow(0);
			//总列数
			int colLength = row.getLastCellNum();
			//得到指定的单元格
			Cell cell = row.getCell(0);
			
			for(int i=1;i<rowLength;i++) {
				row = sheet.getRow(i);//取得第i行
				cell = row.getCell(0);//取得第i行的第一列
				
				String cellValue = cell.getStringCellValue().trim();
				list.add(cellValue);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return list;
	}
	
	@Resource
	private AddStudentService addStudentService;
	
	@RequestMapping("Teacher/addStudent")
	public String addStudentControllerImpl(HttpServletRequest request,Model model) {
		String classname = request.getParameter("className");
		model.addAttribute("classname", classname);
		
		request.setAttribute("className", classname);
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
			
			List<String> lists = readExcel(rootpath+"upload\\"+filename);
			List<String> snolist = lists;//第一列学号

			String classname = request.getParameter("classname");
			System.out.println(classname);
			for(int i = 0;i<lists.size();i++) {
				this.addStudentService.addStudentServiceImpl(lists.get(i), classname);
				System.out.println(lists.get(i));
				System.out.println(classname);
			}
			
//			System.out.println(snolist);

			
			
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
