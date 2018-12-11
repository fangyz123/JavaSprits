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
 * Description:�����ƶˣ�ѧ���ˣ������¼��� �ط��¼�չ�ֽ�ʦ�˶��Լ����ԵĲ���
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��11��24��
 */
public class EventReadThred extends Thread {
	private ObjectInputStream objins;// �����������ڶ�ȡ����¼�
	private Socket socket;// �������˿����ķ���
	private double imgWidth;// ����ͼƬ�Ŀ�
	private double imgHeight;// ����ͼƬ�ĸ�
	private double jlableWidth;// չʾͼƬ��jlabel�ĸ�
	private double jlableHeight;// չʾͼƬ��jlabel�Ŀ�
	private double locationX;// jlabel����Ļ�ϵ�Xλ��
	private double locationYLast;// jlabel����Ļ�ϵ�Yλ��

	public EventReadThred(ObjectInputStream objins, Socket socket) {
		this.objins = objins;
		this.socket = socket;
	}

	// �ط��¼��ķ���
	private void actionEvent(InputEvent e) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		// ��ʲô�����¼�
		if (e instanceof KeyEvent) {// ����
			KeyEvent ke = (KeyEvent) e;
			if (e.getID() == KeyEvent.KEY_PRESSED) {// ����
				robot.keyPress(ke.getKeyCode());
			}
			if (e.getID() == KeyEvent.KEY_RELEASED) {// �ͷ�
				robot.keyRelease(ke.getKeyCode());
			}
		}
		if (e instanceof MouseEvent) {// ���
			MouseEvent me = (MouseEvent) e;
			int type = me.getID();
			if (type == MouseEvent.MOUSE_PRESSED) { // ����
				robot.mousePress(getMouseClick(me.getButton()));
			}
			if (type == MouseEvent.MOUSE_RELEASED) { // �ſ�
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
			if (type == MouseEvent.MOUSE_DRAGGED) { // �϶�
				robot.mouseMove(me.getX(), me.getY());
			}
			if (type == MouseEvent.MOUSE_WHEEL) { // ���ֹ���
				robot.mouseWheel(getMouseClick(me.getButton()));
			}
		}

	}

	// ���ݷ����µ�Mouse�¼�����ת��Ϊͨ�õ�Mouse��������
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
	 * �����¼��طš�������δ�رյ�ʱ��һֱ��ȡ�¼��������events����Ȼ����л�ȡ����¼�
	 * ȷ������¼������ͣ�����׼ȷ�ػطš�
	 */
	@Override
	public void run() {
		System.out.println("�¼��ط��߳����ӳɹ���");

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
					actionEvent(e);// �ط��¼�
				}
			} catch (IOException | ClassNotFoundException e1) {
				System.out.println("��ȡ�����¼�object");

				/*
				 * try { objins.close(); socket.close(); } catch (IOException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
			}

		}

	}

}
