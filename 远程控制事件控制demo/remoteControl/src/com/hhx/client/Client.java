package com.hhx.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
* <p>Title: Client</p>
* <p>Description:�����ƶ˿������� </p>
* @author �λ�ϼ
* @date 2018��11��24��
 */
public class Client {

	private  ObjectInputStream objectInputStream;
	private OutputStream ous;
	public void setupServer(int port) throws Exception { 
		//�����ƶ���Ϊ�������ˣ���������
		ServerSocket serverSocket = new ServerSocket(port);
		 while(!serverSocket.isClosed()){
				//��������������ֱ���ͻ������˴���
				 Socket socket = serverSocket.accept();
				 InputStream ins = socket.getInputStream();
				 //���������� ��ȡ�¼�����    
				 objectInputStream= new ObjectInputStream(ins);
				 ous=socket.getOutputStream();
				 //��������������Է���ͼƬ���� 1��intͼƬ���ݳ��� ͼƬ���ֽ�
			     DataOutputStream dous=new DataOutputStream(ous);   
			     //�����߳�
				 EventReadThred eventReadThread = new EventReadThred(objectInputStream,serverSocket);
				 eventReadThread.start();
				 CaptureThread captureThread = new CaptureThread(dous,serverSocket);
				 captureThread.start();
				 //VarReadThread var=new VarReadThread(objectInputStream);
				// var.start();
				
			 
		 }
	}

	public static void main(String[] args) throws Exception {
		//��������
		new Client().setupServer(9090);
	}

}
