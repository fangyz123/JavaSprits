package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.login.service.LoadStudentServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Login;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Modify;

/**
 * 
* <p>Title: ModifyActionListener</p>
* <p>Description:为Modify界面添加 事件监听事件</p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class ModifyActionListener implements ActionListener {
	private Modify modify;
	/**
	 * 当监听事件触发时调用此业务逻辑
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str=e.getActionCommand();
		if("确  认".equals(str)) {
			this.setConfirmButton();
		}
	}
	public ModifyActionListener(Modify modify) {
		this.modify=modify;
	}
	/**
	 * 
	 * <p>Title: setConfirmButton</p>
	 * <p>Description:点击确认按钮时调用次业务逻辑 </p>
	 */
	public void setConfirmButton() {
            String getName =this.modify.getUsername().getText();
            String oldPwd=this.modify.getOldPassword().getText();
            String getPwd =this.modify.getPassword().getText();
            String getConPwd=this.modify.getConpassword().getText();
            if(getName==null||getName.equals("")) {
            	JOptionPane.showMessageDialog(null,"用户不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else if(oldPwd==null||oldPwd.equals("")) {
            	JOptionPane.showMessageDialog(null,"旧密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else if(getPwd==null||getPwd.equals("")) {
            	JOptionPane.showMessageDialog(null,"密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else if(getConPwd==null||getConPwd.equals("")) {
            	JOptionPane.showMessageDialog(null,"确认不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else {
            	LoadStudentServiceImpl studentsServiceImpl=new LoadStudentServiceImpl();
            	int i= studentsServiceImpl.checkModifyStudent(getName, oldPwd,getPwd, getConPwd);
                if(i==1) {
                	JOptionPane.showMessageDialog(null,"用户不存在","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                } else if(i==2) {
                	JOptionPane.showMessageDialog(null,"旧密码不正确","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                }else if(i==3) {
                	JOptionPane.showMessageDialog(null,"前后密码不一致","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                }else {
                	JOptionPane.showMessageDialog(null,"请返回登录","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                	modify.dispose();
                	Login login=new Login();
                	login.init();
                }
            }
	}
}
