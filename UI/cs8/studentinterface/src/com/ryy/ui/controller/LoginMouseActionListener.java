package com.ryy.ui.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ryy.ui.view.Modify;
/**
 * 
* <p>Title: LoginMouseActionListener</p>
* <p>Description:为登录界面添加鼠标监听事件 </p>
* @author renyuyuan
* @date 2018年12月13日
 */
public class LoginMouseActionListener implements MouseListener {
	
	/**
	 * 
	 * <p>Title: mouseClicked</p>
	 * <p>Description:点击修改密码时触发此业务逻辑 </p>
	 * @param e
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
