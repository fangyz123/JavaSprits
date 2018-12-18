package com.ryy.ui.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ryy.ui.view.Login;
import com.ryy.ui.view.Modify;
/**
 * 
* <p>Title: TeacherLoginMouseActionListener</p>
* <p>Description:登录界面鼠标监听事件 </p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class TeacherLoginMouseActionListener implements MouseListener {
	private Login login;
	public TeacherLoginMouseActionListener(Login login) {
		this.login=login;
	}
	/**
	 * 点击修改密码事触发该业务逻辑
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Modify modify=new Modify();
		modify.init();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
