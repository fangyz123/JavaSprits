package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.login.service.TeacherServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Modify;

/**
 * 
 * <p>
 * Title: TeacherModifyActionListener
 * </p>
 * <p>
 * Description:修改密码界面监听事件
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月13日
 */
public class TeacherModifyActionListener implements ActionListener {
	private Modify modify;

	/**
	 * 当监听事件被触发时调用该业务逻辑
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		if ("确  认".equals(s)) {
			this.setConfirm();
		}

	}

	public TeacherModifyActionListener(Modify modify) {
		this.modify = modify;
	}

	/**
	 * 
	 * <p>
	 * Title: setConfirm
	 * </p>
	 * <p>
	 * Description: 点击确认按钮时调用该业务逻辑
	 * </p>
	 */
	public void setConfirm() {
		String getName = this.modify.getUsername().getText();
		String oldpwd = this.modify.getOldPassword().getText();
		String getPwd = this.modify.getPassword().getText();
		String getConPwd = this.modify.getConpassword().getText();
		if (getName == null || getName.equals("")) {
			JOptionPane.showMessageDialog(null, "用户不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else if (oldpwd == null || oldpwd.equals("")) {
			JOptionPane.showMessageDialog(null, "旧密码不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else if (getPwd == null || getPwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else if (getConPwd == null || getConPwd.equals("")) {
			JOptionPane.showMessageDialog(null, "确认不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else {
			TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
			int i = teacherServiceImpl.checkModifyTeacher(getName, oldpwd, getPwd, getConPwd);
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "用户不存在", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (i == 2) {
				JOptionPane.showMessageDialog(null, "旧密码错误", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else if (i == 3) {
				JOptionPane.showMessageDialog(null, "前后密码不一致", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "请返回登录", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				this.modify.dispose();
			}
		}
	}
}
