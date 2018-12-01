package team.javaSpirit.teachingAssistantPlatform.mina;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.ui.ShowScreen;

/**
* <p>Title: SCommunicaIoHandle</p>
* <p>Description: 学生客户端处理器。接收服务器传递的信息，对其进行相对应的处理。
* 判断session的不同状态，进行相对应的操作</p>
* @author Fang Yuzhen
* @date 2018年11月28日
 */
public class SCommunicaIoHandle extends IoHandlerAdapter {
	/* 获得展示面板的对象 */
	private ShowScreen screen = new ShowScreen();

	/**
	 * 监听服务器写过来的信息，将其接收并处理。
	 * 对Object类型的对象进行强制类型转成FileContent，得到其字节数组；
	 * 将字节数组读成BufferedImage的对象，并将其展示在控制台上。
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 对接收过来的对象，进行强制类型转换
		FileContent fileContent = (FileContent) message;
		// 通过对象获得字节数组
		byte[] bytes = fileContent.getBytes();
		// new一个字节输入流，进行读操作
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		BufferedImage image = ImageIO.read(inputStream);
		screen.display(image);
	}

	/**
	 * 监听客户端写给服务器的信息，在其进行相对应的处理。
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {

	}

	/**
	 * 监听会话空闲。当会话进入空闲时，有可能是网络的原因导致的。
	 * 将当前的会话进行关闭处理，方便后面监听断网的重连机制
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("sessionIdle");
		if (session != null) {
//			session.getService().dispose(false);
			session.close(false);
		}
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("session close");
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		System.out.println("exceptionCaught");
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		System.out.println("inputClosed");

	}

}
