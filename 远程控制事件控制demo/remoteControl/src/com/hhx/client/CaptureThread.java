package com.hhx.client;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

/**
 * 
* <p>Title: CaptureThread</p>
* <p>Description:发送图片的线程 </p>
* @author 何慧霞
* @date 2018年11月24日
 */
public class CaptureThread extends Thread {
	private DataOutputStream dataOutputStream;
	private ServerSocket socket;
	private Toolkit tk ;
	private  Dimension dm ;
	private Rectangle rec;
	private  Robot robot ;
	public CaptureThread(DataOutputStream dataOutputStream,ServerSocket socket) throws AWTException {
		this.dataOutputStream = dataOutputStream;
		this.socket=socket;
		tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		//根据屏幕设定图片的大小
		rec = new Rectangle(0, 0, (int)dm.getWidth(), (int)dm.getHeight());
		robot  = new Robot();//在这里进行了初始化。所以这里new了。前面蛋糕可以不直接new，
		//在构造函数中new  但是构造函数，没有new
	}
	
	private byte[] createCature() {
		//获得一个屏幕的截图
		BufferedImage bimage = robot.createScreenCapture(rec);
		////创建一段内存流
		ByteArrayOutputStream byout = new ByteArrayOutputStream();
		try {
			//将图片数据写入内存流中
			ImageIO.write(bimage, "png", byout);
		} catch (IOException e) {
			System.out.println("截屏图片写入内存流中出现异常");
			try {
				dataOutputStream.close();
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return byout.toByteArray();
	}
	
	@Override
	public void run() {
		while(!socket.isClosed()){
			//获得截图的字节数组
			byte[] data = createCature();
			try {
				dataOutputStream.writeInt(data.length);
				dataOutputStream.write(data);
				dataOutputStream.flush();
				try {
					Thread.sleep(1000);//1000/20
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				try {
					dataOutputStream.close();
					socket.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				System.out.println("网络有问题,截屏失败");
			}
			
		}
	}
	

}
