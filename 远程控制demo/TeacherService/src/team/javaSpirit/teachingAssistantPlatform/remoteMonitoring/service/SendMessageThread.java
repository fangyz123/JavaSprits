package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
 * 继承线程类，实现每500毫秒跟客户端进行通信。
 * 
 * @author fangyuzhen
 *
 */
public class SendMessageThread extends Thread {
	/* 获得屏幕截图类 */
	private TScreen tScreen = new TScreen();
	/* 服务器与客户端通信的会话 */
	private IoSession session = null;

	/**
	 * 每隔500毫秒给客户端写一个信息。
	 */
	@Override
	public void run() {
		BufferedImage image = null;
		FileContent fc = new FileContent();
		while (true) {
			try {
				// 得到屏幕截图
				image = tScreen.getScreen();
				fc.setSerializableRenderedImage(image);
				// 将相对应的信息赋给fc对象，写给客户端
				session.write(fc);

				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public SendMessageThread(IoSession session) {
		this.session = session;
	}

	public IoSession getSession() {
		return session;
	}

	public void setSession(IoSession session) {
		this.session = session;
	}

}
