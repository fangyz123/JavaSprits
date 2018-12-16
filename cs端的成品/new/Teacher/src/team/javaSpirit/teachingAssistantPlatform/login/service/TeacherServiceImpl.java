package team.javaSpirit.teachingAssistantPlatform.login.service;

import java.util.Date;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.LoadTeacher;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.login.dao.LoadTeacherDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.util.IpUtil;

/**
 * 
 * <p>
 * Title: TeacherServiceImpl
 * </p>
 * <p>
 * Description:对老师登录实现的业务逻辑
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月13日
 */
public class TeacherServiceImpl {
	private LoadTeacherDaoImpl loadTeacherDaoImpl;

	public TeacherServiceImpl() {
		loadTeacherDaoImpl = new LoadTeacherDaoImpl();
	}

	/**
	 * 
	 * <p>
	 * Title: checkLoginTeacher
	 * </p>
	 * <p>
	 * Description: 从数据中查询检验老师信息并返回查询标志，1表示用户不存在，2表示该用户不能登陆，3表示密码不正确，4表示信息无误
	 * </p>
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int checkLoginTeacher(String username, String password) {
		Teacher s = this.loadTeacherDaoImpl.getTeacherById(username);
		if (s == null) {
			return 1;
		} else {
			if (s.getState() != 1) {
				return 2;
			} else if (s.getPassword().equals(password)) {
				String ip = IpUtil.getRealIP();
				Teacher t = this.loadTeacherDaoImpl.updateTeacherIp(s, ip);
				Constant.myTeacher=t;
				// 向登录表中插入信息
				LoadTeacher lt = new LoadTeacher();
				lt.setLogin_time(new Date());
				lt.setTeacher(t);
				this.loadTeacherDaoImpl.saveLoadTeacher(lt);
				return 4;
			} else {
				return 3;
			}
		}
	}

	/**
	 * 
	 * <p>
	 * Title: checkModifyTeacher
	 * </p>
	 * <p>
	 * Description: 检验修改密码从数据哭中查询检验并返回标志信息，1表示用户不存在，2表示旧密码不匹配，3表示前后密码不一致，4表示信息无误
	 * </p>
	 * 
	 * @param username
	 * @param oldpwd
	 * @param pwd
	 * @param conpwd
	 * @return
	 */
	public int checkModifyTeacher(String username, String oldpwd, String pwd, String conpwd) {
		Teacher t = this.loadTeacherDaoImpl.getTeacherById(username);
		if (t == null)
			return 1;
		else if (!oldpwd.equals(t.getPassword()))
			return 2;
		else if (!pwd.equals(conpwd))
			return 3;
		else {
			this.loadTeacherDaoImpl.updateTeacherPassword(t, pwd);
			return 4;
		}
	}
}
