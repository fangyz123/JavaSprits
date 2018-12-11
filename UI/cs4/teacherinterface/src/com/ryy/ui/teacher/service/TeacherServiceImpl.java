package com.ryy.ui.teacher.service;

import java.util.Date;

import com.ryy.ui.entity.LoadTeacher;
import com.ryy.ui.entity.Teacher;
import com.ryy.ui.login.dao.LoadTeacherDaoImpl;
import com.ryy.ui.teacher.dao.TeacherDaoImpl;
import com.ryy.ui.util.IpUtil;


public class TeacherServiceImpl {
	private TeacherDaoImpl teacherDaoImpl;
	private LoadTeacherDaoImpl loadTeacherDaoImpl;
	public TeacherServiceImpl(){
		teacherDaoImpl=new TeacherDaoImpl();
		loadTeacherDaoImpl=new LoadTeacherDaoImpl();
	}
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
				LoadTeacher lt=new LoadTeacher();lt.setLogin_time(new Date());lt.setTeacher(t);
				this.loadTeacherDaoImpl.saveLoadTeacher(lt);
				return 4;
			}else {
				return 3;
			}
		}
	}
	public int checkModifyTeacher(String username,String pwd,String conpwd) {
		Teacher t=this.teacherDaoImpl.getTeacherById(username);
		if(t==null) 
			return 1;
		else if(!pwd.equals(conpwd))
			return 2;
		else {
			this.teacherDaoImpl.updateTeacherPassword(t, pwd);
			return 3;
		}
	}
}
