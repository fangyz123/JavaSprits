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
* <p>Description:被控制端开启服务 </p>
* @author 何慧霞
* @date 2018年11月24日
 */
public class Client {

	private  ObjectInputStream objectInputStream;
	private OutputStream ous;
	public void setupServer(int port) throws Exception { 
		//被控制端作为服务器端，开启传输
		ServerSocket serverSocket = new ServerSocket(port);
		 while(!serverSocket.isClosed()){
				//产生“阻塞”，直至客户端有人传输
				 Socket socket = serverSocket.accept();
				 InputStream ins = socket.getInputStream();
				 //对象输入流 读取事件对象    
				 objectInputStream= new ObjectInputStream(ins);
				 ous=socket.getOutputStream();
				 //数据输出流，用以发送图片数据 1个int图片数据长度 图片的字节
			     DataOutputStream dous=new DataOutputStream(ous);   
			     //开启线程
				 EventReadThred eventReadThread = new EventReadThred(objectInputStream,serverSocket);
				 eventReadThread.start();
				 CaptureThread captureThread = new CaptureThread(dous,serverSocket);
				 captureThread.start();
				 //VarReadThread var=new VarReadThread(objectInputStream);
				// var.start();
				
			 
		 }
	}

	public static void main(String[] args) throws Exception {
		//开启服务
		new Client().setupServer(9090);
	}

}
