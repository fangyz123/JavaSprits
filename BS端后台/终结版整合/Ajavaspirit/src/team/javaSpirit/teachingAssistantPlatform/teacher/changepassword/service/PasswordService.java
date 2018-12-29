package team.javaSpirit.teachingAssistantPlatform.teacher.changepassword.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.teacher.changepassword.dao.PasswordDao;

@Service
@Transactional(readOnly=false)
public class PasswordService {
	@Resource
	private PasswordDao paddworddao;
	public void changeWord(String tid,String word) {
		this.paddworddao.updatePassword(tid, word);
	}
	

}
