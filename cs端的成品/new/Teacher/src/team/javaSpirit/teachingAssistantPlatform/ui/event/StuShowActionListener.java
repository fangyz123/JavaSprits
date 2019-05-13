package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service.MyServiceThread;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Service;

public class StuShowActionListener implements ActionListener {
	/* 服务连接对象 */
	private Service service;

	public StuShowActionListener(Service service) {
		this.service = service;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MyServiceThread().start();
		// 学生名字
		String name = e.getActionCommand();
		// 获得IP
		IoSession session = Constant.studentSession.get(name);
		service.sendCommand(session);
	}

}
