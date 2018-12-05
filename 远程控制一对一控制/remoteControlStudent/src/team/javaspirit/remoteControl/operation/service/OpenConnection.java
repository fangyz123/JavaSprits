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
 * Description: 这个类主要是学生端开启服务之后，等待教师端（客户端）的连接。连接后的主要
 * 逻辑过程。先获得连接的输入流和输出流。然后分别把输入流变成objectInputStream流，为了能够在
 * 客户端和服务器端之间更好地传输事件。从流中接受object，能够更好地把点击事件进行回放。
 * 把输出流转换成dataOutputStream，方便把图片转换成字节
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年12月3日
 */
public class OpenConnection {
	private ObjectInputStream objectInputStream;
	private OutputStream ous;

	public void setupServer(int port) throws Exception {
		// 被控制端作为服务器端，开启传输
		ServerSocket serverSocket = new ServerSocket(port);

		while (!serverSocket.isClosed()) {
			Socket socket = serverSocket.accept();
			// 产生“阻塞”，直至客户端有人传输
			InputStream ins = socket.getInputStream();
			// 对象输入流 读取事件对象
			objectInputStream = new ObjectInputStream(ins);
			ous = socket.getOutputStream();
			// 数据输出流，用以发送图片数据 1个int图片数据长度 图片的字节
			DataOutputStream dous = new DataOutputStream(ous);
			// 开启截图线程
			CaptureThread captureThread = new CaptureThread(dous, serverSocket);
			captureThread.start();
			// 开启回放事件线程
			EventReadThred eventReadThread = new EventReadThred(objectInputStream, serverSocket);
			eventReadThread.start();

		}
	}

}
