package team.javaspirit.remoteControl.operation.service;

import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import team.javaspirit.remoteControl.entity.Events;
import team.javaspirit.remoteControl.ui.MyJframe;


/**
 * 
* <p>Title: ListenerThread</p>
* <p>Description: ��jframe��Ӽ�������������ʦ����jframe�ϵĲ�����������¼����䵽ѧ����</p>
* @author �λ�ϼ
* @date 2018��12��3��
 */
public class ListenerThread extends Thread {
	private MyJframe jf;
	private ObjectOutputStream ous;// �����
	ListenerThread(ObjectOutputStream ous,MyJframe jf) {
		this.ous=ous;
		this.jf=jf;
	}
	
	
	@Override
	public void run() {
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
//						arg0.getXOnScreen()
						Point point=jf.getMousePosition();
						System.out.println("jf"+point.getX()+","+point.getY());
						sentEvent(arg0);

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


	/**
	 * 
	 * <p>Title: sentEvent</p>
	 * <p>Description:��ÿ���������м��������¼������ô˺���д�뵽�������Ȼ�����ȥ </p>
	 * @param e
	 */
	public void sentEvent(InputEvent e) {
		try {
			Events events=new Events();
			events.setEvent(e);
			ous.writeObject(events);//�����п���������д����ȥ�������ǲ��ǵ��Ȱ�ous����ʼ����
		} catch (IOException e1) {
			System.out.println("�����¼���������쳣");
			e1.printStackTrace();
		}
	}
}
