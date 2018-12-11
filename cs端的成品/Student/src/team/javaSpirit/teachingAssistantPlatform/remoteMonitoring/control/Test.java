package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.control;

import java.awt.EventQueue;

import team.javaSpirit.teachingAssistantPlatform.ui.Login;



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
