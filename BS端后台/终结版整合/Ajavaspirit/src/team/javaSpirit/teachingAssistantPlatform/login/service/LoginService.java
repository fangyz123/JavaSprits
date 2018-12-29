package team.javaSpirit.teachingAssistantPlatform.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.login.dao.LoginDao;
/**
 * 
* <p>Title: LoginService</p>
* <p>Description: B/S�˵�¼��֤��service</p>
* @author �λ�ϼ
* @date 2018��12��11��
 */
@Service
@Transactional(readOnly=false)
public class LoginService {
	@Resource
	private LoginDao logindao;
	/**
	 * 
	 * <p>Title: IsUserName</p>
	 * <p>Description: ������ؽ�ɫ�ı����Ƿ��д��û�</p>
	 * @param username
	 * @param role
	 * @return
	 */
	public boolean IsUserName(String username,String role) {
		return logindao.findUserName(username,role);
		
	}
	/**
	 * 
	 * <p>Title: canLogin</p>
	 * <p>Description:��֤��ǰ�û��������Ƿ��ܹ������ĵ�¼ </p>
	 * @param name
	 * @param word
	 * @param role
	 * @return
	 */
	public boolean canLogin(String name,String word,String role) {
		return logindao.findLogin(name, word, role);
	}
	
	/**
	 * 
	 * <p>Title: insertLogin</p>
	 * <p>Description: ��¼�ɹ��������صĽ�ɫ�Ĳ���</p>
	 * @param name
	 * @param role
	 */
	public void insertLogin(String name,String role) {
		logindao.putLogin(name, role);
	}
	public String findNameUsing(String username,String role) {
		return this.logindao.findNameByNum(username, role);
	}
}
