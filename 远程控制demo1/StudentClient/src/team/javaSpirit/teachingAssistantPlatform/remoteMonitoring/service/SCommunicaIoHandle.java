package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;
import team.javaSpirit.teachingAssistantPlatform.ui.ShowScreen;

/**
 * 学生客户端处理器。接收服务器传递的信息，对其进行相对应的处理。
 * 
 * @author fangyuzhen
 *
 */
public class SCommunicaIoHandle extends IoHandlerAdapter {
	/* 获得展示面板的对象 */
	private ShowScreen screen = new ShowScreen();

	/**
	 * 监听服务器写过来的信息，将其接收并处理。
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// 对接收过来的对象，进行强制类型转换
		FileContent fileContent = (FileContent) message;
		// 通过对象获得字节数组
		byte[] bytes = fileContent.getBytes();
		// new一个字节输入流，进行读操作
		InputStream inputStream = new ByteArrayInputStream(bytes);
		BufferedImage image = ImageIO.read(inputStream);
		// 将读出来的图片在面板上展示
		int x = fileContent.getX();
		int y = fileContent.getY();
		screen.display(image, x, y);
	}

	/**
	 * 监听客户端写给服务器的信息，在其进行相对应的处理。
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception {

	}

	@SuppressWarnings("deprecation")
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("aaa" + status);
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
