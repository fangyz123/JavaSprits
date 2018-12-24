package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
* <p>Title: SendMessage</p>
* <p>Description: 客户端发送消息的类</p>
* @author Fang Yuzhen
* @date 2018年11月28日
 */
public class SendMessage {

	public SendMessage() {

	}

	/**
	 * <p>Title: sendComand</p>
	 * <p>Description: 通过传进来的会话和命令，
	 * 设置发送的文件内容，将其发送给服务器。</p>
	 * @param session 传进来的IoSession类型的对象会话
	 * @param comand  传进来的byte类型的命令
	 */
	public void sendComand(IoSession session, byte comand) {
		FileContent fc = new FileContent();
		fc.setCommand(comand);
		session.write(fc);
	}

}
