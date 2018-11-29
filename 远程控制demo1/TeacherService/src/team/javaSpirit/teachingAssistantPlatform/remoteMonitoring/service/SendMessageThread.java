package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.Screen.TScreen;
import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
 * 继承线程类，实现每200毫秒跟客户端进行通信。
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
	 * 将屏幕的截图通过ImageIO写给客户端，并对FileContent对象设置字节数组。 
	 * 返回FileContent对象。
	 * @param image 传进来BufferedImage类型的图片
	 * @return 返回通信的对象
	 * @throws IOException
	 */
	public FileContent writeMessage(BufferedImage image) throws IOException {
		FileContent fc = new FileContent();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", baos);
		fc.setBytes(baos.toByteArray());
		return fc;
	}

	/**
	 * 每隔200毫秒给客户端写一张图片。
	 */
	@Override
	public void run() {
		while (true) {
			BufferedImage image;
			try {
				// 得到屏幕截图
				image = tScreen.getScreen();
				// 将图片写给客户端
				FileContent fc = writeMessage(image);
				// 将相对应的信息赋给fc对象，写给客户端
				session.write(fc);
				Thread.sleep(200);
			} catch (AWTException e2) {
				e2.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
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
