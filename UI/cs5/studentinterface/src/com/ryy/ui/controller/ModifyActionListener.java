package com.ryy.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ryy.ui.student.service.StudentsServiceImpl;
import com.ryy.ui.view.Modify;

public class ModifyActionListener implements ActionListener {
	private Modify modify;
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
	public void setConfirmButton() {
            String getName =this.modify.getUsername().getText();
            String getPwd =this.modify.getPassword().getText();
            String getConPwd=this.modify.getConpassword().getText();
            if(getName==null||getName.equals("")) {
            	JOptionPane.showMessageDialog(null,"用户不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else if(getPwd==null||getPwd.equals("")) {
            	JOptionPane.showMessageDialog(null,"密码不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else if(getConPwd==null||getConPwd.equals("")) {
            	JOptionPane.showMessageDialog(null,"确认不能为空","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
            }else {
            	StudentsServiceImpl studentsServiceImpl=new StudentsServiceImpl();
            	int i= studentsServiceImpl.checkModifyStudent(getName, getPwd, getConPwd);
                if(i==1) {
                	JOptionPane.showMessageDialog(null,"用户不存在","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                } else if(i==2) {
                	JOptionPane.showMessageDialog(null,"前后密码不一致","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                }else {
                	JOptionPane.showMessageDialog(null,"请返回登录","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                	modify.dispose();
                }
            }
	}
}
