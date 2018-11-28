package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
 * �̳��߳��࣬ʵ��ÿ500������ͻ��˽���ͨ�š�
 * 
 * @author fangyuzhen
 *
 */
public class SendMessageThread extends Thread {
	/* �����Ļ��ͼ�� */
	private TScreen tScreen = new TScreen();
	/* ��������ͻ���ͨ�ŵĻỰ */
	private IoSession session = null;

	/**
	 * ÿ��500������ͻ���дһ����Ϣ��
	 */
	@Override
	public void run() {
		BufferedImage image = null;
		FileContent fc = new FileContent();
		while (true) {
			try {
				// �õ���Ļ��ͼ
				image = tScreen.getScreen();
				fc.setSerializableRenderedImage(image);
				// �����Ӧ����Ϣ����fc����д���ͻ���
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
