package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
 * 老师端处理器。接收学生端传递的信息，对其进行相对应的处理。
 * 
 * @author fangyuzhen
 *
 */
public class TCommunicaIoHandle extends IoHandlerAdapter {
	/**
	 * 监听学生端写过来的信息，将其接收并对其内容进行相对应的回复。
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 对接收过来的对象，进行强制类型转换
		FileContent fc = (FileContent) message;
		// new一个写信息的线程
		SendMessageThread sendMessage = new SendMessageThread(session);
		// 如果接收的命令是1，就对其回应
		if (1 == fc.getCommand()) {
			sendMessage.setSession(session);
			sendMessage.start();
		}
	}

	/**
	 * 监听服务器 写客户端给的信息，在其进行相对应的处理
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("aaaa");
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
	}

}
