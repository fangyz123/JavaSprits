package com.ryy.ui.test;

import java.awt.EventQueue;

import com.ryy.ui.entity.Login;



public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
