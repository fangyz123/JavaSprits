package com.ryy.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.ryy.ui.view.ConnectRemind;
import com.ryy.ui.view.Index;

public class IndexActionListener implements ActionListener {

	private Index index;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if("签到".equals(s)) {
			this.setSignButton();
		}else if("远程监控".equals(s)) {
			this.setRemoteButton();
		}else if("开启远程监控".equals(s)) {
			this.setStartRemoteButton();
		}else if("×".equals(s)) {
			this.setCloseButton();
		}
	}
	public IndexActionListener(Index index) {
		this.index=index;
	}
	//签到的逻辑判断
	public void setSignButton() {
		
	}
	//远程监控的逻辑判断
	public void setRemoteButton() {
		this.index.jumpRemote();
	}
	//开启远程监控的逻辑判断
	public void setStartRemoteButton() {
		//JOptionPane.showMessageDialog(null,"没有可以连接的老师","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
		ConnectRemind cr=new ConnectRemind();
		cr.init();
	}
	//×的逻辑
	public void setCloseButton() {
		this.index.init();
	}
}
