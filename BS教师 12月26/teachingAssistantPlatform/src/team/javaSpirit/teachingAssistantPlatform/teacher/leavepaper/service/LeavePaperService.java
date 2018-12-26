package team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.entity.LeavePaper;
import team.javaSpirit.teachingAssistantPlatform.teacher.leavepaper.dao.LeavePaperDao;

@Service
@Transactional(readOnly=true)
public class LeavePaperService {

	@Resource
	private LeavePaperDao leavePaperDao;
	
	public List<LeavePaper> findAllpaper(){
		return this.leavePaperDao.findALL();
	}
}
