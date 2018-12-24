package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service.MyServiceThread;
import team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service.StudentServiceImpl;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Service;

public class StuShowActionListener implements ActionListener {
	/* 按钮 */
	private JButton button;
	/* 服务连接对象 */
	private Service service;

	public StuShowActionListener(JButton button, Service service) {
		this.button = button;
		this.service = service;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new MyServiceThread().start();
		// 学生名字
		String sname = button.getText();
		// 获得IP
		StudentServiceImpl ss = new StudentServiceImpl();
		String ip = ss.findIp(sname);
		service.sendCommand(ip);
	}

}
