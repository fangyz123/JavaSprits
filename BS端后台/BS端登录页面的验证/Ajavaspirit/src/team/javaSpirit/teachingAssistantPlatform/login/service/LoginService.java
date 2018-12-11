package team.javaSpirit.teachingAssistantPlatform.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.javaSpirit.teachingAssistantPlatform.login.dao.LoginDao;
/**
 * 
* <p>Title: LoginService</p>
* <p>Description: B/S端登录验证的service</p>
* @author 何慧霞
* @date 2018年12月11日
 */
@Service
@Transactional(readOnly=false)
public class LoginService {
	@Resource
	private LoginDao logindao;
	/**
	 * 
	 * <p>Title: IsUserName</p>
	 * <p>Description: 查找相关角色的表中是否有次用户</p>
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
	 * <p>Description:验证当前用户和密码是否能够完整的登录 </p>
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
	 * <p>Description: 登录成功后进行相关的角色的插入</p>
	 * @param name
	 * @param role
	 */
	public void insertLogin(String name,String role) {
		logindao.putLogin(name, role);
	}

}
