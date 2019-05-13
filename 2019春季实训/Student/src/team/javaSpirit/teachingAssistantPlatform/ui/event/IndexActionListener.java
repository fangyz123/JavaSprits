package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.TeacherClassServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.signIn.service.StudentCourseService;
import team.javaSpirit.teachingAssistantPlatform.ui.view.ConnectRemind;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

/**
 * <p>
 * Title: IndexActionListener
 * </p>
 * <p>
 * Description: 为学生端主页面index添加事件监听。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月18日
 */
public class IndexActionListener implements ActionListener {

	private Index index;

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ("开启远程连接".equals(s)) {
			this.setStartRemoteButton();
		} else if ("×".equals(s)) {
			this.setCloseButton();
		}
	}

	public IndexActionListener(Index index) {
		this.index = index;
	}

	// 签到的逻辑判断
	public void setSignButton() {
		StudentCourseService scs = new StudentCourseService();
		// 找到当前课程
		if (scs.findCurrentCourse(Constant.myStudent.getSid())
				&& scs.getStudentStatus(Constant.myStudent.getSid()) == 0) {
			try {
				// 人脸识别
				scs.firstFace();
				// 修改数据库
				scs.changeState(Constant.myStudent.getSid());
				scs.insertRecort(Constant.myStudent.getSid());
				if (StudentCourseService.status == 2) {
					JOptionPane.showMessageDialog(null, "啊哦，你迟到了");
				} else {
					JOptionPane.showMessageDialog(null, "您已签到成功");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (scs.getStudentStatus(Constant.myStudent.getSid()) != 0) {
			JOptionPane.showMessageDialog(null, "您已签到");
		} else {
			JOptionPane.showMessageDialog(null, "当前没有可以签到的课程");
		}
	}

	// 远程监控的逻辑判断
	public void setRemoteButton() {
		this.index.jumpRemote();
	}

	// 开启远程监控的逻辑判断
	public void setStartRemoteButton() {
		TeacherClassServiceImpl tcs = new TeacherClassServiceImpl();
		Teacher t = tcs.findTeacher(Constant.cid);
		if (t == null) {
			JOptionPane.showMessageDialog(null, "目前没有相应的老师开服务", "警告", JOptionPane.ERROR_MESSAGE);
		} else {
			Constant.teacher = t;
			ConnectRemind cr = new ConnectRemind();
			cr.init();
		}
	}

	// ×的逻辑
	public void setCloseButton() {
		this.index.init();
	}
}
