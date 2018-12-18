package team.javaSpirit.teachingAssistantPlatform.test;

import java.awt.EventQueue;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Login;
/**
* <p>Title: Test</p>
* <p>Description: 学生端进入接口。</p>
* @author Fang Yuzhen
* @date 2018年12月15日
 */
public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
