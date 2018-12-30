package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;

import team.javaSpirit.teachingAssistantPlatform.login.service.TeacherServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Login;
import team.javaSpirit.teachingAssistantPlatform.ui.view.LoginIng;
import team.javaSpirit.teachingAssistantPlatform.util.DlProPertiesUtil;

/**
 * 
 * <p>
 * Title: TeacherLoginActionListener
 * </p>
 * <p>
 * Description: 登录界面监听事件TeacherLoginActionListener
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月13日
 */
public class TeacherLoginActionListener implements ActionListener {
	private Login login;
	private static LoginIng loginIng;
	private static boolean isCancel = false;

	/**
	 * 当监听事件被触发调用该业务逻辑
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ("登  录".equals(s)) {
			this.setLoginButton();
		} else if ("记住密码".equals(s)) {
			JRadioButton jb = (JRadioButton) e.getSource();
			this.setRemberButton(jb.isSelected());
		} else if ("取消".equals(s)) {
			this.setCancelButton();
		}
	}

	public TeacherLoginActionListener(Login login) {
		this.login = login;
	}

	public TeacherLoginActionListener() {
	}

	/**
	 * 
	 * <p>
	 * Title: setLoginButton
	 * </p>
	 * <p>
	 * Description: 点击登录按钮掉用该业务逻辑
	 * </p>
	 */
	public void setLoginButton() {
		String getName = this.login.getUsername().getText();
		String getPwd = this.login.getPassword().getText();
		if (getName == null || getName.equals("")) {
			JOptionPane.showMessageDialog(null, "用户不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else if (getPwd == null || getPwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else {
			String path = this.login.getPath();
			this.login.dispose();
			this.loginIng = new LoginIng();
			this.loginIng.init();
			new SwingWorker<String, String>() {

				@Override
				protected String doInBackground() throws Exception {
					TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
					int i = teacherServiceImpl.checkLoginTeacher(getName, getPwd);
					if (i == 4) {
						if (DlProPertiesUtil.getRemberPassword(path) == true)
							DlProPertiesUtil.setDlProperties(true, getName, getPwd, path);
						return "1";
					} else if (i == 1) {
						if (isCancel == false)
							JOptionPane.showMessageDialog(null, "用户不存在", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					} else if (i == 2) {
						if (isCancel == false)
							JOptionPane.showMessageDialog(null, "该用户不能登录", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					} else if (i == 3) {
						if (isCancel == false)
							JOptionPane.showMessageDialog(null, "密码不正确", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					}else if(i==5) {
						if (isCancel == false)
							JOptionPane.showMessageDialog(null, "该用户已经登录", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					}
					return "2";
				}

				protected void done() {
					try {
						String s = get();
						if (isCancel == false) {
							loginIng.dispose();
							if ("1".equals(s)) {
								Index index = new Index();
								index.init();
							} else {
								Login l = new Login();
								l.init();
							}
						}
						isCancel = false;
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}.execute();

		}
	}

	/**
	 * 
	 * <p>
	 * Title: setRemberButton
	 * </p>
	 * <p>
	 * Description:点击记得密码调用改业务逻辑
	 * </p>
	 * 
	 * @param b
	 */
	public void setRemberButton(boolean b) {
		if (this.login != null) {
			if (b == true) {
				DlProPertiesUtil.setRemberword(this.login.getPath(), true);
			} else {
				DlProPertiesUtil.setDlProperties(false, "", "", this.login.getPath());
			}
		}
	}

	/**
	 * 
	 * <p>
	 * Title: setCancelButton
	 * </p>
	 * <p>
	 * Description:点击取消调用改业务逻辑
	 * </p>
	 */
	public void setCancelButton() {
		this.isCancel = true;
		if (this.loginIng != null) {
			this.loginIng.dispose();
		}
		Login login = new Login();
		login.init();
	}
}
