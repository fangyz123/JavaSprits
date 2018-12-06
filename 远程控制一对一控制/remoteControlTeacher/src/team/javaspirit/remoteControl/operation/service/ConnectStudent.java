package team.javaspirit.remoteControl.operation.service;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import team.javaspirit.remoteControl.ui.MyJframe;
/**
 * 
* <p>Title: ConnectStudent</p>
* <p>Description:教师端的逻辑过程。连接学生端（服务器端），展示图片，传送点击事件 </p>
* @author 何慧霞
* @date 2018年12月4日
 */
public class ConnectStudent {
	private ObjectOutputStream ous;// 输出流
	private DataInputStream ins;// 输入流
	private MyJframe jf = new MyJframe(ous);// 用于展示对象屏幕
	private Socket scoket;// 与服务器端的连接

	public void conn2Server(String ip, int port) throws Exception {

		// 连接学生端
		scoket = new Socket(ip, port);
		// 得到输入流，读取图片数据
		ins = new DataInputStream(scoket.getInputStream());
		// 得到输出流，发送事件对象
		ous = new ObjectOutputStream(scoket.getOutputStream());
		

		// 展示学生端图片
		ShowImageThread si = new ShowImageThread(ins, scoket, jf);
		si.start();// 执行这个线程
		// 给老师端传送鼠标相关的参数
		VarSend vs = new VarSend(ous, jf);
		vs.sentMouseSet();
		// 给jframe增加监听事件
		ListenerThread lt = new ListenerThread(ous, jf);
		lt.start();
	}

}
