package team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import team.javaSpirit.teachingAssistantPlatform.ui.MyJframe;

/**
 * 
 * <p>
 * Title: ConnectStudent
 * </p>
 * <p>
 * Description:教师端的逻辑过程。等待学生端（客户端），展示图片，传送点击事件
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年12月4日
 */
public class ConnectStudent {
	private ObjectOutputStream ous;// 输出流，传送点击事件
	private DataInputStream ins;// 输入流，展示图片
	private MyJframe jf = null;// 用于展示对象屏幕
	// 与服务器端的连接
	private ServerSocket serverSocket;
	/* 学生的IP */
	public static String ip;

	/**
	 * <p>
	 * Title: setupServer
	 * </p>
	 * <p>
	 * Description: 老师端开启服务。
	 * </p>
	 * 
	 * @param port 服务端口号
	 */
	public void setupServer(int port) {// 教师端开启端口
		// 控制端作为服务器端，开启传输
		try {
			serverSocket = new ServerSocket(port);
			while (!serverSocket.isClosed()) {
				// 产生“阻塞”，直至客户端有人传输
				Socket socket = serverSocket.accept();
				ip = socket.getInetAddress().getHostAddress();
				if (jf == null) {
					jf = new MyJframe(ous, this);
				}
				// 得到输入流，读取图片数据
				ins = new DataInputStream(socket.getInputStream());
				// 得到输出流，发送事件对象
				ous = new ObjectOutputStream(socket.getOutputStream());

				// 展示学生端图片
				ShowImageThread si = new ShowImageThread(ins, serverSocket, jf);
				si.start();// 执行这个线程
				// 给老师端传送鼠标相关的参数
				VarSend vs = new VarSend(ous, jf);
				vs.sentMouseSet();
				// 给jframe增加监听事件
				ListenerThread lt = new ListenerThread(ous, jf);
				lt.start();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "已经开过服务了。");
		}
	}

	/**
	 * <p>
	 * Title: closeServerSocket
	 * </p>
	 * <p>
	 * Description: 关闭服务
	 * </p>
	 */
	public void closeServerSocket() {
		try {
			ous.close();
			ins.close();
			serverSocket.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "服务关闭失败。");
			e.printStackTrace();
		}
	}

}
