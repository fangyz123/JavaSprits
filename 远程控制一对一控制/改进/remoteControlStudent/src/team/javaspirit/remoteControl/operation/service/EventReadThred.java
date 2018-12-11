package team.javaspirit.remoteControl.operation.service;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import team.javaspirit.remoteControl.entity.Events;

/**
 * 
 * <p>
 * Title: EventReadThred
 * </p>
 * <p>
 * Description:被控制端（学生端）接受事件后 回放事件展现教师端对自己电脑的操作
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年11月24日
 */
public class EventReadThred extends Thread {
	private ObjectInputStream objins;// 输入流，用于读取点击事件
	private Socket socket;// 服务器端开启的服务
	private double imgWidth;// 传输图片的宽
	private double imgHeight;// 传输图片的高
	private double jlableWidth;// 展示图片的jlabel的高
	private double jlableHeight;// 展示图片的jlabel的宽
	private double locationX;// jlabel在屏幕上的X位置
	private double locationYLast;// jlabel在屏幕上的Y位置

	public EventReadThred(ObjectInputStream objins, Socket socket) {
		this.objins = objins;
		this.socket = socket;
	}

	// 回放事件的方法
	private void actionEvent(InputEvent e) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		// 是什么具体事件
		if (e instanceof KeyEvent) {// 键盘
			KeyEvent ke = (KeyEvent) e;
			if (e.getID() == KeyEvent.KEY_PRESSED) {// 按下
				robot.keyPress(ke.getKeyCode());
			}
			if (e.getID() == KeyEvent.KEY_RELEASED) {// 释放
				robot.keyRelease(ke.getKeyCode());
			}
		}
		if (e instanceof MouseEvent) {// 鼠标
			MouseEvent me = (MouseEvent) e;
			int type = me.getID();
			if (type == MouseEvent.MOUSE_PRESSED) { // 按下
				robot.mousePress(getMouseClick(me.getButton()));
			}
			if (type == MouseEvent.MOUSE_RELEASED) { // 放开
				robot.mouseRelease(getMouseClick(me.getButton()));
			}
			if (type == MouseEvent.MOUSE_MOVED) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				imgWidth = (double) screenSize.getWidth();
				imgHeight = (double) screenSize.getHeight();
				if (jlableWidth == 0 || jlableHeight == 0) {
					System.err.println("jlabel is 0");
					robot.mouseMove(me.getX(), me.getY());
				} else {
					double m = (double) imgWidth;
					int x = Integer.parseInt(new java.text.DecimalFormat("0")
							.format((me.getX() - locationX) * (imgWidth / jlableWidth)));
					int y = Integer.parseInt(new java.text.DecimalFormat("0")
							.format((me.getY() - locationYLast) * (imgHeight / jlableHeight)));
					System.out.println("x:" + x);
					System.out.println("y:" + y);
					robot.mouseMove(x, y);// 45-11=34
				}

			}
			if (type == MouseEvent.MOUSE_DRAGGED) { // 拖动
				robot.mouseMove(me.getX(), me.getY());
			}
			if (type == MouseEvent.MOUSE_WHEEL) { // 滑轮滚动
				robot.mouseWheel(getMouseClick(me.getButton()));
			}
		}

	}

	// 根据发送事的Mouse事件对象，转变为通用的Mouse按键代码
	private int getMouseClick(int button) {
		if (button == MouseEvent.BUTTON1) {
			return InputEvent.BUTTON1_MASK;
		}
		if (button == MouseEvent.BUTTON2) {
			return InputEvent.BUTTON2_MASK;
		}
		if (button == MouseEvent.BUTTON3) {
			return InputEvent.BUTTON3_MASK;
		}
		return -1;
	}

	/**
	 * 进行事件回放。在连接未关闭的时候一直读取事件流。获得events对象，然后从中获取点击事件
	 * 确定点击事件的类型，进行准确地回放。
	 */
	@Override
	public void run() {
		System.out.println("事件回放线程连接成功！");

		while (!socket.isClosed()) {

			try {
				Object eventobj = objins.readObject();
				if (eventobj != null) {
					Events events = (Events) eventobj;
					InputEvent e = events.getEvent();
					Map map = events.getMap();
					System.out.println(map);
					if (map.isEmpty()) {
						System.out.println("map is null");
					} else {

						jlableWidth = 0;
						jlableHeight = 0;
						locationX = 0;
						locationYLast = 0;

						if (map.get("jlableWidth") != null) {

							int w = (int) map.get("jlableWidth");
							jlableWidth = (double) w;
							System.out.println(jlableWidth);
						}
						if (map.get("jlableHeight") != null) {
							int h = (int) map.get("jlableHeight");
							jlableHeight = (double) h;
							System.out.println(jlableHeight);
						}
						if (map.get("locationX") != null) {
							locationX = (double) map.get("locationX");
						}
						if (map.get("locationYLast") != null) {
							locationYLast = (double) map.get("locationYLast");
						}

						System.out.println(jlableWidth);
						System.out.println(jlableHeight);
						System.out.println(locationX);
						System.out.println(locationYLast);
					}
					System.out.println("over");
					actionEvent(e);// 回放事件
				}
			} catch (IOException | ClassNotFoundException e1) {
				System.out.println("读取不到事件object");

				/*
				 * try { objins.close(); socket.close(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
			}

		}

	}

}
