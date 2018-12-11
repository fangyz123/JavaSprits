package team.javaspirit.remoteControl.operation.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import team.javaspirit.remoteControl.ui.MyJframe;
/**
 * 
* <p>Title: ConnectStudent</p>
* <p>Description:��ʦ�˵��߼����̡��ȴ�ѧ���ˣ��ͻ��ˣ���չʾͼƬ�����͵���¼� </p>
* @author �λ�ϼ
* @date 2018��12��4��
 */
public class ConnectStudent {
	private ObjectOutputStream ous;// ����������͵���¼�
	private DataInputStream ins;// ��������չʾͼƬ
	private MyJframe jf = new MyJframe(ous);// ����չʾ������Ļ
	//private Socket scoket;// ��������˵�����

	
	public void setupServer(int port) throws Exception {//��ʦ�˿����˿�
		// ���ƶ���Ϊ�������ˣ���������
		ServerSocket serverSocket = new ServerSocket(port);

		while (!serverSocket.isClosed()) {
			Socket socket = serverSocket.accept();
			// ��������������ֱ���ͻ������˴���
			
			// �õ�����������ȡͼƬ����
			ins = new DataInputStream(socket.getInputStream());
			// �õ�������������¼�����
			ous = new ObjectOutputStream(socket.getOutputStream());
			

			// չʾѧ����ͼƬ
			ShowImageThread si = new ShowImageThread(ins, serverSocket, jf);
			si.start();// ִ������߳�
			// ����ʦ�˴��������صĲ���
			VarSend vs = new VarSend(ous, jf);
			vs.sentMouseSet();
			// ��jframe���Ӽ����¼�
			ListenerThread lt = new ListenerThread(ous, jf);
			lt.start();

		}
	}
	//ԭ��
	/*public void conn2Server( int port) throws Exception {

		// ����ѧ����
		scoket = new Socket(ip, port);
		// �õ�����������ȡͼƬ����
		ins = new DataInputStream(scoket.getInputStream());
		// �õ�������������¼�����
		ous = new ObjectOutputStream(scoket.getOutputStream());
		

		// չʾѧ����ͼƬ
		ShowImageThread si = new ShowImageThread(ins, scoket, jf);
		si.start();// ִ������߳�
		// ����ʦ�˴��������صĲ���
		VarSend vs = new VarSend(ous, jf);
		vs.sentMouseSet();
		// ��jframe���Ӽ����¼�
		ListenerThread lt = new ListenerThread(ous, jf);
		lt.start();
	}*/
}
