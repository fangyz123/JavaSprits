package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.entity.Teacher;
import team.javaSpirit.teachingAssistantPlatform.feedback.service.FeedBackServicesImpl;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.TeacherClassServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.signIn.service.StudentCourseService;
import team.javaSpirit.teachingAssistantPlatform.ui.view.ConnectRemind;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
import team.javaSpirit.teachingAssistantPlatform.vediotape.dao.ToDoFile;
import team.javaSpirit.teachingAssistantPlatform.vediotape.service.VediotapeService;

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
	private JTextArea text;
	/* 开启连接的服务 */
	private VediotapeService service1;
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ("开启远程连接".equals(s)) {
			this.setStartRemoteButton();
		} else if ("×".equals(s)) {
			this.setCloseButton();
		} else if("签到排名".equals(s)) {
			this.setSignRank();
		}else if("发送".equals(s)) {
			this.setSend();
		}else if("开 启 录 屏".equals(s)) {
			service1.openVedio();
			JOptionPane.showMessageDialog(null, "录屏开启成功！！！");
		}else if("暂 停 录 屏".equals(s)) {
			// 暂停服务
			service1.pauseVedio();
			JOptionPane.showMessageDialog(null, "录屏暂停成功！！！");
		}else if("关 闭 录 屏".equals(s)) {
			// 停止录屏	
			service1.stopVedio();
			JOptionPane.showMessageDialog(null, "录屏结束！！！");
		}
	}

	public IndexActionListener(Index index) {
		this.index = index;
	}
	public IndexActionListener(Index index,JTextArea text) {
		this.index=index;this.text=text;
	}
	public IndexActionListener(){
		// 开启服务
		ToDoFile tdf=new ToDoFile();
		tdf.deleteFiles();
		String relativelyPath=System.getProperty("user.dir");
		String  filePath  =  relativelyPath+"//picture//";
		this.service1 = new VediotapeService(filePath, "jpeg");
		
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
	public void setSignRank() {
		this.index.jumpSingRank();
	}
	
	//发送课堂反馈的逻辑
	public void setSend() {
		FeedBackServicesImpl.setTxt(this.text.getText());		
		JOptionPane.showMessageDialog(null, "您反馈的问题已收到！！！");
	}
}
