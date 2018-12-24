package team.javaSpirit.teachingAssistantPlatform.oneToOneControl.service;

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

import team.javaSpirit.teachingAssistantPlatform.entity.Events;
import team.javaSpirit.teachingAssistantPlatform.ui.MyJframe;


/**
 * 
* <p>Title: ListenerThread</p>
* <p>Description: 给jframe添加监听器，监听教师端在jframe上的操作，把相关事件传输到学生端</p>
* @author 何慧霞
* @date 2018年12月3日
 */
public class ListenerThread extends Thread {
	private MyJframe jf;
	private ObjectOutputStream ous;// 输出流
	ListenerThread(ObjectOutputStream ous,MyJframe jf) {
		this.ous=ous;
		this.jf=jf;
	}
	
	
	@Override
	public void run() {
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

						sentEvent(arg0);

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


	/**
	 * 
	 * <p>Title: sentEvent</p>
	 * <p>Description:在每个监听器中监听到的事件会利用此函数写入到输出流，然后传输过去 </p>
	 * @param e
	 */
	public void sentEvent(InputEvent e) {
		try {
			Events events=new Events();
			events.setEvent(e);
			ous.writeObject(events);//【】有可能在这里写不进去。所以是不是得先把ous给初始化了
		} catch (IOException e1) {
			System.out.println("发送事件对象出现异常");
			e1.printStackTrace();
		}
	}
}
