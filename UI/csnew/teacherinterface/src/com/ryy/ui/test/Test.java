package com.ryy.ui.test;

import java.awt.EventQueue;

import com.ryy.ui.view.Login;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login=new Login();
					login.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
