package com.ryy.ui.student.service;

import java.util.Date;

import com.ryy.common.Constant;
import com.ryy.ui.entity.LoadStudent;
import com.ryy.ui.entity.Students;
import com.ryy.ui.login.dao.LoadStudentDaoImpl;
import com.ryy.ui.student.dao.StudentsDaoImpl;
import com.ryy.util.IpUtil;
/**
 * 
* <p>Title: StudentsSerivceImpl</p>
* <p>Description: Students数据库逻辑代码实现</p>
* @author renyuyuan
* @date 2018年12月10日
 */

public class StudentsServiceImpl {
	private StudentsDaoImpl studentsDaoImpl;
	private LoadStudentDaoImpl loadStudentDaoImpl;
	public StudentsServiceImpl() {
		studentsDaoImpl=new StudentsDaoImpl();
		loadStudentDaoImpl=new LoadStudentDaoImpl();
	}
	/**
	 * 
	 * <p>Title: checkLoginStudent</p>
	 * <p>Description: 登陆验证学生学号，密码，状态是否正确</p>
	 * @param sid
	 * @param password
	 * @return 用户不存在返回1，状态不是1返回2，密码不正确返回3，信息正确返回4
	 */
	public int checkLoginStudent(String sid,String password) {
		Students s=this.studentsDaoImpl.getStudentById(sid);
		if(s==null) {
			return 1;
		}else {
			if(s.getState()!=1) {
				return 2;
			}else if(s.getPassword().equals(password)) {
				String ip=IpUtil.getRealIP();
				Students st=this.studentsDaoImpl.updateStudentIp(s,ip);
				Constant.myStudent=st;
				LoadStudent ls=new LoadStudent();ls.setLogin_time(new Date());ls.setStudent(st);
				loadStudentDaoImpl.saveLoadStudent(ls);
				return 4;
			}else {
				return 3;
			}
		}
	}
	/**
	 * 
	 * <p>Title: checkModifyStudent</p>
	 * <p>Description: 检验学生修改密码是否正确</p>
	 * @param sid
	 * @param pwd
	 * @param conpwd
	 * @return 用户不存在返回1，密码不匹配返回2，信息无误返回3
	 */
	public int checkModifyStudent(String sid,String pwd,String conpwd) {
		Students s=this.studentsDaoImpl.getStudentById(sid);
		if(s==null) 
			return 1;
		else if(!pwd.equals(conpwd))
			return 2;
		else {
			this.studentsDaoImpl.updateStudentPassword(s, pwd);
			return 3;
		}
	}
}
