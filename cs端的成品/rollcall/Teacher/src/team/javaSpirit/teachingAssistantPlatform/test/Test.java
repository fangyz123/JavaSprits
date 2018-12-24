package team.javaSpirit.teachingAssistantPlatform.test;

import java.awt.EventQueue;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Login;

/**
 * 
* <p>Title: Test</p>
* <p>Description: 老师端进入登陆界面</p>
* @author Luan Xiaoyue
* @date 2018年12月5日
 */
public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login frame=new Login();
				frame.init();
			}
		});

	}

}
