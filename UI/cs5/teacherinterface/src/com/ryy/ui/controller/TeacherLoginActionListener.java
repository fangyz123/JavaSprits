package com.ryy.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;

import com.ryy.ui.teacher.service.TeacherServiceImpl;
import com.ryy.ui.util.DlProPertiesUtil;
import com.ryy.ui.view.Index;
import com.ryy.ui.view.Login;
import com.ryy.ui.view.LoginIng;


public class TeacherLoginActionListener implements ActionListener {
	private Login login;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if("登  录".equals(s)) {
			this.setLoginButton();
		}else if("记住密码".equals(s)) {
			JRadioButton jb=(JRadioButton)e.getSource();
			this.setRemberButton(jb.isSelected());
		}
	}
	public TeacherLoginActionListener(Login login) {
		this.login=login;
	}
	public void setLoginButton() {
		String getName=this.login.getUsername().getText();
		String getPwd=this.login.getPassword().getText();
		if(getName==null||getName.equals("")) {
        	JOptionPane.showMessageDialog(null,"用户不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else if(getPwd==null||getPwd.equals("")){
        	JOptionPane.showMessageDialog(null,"密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
        }else {
        	String path=this.login.getPath();
        	this.login.dispose();
        	LoginIng li=new LoginIng();
        	li.init();
        	new SwingWorker<String, String>() {

				@Override
				protected String doInBackground() throws Exception {
					// TODO Auto-generated method stub
					TeacherServiceImpl teacherServiceImpl=new TeacherServiceImpl();
		        	int i=teacherServiceImpl.checkLoginTeacher(getName, getPwd);
		        	if(i==4) {
		        		if(DlProPertiesUtil.getRemberPassword(path)==true) {
		        			DlProPertiesUtil.setDlProperties(true, getName, getPwd, path);
		        		}
		        		li.dispose();
		        		return "1";
//		        		Index index=new Index();
		        	}else if(i==1){
		        		JOptionPane.showMessageDialog(null,"用户不存在","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
		        	}else if(i==2) {
		           	 JOptionPane.showMessageDialog(null,"该用户不能登录","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
		            }else if(i==3) {
		           	 JOptionPane.showMessageDialog(null,"密码不正确","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
		            }
					return "2";
				}
				protected void done() {
					try {
						String s=get();
						if("1".equals(s)) {
							new Index();
						}else {
							li.dispose();
							Login l=new Login();
							l.init();	
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
        	}.execute();

        }
	}
	public void setRemberButton(boolean b) {
		if(this.login!=null) {
			if(b==true) {
				DlProPertiesUtil.setRemberword(this.login.getPath(), true);
			}else {
				DlProPertiesUtil.setDlProperties(false, "", "", this.login.getPath());
			}
		}
	}
}
