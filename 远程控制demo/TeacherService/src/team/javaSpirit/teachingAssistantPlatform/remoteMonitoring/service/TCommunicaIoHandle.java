package team.javaSpirit.teachingAssistantPlatform.remoteMonitoring.service;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import team.javaSpirit.teachingAssistantPlatform.entity.FileContent;

/**
 * ��ʦ�˴�����������ѧ���˴��ݵ���Ϣ������������Ӧ�Ĵ���
 * 
 * @author fangyuzhen
 *
 */
public class TCommunicaIoHandle extends IoHandlerAdapter {
	/**
	 * ����ѧ����д��������Ϣ��������ղ��������ݽ������Ӧ�Ļظ���
	 */
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		// �Խ��չ����Ķ��󣬽���ǿ������ת��
		FileContent fc = (FileContent) message;
		// newһ��д��Ϣ���߳�
		SendMessageThread sendMessage = new SendMessageThread(session);
		// ������յ�������1���Ͷ����Ӧ
		if (1 == fc.getCommand()) {
			sendMessage.setSession(session);
			sendMessage.start();
		}
	}

	/**
	 * ���������� д�ͻ��˸�����Ϣ������������Ӧ�Ĵ���
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
