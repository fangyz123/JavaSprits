package team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.service.LeavePaperService;

@Controller
public class LeavePaperController {
	@Resource
	private LeavePaperService leavePaperService;
	
	@RequestMapping("Teacher/leavepaper")
	public String showleavePaper(Model model) {
		
		List<LeavePaper> list1 = this.leavePaperService.findAllpaper();
		List<LeavePaper> list2 = new ArrayList<LeavePaper> ();
		for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i).getStatus()==0) {
				list2.add(list1.get(i));
			}
		}
		model.addAttribute("statu", list2);
		return "Teacher/leave";
	}
}
