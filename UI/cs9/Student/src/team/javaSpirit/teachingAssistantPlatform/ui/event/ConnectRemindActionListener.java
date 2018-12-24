package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import team.javaSpirit.teachingAssistantPlatform.common.Communication;
import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Client;
import team.javaSpirit.teachingAssistantPlatform.ui.view.ConnectRemind;

public class ConnectRemindActionListener implements ActionListener {
	/* 远程监控连接的对象 */
	private ConnectRemind connectRemind;

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ("连   接".equals(s)) {
			this.setConnectButton();
		}
	}

	public ConnectRemindActionListener(ConnectRemind cn) {
		this.connectRemind = cn;
	}

	/**
	 * <p>Title: setConnectButton</p>
	 * <p>Description: 连接老师的button。对其做相应的操作。</p>
	 */
	public void setConnectButton() {
		this.connectRemind.dispose();
		Client client = new Client();
		client.connect(Constant.teacher.getIp(), Communication.tPort);
	}
}
