package team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service;

import team.javaSpirit.teachingAssistantPlatform.common.Communication;

public class MyServiceThread extends Thread {

	public MyServiceThread() {

	}

	@Override
	public void run() {
		ConnectStudent cs = new ConnectStudent();
		cs.setupServer(Communication.sPort);
	}

}
