package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Client;
import team.javaSpirit.teachingAssistantPlatform.ui.view.ConnectRemind;

public class ConnectRemindActionListener implements ActionListener {

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

	public void setConnectButton() {
		this.connectRemind.dispose();
		JOptionPane.showMessageDialog(null, "连接成功", "提示", JOptionPane.PLAIN_MESSAGE);
		Client client = new Client();
		client.connect(Constant.teacher.getIp(), 8080);
	}
}
