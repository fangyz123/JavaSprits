package team.javaSpirit.teachingAssistantPlatform.studentSignIn.service;

import java.util.List;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;
import team.javaSpirit.teachingAssistantPlatform.studentSignIn.dao.StudentSignInDaoImpl;

/**
 * <p>
 * Title: StudentSignInServiceImpl
 * </p>
 * <p>
 * Description: 通过dao类的查询，实现相关的逻辑代码。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月17日
 */
public class StudentSignInServiceImpl {

	private StudentSignInDaoImpl studentSignIn = new StudentSignInDaoImpl();

	/**
	 * <p>
	 * Title: SignInStudent
	 * </p>
	 * <p>
	 * Description: 返回当前课程学生签到的情况,利用三表连接，返回学生表的信息。
	 * </p>
	 * 
	 * @return
	 */
	public List<Object[]> SignInStudent() {
		return studentSignIn.searchSignInStudent();
	}

}
