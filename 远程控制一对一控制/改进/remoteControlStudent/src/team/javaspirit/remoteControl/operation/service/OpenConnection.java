package team.javaspirit.remoteControl.operation.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * <p>
 * Title: OpenConnection
 * </p>
 * <p>
 * Description: �������Ҫ�ǽ�ʦ�˿�������֮�󣬵ȴ�ѧ���ˣ��ͻ��ˣ������ӡ����Ӻ����Ҫ
 * �߼����̡��Ȼ�����ӵ����������������Ȼ��ֱ�����������objectInputStream����Ϊ���ܹ���
 * �ͻ��˺ͷ�������֮����õش����¼��������н���object���ܹ����õذѵ���¼����лطš�
 * �������ת����dataOutputStream�������ͼƬת�����ֽ�
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��12��3��
 */
public class OpenConnection {
	private ObjectInputStream objectInputStream;//��ȡ��ʦ�˵ĵ���¼�
	private OutputStream ous;//����ͼƬ
	private Socket socket;
	//����ѧ���ˣ��������޸�Ϊ�ͻ��ˣ����ӽ�ʦ��
	public void conn2Server( String ip,int port) throws Exception {

		// ���ӽ�ʦ��
		socket = new Socket(ip, port);
		InputStream ins = socket.getInputStream();
		// ���������� ��ȡ�¼�����
		objectInputStream = new ObjectInputStream(ins);
		ous = socket.getOutputStream();
		// ��������������Է���ͼƬ���� 1��intͼƬ���ݳ��� ͼƬ���ֽ�
		DataOutputStream dous = new DataOutputStream(ous);
		// ������ͼ�߳�
		CaptureThread captureThread = new CaptureThread(dous, socket);
		captureThread.start();
		// �����ط��¼��߳�
		EventReadThred eventReadThread = new EventReadThred(objectInputStream, socket);
		eventReadThread.start();
	}
	
}
