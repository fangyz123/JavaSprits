package team.javaSpirit.teachingAssistantPlatform.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service.SendMessageThread;

/**
* <p>Title: SCommunicaIoHandle</p>
* <p>Description: 老师服务端处理器。接收客户端传递的信息，对其进行相对应的处理。
* 判断session的不同状态，进行相对应的操作</p>
* @author Fang Yuzhen
* @date 2018年11月28日
 */
public class TCommunicaIoHandle extends IoHandlerAdapter {

	/**
	 *  监听学生端写过来的信息，将其接收并对其内容进行相对应的回复。
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		//对接收过来的对象，进行强制类型转换
		FileContent fc = (FileContent) message;
		//new一个写信息的线程
		SendMessageThread sendMessage = new SendMessageThread(session);
		//如果接收的命令是1，就对其回应
		if (1 == fc.getCommand()) {
			sendMessage.start();

		}
	}

	/**
	 *监听服务器 写客户端给的信息，在其进行相对应的处理
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {

	}

}
