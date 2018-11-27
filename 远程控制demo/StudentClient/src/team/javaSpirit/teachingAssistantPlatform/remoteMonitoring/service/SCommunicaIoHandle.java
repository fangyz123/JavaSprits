package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.media.jai.remote.SerializableRenderedImage;

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
		SerializableRenderedImage s = fileContent.getSerializableRenderedImage();
		int width = s.getWidth();
		int height = s.getHeight();
		int type = fileContent.getType();
		BufferedImage image = new BufferedImage(width, height, type);
		Graphics2D g = image.createGraphics();
		g.drawRenderedImage(s, AffineTransform.getScaleInstance(1, 1));
		g.dispose();
		// 将读出来的图片在面板上展示
		screen.display(image);
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
