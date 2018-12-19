package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.common.Constant;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.Client;
import team.javaSpirit.teachingAssistantPlatform.ui.view.ConnectRemind;
/**
 * 
* <p>Title: ConnectRemindActionListener</p>
* <p>Description: 为连接老师页面ConnectRemind添加监听事件</p>
* @author renyuyuan
* @date 2018年12月19日
 */
public class ConnectRemindActionListener implements ActionListener {

	private ConnectRemind connectRemind;
	/**
	 * 为连接老师页面ConnectRemind添加监听事件
	 */
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
	 * 
	 * <p>Title: setConnectButton</p>
	 * <p>Description:点击连接按钮触发此业务逻辑 </p>
	 */
	public void setConnectButton() {
		this.connectRemind.dispose();
		JOptionPane.showMessageDialog(null, "连接成功", "提示", JOptionPane.PLAIN_MESSAGE);
		Client client = new Client();
		System.out.println(Constant.teacher.getIp());
		client.connect(Constant.teacher.getIp(), 8081);
	}
}
