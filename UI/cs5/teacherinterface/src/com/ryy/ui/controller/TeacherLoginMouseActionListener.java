package com.ryy.ui.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ryy.ui.view.Login;
import com.ryy.ui.view.Modify;

public class TeacherLoginMouseActionListener implements MouseListener {
	private Login login;
	public TeacherLoginMouseActionListener(Login login) {
		this.login=login;
	}
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
