package team.javaspirit.remoteControl.operation.service;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import team.javaspirit.remoteControl.ui.MyJframe;
/**
 * 
* <p>Title: ConnectStudent</p>
* <p>Description:��ʦ�˵��߼����̡�����ѧ���ˣ��������ˣ���չʾͼƬ�����͵���¼� </p>
* @author �λ�ϼ
* @date 2018��12��4��
 */
public class ConnectStudent {
	private ObjectOutputStream ous;// �����
	private DataInputStream ins;// ������
	private MyJframe jf = new MyJframe(ous);// ����չʾ������Ļ
	private Socket scoket;// ��������˵�����

	public void conn2Server(String ip, int port) throws Exception {

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
	}

}
