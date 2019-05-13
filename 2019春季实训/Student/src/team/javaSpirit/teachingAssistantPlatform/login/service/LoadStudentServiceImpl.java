package team.javaSpirit.teachingAssistantPlatform.login.service;

import java.util.Date;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.LoadStudent;
import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.entity.Studentstatus;
import team.javaSpirit.teachingAssistantPlatform.login.dao.LoadStudentDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.util.IpUtil;

/**
 * <p>
 * Title: LoadStudentService
 * </p>
 * <p>
 * Description: Students数据库逻辑代码实现
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月13日
 */
public class LoadStudentServiceImpl {

	/* 跟数据库交互的对象 */
	private LoadStudentDaoImpl loadStudentDaoImpl;

	public LoadStudentServiceImpl() {
		loadStudentDaoImpl = new LoadStudentDaoImpl();
	}

	/**
	 * 
	 * <p>
	 * Title: checkLoginStudent
	 * </p>
	 * <p>
	 * Description: 登陆验证学生学号，密码，状态是否正确
	 * </p>
	 * 
	 * @param sid
	 * @param password
	 * @return 用户不存在返回1，状态不是1返回2，密码不正确返回3，信息正确返回4
	 */
	public int checkLoginStudent(String sid, String password) {
		Students s = this.loadStudentDaoImpl.getStudentById(sid);
		if (s == null) {
			return 1;
		} else {
			if (s.getState() != 1) {
				return 2;
			} else if (s.getPassword().equals(password)) {
				Studentstatus ss=this.loadStudentDaoImpl.checkStatus(s.getSid());
				if(ss.getRecord_status()==0) {
					String ip = IpUtil.getRealIP();
					Students st = this.loadStudentDaoImpl.updateStudentIp(s, ip);
					Constant.myStudent = st;
					LoadStudent ls = new LoadStudent();
					ls.setLogin_time(new Date());
					ls.setStudent(st);
					loadStudentDaoImpl.saveLoadStudent(ls);
					this.loadStudentDaoImpl.updateStatus(s.getSid());
					return 4;
				}
				else
					return 5;
			} else {
				return 3;
			}
		}
	}

	/**
	 * 
	 * <p>
	 * Title: checkModifyStudent
	 * </p>
	 * <p>
	 * Description: 检验学生修改密码是否正确
	 * </p>
	 * 
	 * @param sid
	 * @param pwd
	 * @param conpwd
	 * @return 用户不存在返回1，用户旧密码不匹配返回2，密码不匹配返回3，信息无误返回4
	 */
	public int checkModifyStudent(String sid, String oldpwd, String pwd, String conpwd) {
		Students s = this.loadStudentDaoImpl.getStudentById(sid);
		if (s == null)
			return 1;
		else if (!oldpwd.equals(s.getPassword()))
			return 2;
		else if (!pwd.equals(conpwd))
			return 3;
		else {
			this.loadStudentDaoImpl.updateStudentPassword(s, pwd);
			return 4;
		}
	}

}
