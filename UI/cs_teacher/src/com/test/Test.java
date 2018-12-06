package com.test;

import java.awt.EventQueue;

import com.entity.Login;
/**
 * 
* <p>Title: Test</p>
* <p>Description: 进入登陆界面</p>
* @author Luan Xiaoyue
* @date 2018年12月5日
 */
public class Test {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login frame=new Login();
				//frame.init();
			}
		});

	}

}
