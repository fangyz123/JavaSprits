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
 * ѧ���ͻ��˴����������շ��������ݵ���Ϣ������������Ӧ�Ĵ���
 * 
 * @author fangyuzhen
 *
 */
public class SCommunicaIoHandle extends IoHandlerAdapter {
	/* ���չʾ���Ķ��� */
	private ShowScreen screen = new ShowScreen();

	/**
	 * ����������д��������Ϣ��������ղ�����
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// �Խ��չ����Ķ��󣬽���ǿ������ת��
		FileContent fileContent = (FileContent) message;
		SerializableRenderedImage s = fileContent.getSerializableRenderedImage();
		int width = s.getWidth();
		int height = s.getHeight();
		int type = fileContent.getType();
		BufferedImage image = new BufferedImage(width, height, type);
		Graphics2D g = image.createGraphics();
		g.drawRenderedImage(s, AffineTransform.getScaleInstance(1, 1));
		g.dispose();
		// ����������ͼƬ�������չʾ
		screen.display(image);
	}

	/**
	 * �����ͻ���д������������Ϣ������������Ӧ�Ĵ���
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
