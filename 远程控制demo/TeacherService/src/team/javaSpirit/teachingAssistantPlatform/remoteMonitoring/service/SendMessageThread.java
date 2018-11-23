package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
 * �̳��߳��࣬ʵ��ÿ500������ͻ��˽���ͨ�š�
 * @author fangyuzhen
 *
 */
public class SendMessageThread extends Thread {
	/*�����Ļ��ͼ��*/
	private TScreen tScreen = new TScreen();
	/*��������ͻ���ͨ�ŵĻỰ*/
	private IoSession session = null;

	/**
	 * ����Ļ�Ľ�ͼͨ��ImageIOд���ͻ��ˣ�����FileContent���������ֽ����顣
	 * ����FileContent����
	 * @param image
	 * @return
	 * @throws IOException
	 */
	public FileContent writeMessage(BufferedImage image) throws IOException {
		FileContent fc = new FileContent();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpeg", baos);
		fc.setBytes(baos.toByteArray());
		return fc;
	}

	/**
	 * ÿ��500������ͻ���дһ����Ϣ��
	 */
	@Override
	public void run() {
		while (true) {
			BufferedImage image;
			try {
				//�õ���Ļ��ͼ
				image = tScreen.getScreen();
				//��ͼƬд���ͻ���
				FileContent fc = writeMessage(image);
				//�����Ӧ����Ϣ����fc����д���ͻ���
				session.write(fc);
				Thread.sleep(50);
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
