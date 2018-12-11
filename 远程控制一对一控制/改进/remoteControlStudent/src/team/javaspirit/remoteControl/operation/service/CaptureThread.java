package team.javaspirit.remoteControl.operation.service;

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
* <p>Description:截图、发送图片的线程 </p>
* @author 何慧霞
* @date 2018年11月24日
 */
public class CaptureThread extends Thread {
	private DataOutputStream dataOutputStream;
	private Socket socket;
	private Toolkit tk ;
	private  Dimension dm ;
	private Rectangle rec;
	private  Robot robot ;
	public CaptureThread(DataOutputStream dataOutputStream,Socket socket) throws AWTException {
		this.dataOutputStream = dataOutputStream;
		this.socket=socket;
		tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		//根据屏幕设定图片的大小
		rec = new Rectangle(0, 0, (int)dm.getWidth(), (int)dm.getHeight());
		robot  = new Robot();//在这里进行了初始化。所以这里new了。前面蛋糕可以不直接new，
		//在构造函数中new  但是构造函数，没有new
	}
	
	/**
	 * 
	 * <p>Title: createCature</p>
	 * <p>Description:主要用于截图。截取当前屏幕的图。主要使用了robot这个类。把截取的图片
	 * 转换成字节数组输出流。方便后面把字节数组写入输出流中传输到教师端，展示学生端的屏幕 </p>
	 * @return
	 */
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
	
	/**
	 * 这是线程的重组函数。在连接没有关闭的时候，每隔100毫秒进行截图。然后把图写入到数据输出
	 * 流中。这里可能会有异常。为了服务器和客户端一端先关闭连接一直报错，在catch中关闭连接。
	 */
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
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//1000/20
				
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
