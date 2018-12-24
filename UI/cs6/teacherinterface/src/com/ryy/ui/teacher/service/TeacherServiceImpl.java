package com.ryy.ui.teacher.service;

import java.util.Date;

import com.ryy.ui.entity.LoadTeacher;
import com.ryy.ui.entity.Teacher;
import com.ryy.ui.login.dao.LoadTeacherDaoImpl;
import com.ryy.ui.teacher.dao.TeacherDaoImpl;
import com.ryy.ui.util.IpUtil;

/**
 * 
* <p>Title: TeacherServiceImpl</p>
* <p>Description:对老师登录实现的业务逻辑 </p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class TeacherServiceImpl {
	private TeacherDaoImpl teacherDaoImpl;
	private LoadTeacherDaoImpl loadTeacherDaoImpl;
	public TeacherServiceImpl(){
		teacherDaoImpl=new TeacherDaoImpl();
		loadTeacherDaoImpl=new LoadTeacherDaoImpl();
	}
	/**
	 * 
	 * <p>Title: checkLoginTeacher</p>
	 * <p>Description: 从数据中查询检验老师信息并返回查询标志，1表示用户不存在，2表示该用户不能登陆，3表示密码不正确，4表示信息无误</p>
	 * @param username
	 * @param password
	 * @return
	 */
	public int checkLoginTeacher(String username,String password) {
		Teacher s=this.teacherDaoImpl.getTeacherById(username);
		if(s==null) {
			return 1;
		}else {
			if(s.getState()!=1) {
				return 2;
			}else if(s.getPassword().equals(password)) {
				String ip=IpUtil.getRealIP();
				Teacher t=this.teacherDaoImpl.updateTeacherIp(s, ip);
				//向登录表中插入信息
				LoadTeacher lt=new LoadTeacher();lt.setLogin_time(new Date());lt.setTeacher(t);
				this.loadTeacherDaoImpl.saveLoadTeacher(lt);
				return 4;
			}else {
				return 3;
			}
		}
	}
	/**
	 * 
	 * <p>Title: checkModifyTeacher</p>
	 * <p>Description: 检验修改密码从数据哭中查询检验并返回标志信息，1表示用户不存在，2表示旧密码不匹配，3表示前后密码不一致，4表示信息无误</p>
	 * @param username
	 * @param oldpwd
	 * @param pwd
	 * @param conpwd
	 * @return
	 */
	public int checkModifyTeacher(String username,String oldpwd,String pwd,String conpwd) {
		Teacher t=this.teacherDaoImpl.getTeacherById(username);
		if(t==null) 
			return 1;
		else if(oldpwd.equals(t.getPassword()))
			return 2;
		else if(!pwd.equals(conpwd))
			return 3;
		else {
			this.teacherDaoImpl.updateTeacherPassword(t, pwd);
			return 4;
		}
	}
}
