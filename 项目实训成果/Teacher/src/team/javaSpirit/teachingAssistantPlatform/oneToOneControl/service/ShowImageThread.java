package team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;

import javax.imageio.ImageIO;

import team.javaSpirit.teachingAssistantPlatform.ui.MyJframe;

/**
 * 
 * <p>
 * Title: ShowImageThread
 * </p>
 * <p>
 * Description:展示学生端传送过来的截图的线程，并展现在jframe上。
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年12月4日
 */
public class ShowImageThread extends Thread {

	private DataInputStream ins;// 输入流
	private ServerSocket serverSocket;
	private MyJframe jf;

	ShowImageThread(DataInputStream ins, ServerSocket serverSocket, MyJframe jf) {
		this.ins = ins;
		this.serverSocket = serverSocket;
		this.jf = jf;
	}

	@Override
	public void run() {
		while (!serverSocket.isClosed()) {
			int len = 0;
			try {
				len = ins.readInt();

				byte[] data = new byte[len];// 创建一个空的字节数组
				ins.readFully(data);// 把读取的数据存储在data数组中
				// 将读到的数据生成为一个图标对象
				// ImageIcon ic=new ImageIcon(data);
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				BufferedImage image = ImageIO.read(in);
				// 放到界面上.加到标签上
				jf.setImgLabel(image);
			} catch (IOException e) {
				try {
					ins.close();
					serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} // 图片长度
		}
	}

}
