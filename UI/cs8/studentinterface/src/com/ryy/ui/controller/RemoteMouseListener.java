package com.ryy.ui.controller;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ryy.ui.view.Index;
/**
 * 
* <p>Title: RemoteMouseListener</p>
* <p>Description: 为远程监控菜单添加鼠标事件</p>
* @author renyuyuan
* @date 2018年12月20日
 */
public class RemoteMouseListener implements MouseListener {
	private Index index;
	public RemoteMouseListener(Index index) {
		this.index=index;
	}
	//点击远程监控时调用此业务逻辑
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.index.jumpRemote();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//鼠标进入远程监控菜单时改变鼠标形状
	@Override
	public void mouseEntered(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	//鼠标离开远程监控菜单时恢复鼠标形状
	@Override
	public void mouseExited(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
