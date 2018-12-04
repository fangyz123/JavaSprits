package com.hhx.service;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.hhx.entity.Events;
import com.hhx.ui.MyJframe;

/**
 * 
 * <p>
 * Title: Service
 * </p>
 * <p>
 * Description:控制端
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年11月24日
 */
public class Service extends Thread {
	private ObjectOutputStream ous;// 输出流
	private DataInputStream ins;// 输入流
	private MyJframe jf = new MyJframe(ous);
	private Socket sc;
	private BufferedImage image;
	// 1、调出控制台，展示被控制端的屏幕
	private void showUI() {// 调出控制台
		//jf.getMousePosition().getY();
		//MyJframe jf = new MyJframe(ous);
		System.out.println("height:"+jf.getContentPane().getHeight());
		addListener(jf); // 添加监听，记录控制端所有的操作
		jf.addPropertyChangeListener(new PropertyChangeListener() {
			// 增加一个侦听器。侦听器是为此类的所有绑定属性注册的

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				System.out.println(arg0.getNewValue());
			}
		});
	}

	// 2.连接服务器（控制方作为传输的客户端）
	private void conn2Server(String ip, int port) throws Exception {
		 sc = new Socket(ip, port);
		// 得到输入流，读取图片数据
		ins = new DataInputStream(sc.getInputStream());
		// 得到输出流，发送事件对象
		ous = new ObjectOutputStream(sc.getOutputStream());
		// 处理这两个流
	}

	@Override
	public void run() {
		
		
		while (!sc.isClosed()) {
			int len = 0;
			try {
				len = ins.readInt();
				byte[] data = new byte[len];// 创建一个空的字节数组
				ins.readFully(data);// 把读取的数据存储在data数组中
				// 将读到的数据生成为一个图标对象
				// ImageIcon ic=new ImageIcon(data);
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				image= ImageIO.read(in);
				
				/*
				 * BufferedImage ic=new BufferedImage(width, height, imageType); Graphics2D g =
				 * ic.createGraphics(); g.drawRenderedImage(s,
				 * AffineTransform.getScaleInstance(1, 1)); g.dispose();
				 */
				// 放到界面上.加到标签上
				jf.setImgLabel(image);
			} catch (IOException e) {
				System.out.println("被控制端断开连接");
				try {
					ins.close();
					ous.close();
					sc.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			} // 图片长度
		}

	}

	private void addListener(MyJframe jf) {
		// 增加鼠标监听器（匿名函数）
		jf.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				sentEvent(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				sentEvent(e);
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		// 鼠标移动事件
		jf.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
//				arg0.getXOnScreen()
				Point point=jf.getMousePosition();
				System.out.println("jf"+point.getX()+","+point.getY());
				sentEvent(arg0);
				
					
					//System.out.println("鼠标位置"+arg0.getX()+","+arg0.getY());
				
				//System.out.println(point);
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {//鼠标拖拽
				
				sentEvent(arg0);
			}

		});
		// 鼠标滑轮滑动事件
		jf.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				sentEvent(arg0);

			}
		});

		// 键盘事件
		jf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				
				sentEvent(arg0);
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				sentEvent(arg0);

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				sentEvent(arg0);

			}
		});
	}

	// 把事件写入到输出流中
	private void sentEvent(InputEvent e) {
		try {
			Events events=new Events();
			events.setEvent(e);
			ous.writeObject(events);
		} catch (IOException e1) {
			System.out.println("发送事件对象出现异常");
			e1.printStackTrace();
		}
	}
	private void sentMouseSet() throws IOException {
		String string=jf.returnVar();
		System.out.println("return"+string);
		//ous.writeObject(string);
		//ous.writeObject("12345");
		//ous.writeInt(30);
		
		//int imageWidth=image.getWidth();//图片
		//int imageHeight=image.getHeight();
		int jlableWidth=jf.getjLabel().getWidth();
		int jlableHeight=jf.getContentPane().getHeight();//jlabel的高 
		double locationX=jf.getjLabel().getLocationOnScreen().getX();
		double locationY=jf.getjLabel().getLocationOnScreen().getY();
		double locationYLast=locationY-((jf.getHeight()-jlableHeight)-locationY);
		
		double j=jf.getContentPane().getLocationOnScreen().getY();
		//System.out.println("imageWidth:"+imageWidth);
		//System.out.println("imageHeight"+imageHeight);
		System.out.println("jlableWidth"+jlableWidth);
		System.out.println("jlableHeight"+jlableHeight);
		System.out.println("locationX"+locationX);
		System.out.println("locationY"+locationY);
		System.out.println("locationYLast"+locationYLast);
		System.out.println(j);
		
		Events events=new Events();
		Map map=new HashMap<String,Object>();
		map.put("jlableWidth",jlableWidth );
		map.put("jlableHeight", jlableHeight);
		map.put("locationX", locationX);
		map.put("locationYLast", locationYLast);
		events.setMap(map);
		ous.writeObject(events);
		
		
	}

	public static void main(String[] args) throws Exception {
		Service cn = new Service();
		// 显示被控制端传输过来的实时截图
		cn.showUI();
		// 记录并传输控制端所操作的事件并传输给被控制端
		cn.conn2Server("localhost", 9090);
		cn.sentMouseSet();
		cn.start();// 执行这个线程
		// "10.7.89.22""localhost" "10.7.84.42"  10.7.84.78
	}

}
