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
 * Description:���ƶ�
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��11��24��
 */
public class Service extends Thread {
	private ObjectOutputStream ous;// �����
	private DataInputStream ins;// ������
	private MyJframe jf = new MyJframe(ous);
	private Socket sc;
	private BufferedImage image;
	// 1����������̨��չʾ�����ƶ˵���Ļ
	private void showUI() {// ��������̨
		//jf.getMousePosition().getY();
		//MyJframe jf = new MyJframe(ous);
		System.out.println("height:"+jf.getContentPane().getHeight());
		addListener(jf); // ��Ӽ�������¼���ƶ����еĲ���
		jf.addPropertyChangeListener(new PropertyChangeListener() {
			// ����һ������������������Ϊ��������а�����ע���

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				System.out.println(arg0.getNewValue());
			}
		});
	}

	// 2.���ӷ����������Ʒ���Ϊ����Ŀͻ��ˣ�
	private void conn2Server(String ip, int port) throws Exception {
		 sc = new Socket(ip, port);
		// �õ�����������ȡͼƬ����
		ins = new DataInputStream(sc.getInputStream());
		// �õ�������������¼�����
		ous = new ObjectOutputStream(sc.getOutputStream());
		// ������������
	}

	@Override
	public void run() {
		
		
		while (!sc.isClosed()) {
			int len = 0;
			try {
				len = ins.readInt();
				byte[] data = new byte[len];// ����һ���յ��ֽ�����
				ins.readFully(data);// �Ѷ�ȡ�����ݴ洢��data������
				// ����������������Ϊһ��ͼ�����
				// ImageIcon ic=new ImageIcon(data);
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				image= ImageIO.read(in);
				
				/*
				 * BufferedImage ic=new BufferedImage(width, height, imageType); Graphics2D g =
				 * ic.createGraphics(); g.drawRenderedImage(s,
				 * AffineTransform.getScaleInstance(1, 1)); g.dispose();
				 */
				// �ŵ�������.�ӵ���ǩ��
				jf.setImgLabel(image);
			} catch (IOException e) {
				System.out.println("�����ƶ˶Ͽ�����");
				try {
					ins.close();
					ous.close();
					sc.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			} // ͼƬ����
		}

	}

	private void addListener(MyJframe jf) {
		// ������������������������
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

		// ����ƶ��¼�
		jf.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
//				arg0.getXOnScreen()
				Point point=jf.getMousePosition();
				System.out.println("jf"+point.getX()+","+point.getY());
				sentEvent(arg0);
				
					
					//System.out.println("���λ��"+arg0.getX()+","+arg0.getY());
				
				//System.out.println(point);
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {//�����ק
				
				sentEvent(arg0);
			}

		});
		// ��껬�ֻ����¼�
		jf.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				sentEvent(arg0);

			}
		});

		// �����¼�
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

	// ���¼�д�뵽�������
	private void sentEvent(InputEvent e) {
		try {
			Events events=new Events();
			events.setEvent(e);
			ous.writeObject(events);
		} catch (IOException e1) {
			System.out.println("�����¼���������쳣");
			e1.printStackTrace();
		}
	}
	private void sentMouseSet() throws IOException {
		String string=jf.returnVar();
		System.out.println("return"+string);
		//ous.writeObject(string);
		//ous.writeObject("12345");
		//ous.writeInt(30);
		
		//int imageWidth=image.getWidth();//ͼƬ
		//int imageHeight=image.getHeight();
		int jlableWidth=jf.getjLabel().getWidth();
		int jlableHeight=jf.getContentPane().getHeight();//jlabel�ĸ� 
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
		// ��ʾ�����ƶ˴��������ʵʱ��ͼ
		cn.showUI();
		// ��¼��������ƶ����������¼�������������ƶ�
		cn.conn2Server("localhost", 9090);
		cn.sentMouseSet();
		cn.start();// ִ������߳�
		// "10.7.89.22""localhost" "10.7.84.42"  10.7.84.78
	}

}
