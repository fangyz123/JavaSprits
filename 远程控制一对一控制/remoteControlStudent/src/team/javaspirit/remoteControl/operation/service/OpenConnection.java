package team.javaspirit.remoteControl.operation.service;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * <p>
 * Title: OpenConnection
 * </p>
 * <p>
 * Description: �������Ҫ��ѧ���˿�������֮�󣬵ȴ���ʦ�ˣ��ͻ��ˣ������ӡ����Ӻ����Ҫ
 * �߼����̡��Ȼ�����ӵ����������������Ȼ��ֱ�����������objectInputStream����Ϊ���ܹ���
 * �ͻ��˺ͷ�������֮����õش����¼��������н���object���ܹ����õذѵ���¼����лطš�
 * �������ת����dataOutputStream�������ͼƬת�����ֽ�
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��12��3��
 */
public class OpenConnection {
	private ObjectInputStream objectInputStream;
	private OutputStream ous;

	public void setupServer(int port) throws Exception {
		// �����ƶ���Ϊ�������ˣ���������
		ServerSocket serverSocket = new ServerSocket(port);

		while (!serverSocket.isClosed()) {
			Socket socket = serverSocket.accept();
			// ��������������ֱ���ͻ������˴���
			InputStream ins = socket.getInputStream();
			// ���������� ��ȡ�¼�����
			objectInputStream = new ObjectInputStream(ins);
			ous = socket.getOutputStream();
			// ��������������Է���ͼƬ���� 1��intͼƬ���ݳ��� ͼƬ���ֽ�
			DataOutputStream dous = new DataOutputStream(ous);
			// ������ͼ�߳�
			CaptureThread captureThread = new CaptureThread(dous, serverSocket);
			captureThread.start();
			// �����ط��¼��߳�
			EventReadThred eventReadThread = new EventReadThred(objectInputStream, serverSocket);
			eventReadThread.start();

		}
	}

}
