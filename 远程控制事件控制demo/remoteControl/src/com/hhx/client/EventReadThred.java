package com.hhx.client;

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

import com.hhx.entity.Events;
/**
 * 
* <p>Title: EventReadThred</p>
* <p>Description:�����ƶ˽����¼��� �ط��¼� </p>
* @author �λ�ϼ
* @date 2018��11��24��
 */
public class EventReadThred extends Thread {
	private  ObjectInputStream objins;
	private  ServerSocket socket;
	private double imgWidth;
	private double imgHeight;
	private double jlableWidth;
	private double jlableHeight;
	private double locationX;
	private double locationYLast;
	public  EventReadThred(ObjectInputStream objins,ServerSocket socket) {
		this.objins = objins;
		this.socket= socket;
	}
	
	//�ط��¼��ķ���
	private void actionEvent(InputEvent e){
		Robot robot =null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		//��ʲô�����¼�
		if(e instanceof KeyEvent){//����
			KeyEvent ke=(KeyEvent) e;
			if(e.getID()==KeyEvent.KEY_PRESSED){//����
				robot.keyPress(ke.getKeyCode());
			}
			if(e.getID()==KeyEvent.KEY_RELEASED){//�ͷ�
				robot.keyRelease(ke.getKeyCode());
			}
		}
        if(e instanceof MouseEvent){//���
        	MouseEvent me = (MouseEvent)e;
        	int type = me.getID();
        	if(type==MouseEvent.MOUSE_PRESSED){  //����
        		robot.mousePress(getMouseClick(me.getButton()));
        	}
        	if(type==MouseEvent.MOUSE_RELEASED){  //�ſ�
        		robot.mouseRelease(getMouseClick(me.getButton()));
        	}
        	if(type==MouseEvent.MOUSE_MOVED) { //�ƶ�
        		//robot.mouseMove(me.getX(), me.getY());
        		/*int x = Integer.parseInt(new java.text.DecimalFormat("0").format(me.getX() * (1366.00 / 1898.00)))-11;
				int y = Integer.parseInt(new java.text.DecimalFormat("0").format(me.getY() * (768.00 / 1024.00)))-34;
				robot.mouseMove(x, y);//45-11=34
				
*/				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				imgWidth = (double) screenSize.getWidth();
				imgHeight = (double) screenSize.getHeight();
				if(jlableWidth==0||jlableHeight==0) {
					System.err.println("jlabel is 0");
					robot.mouseMove(me.getX(), me.getY());
				}else {
					double m=(double)imgWidth;
					int x = Integer.parseInt(new java.text.DecimalFormat("0").format((me.getX()-locationX) * (imgWidth / jlableWidth)));
					int y = Integer.parseInt(new java.text.DecimalFormat("0").format((me.getY()-locationYLast) * (imgHeight / jlableHeight)));
					System.out.println("x:"+x);
					System.out.println("y:"+y);
					robot.mouseMove(x, y);//45-11=34
				}

        		
        	}
        	if(type==MouseEvent.MOUSE_DRAGGED) { //�϶�
        		robot.mouseMove(me.getX(), me.getY());
        	}
        	if(type==MouseEvent.MOUSE_WHEEL) {   //���ֹ���
        		robot.mouseWheel(getMouseClick(me.getButton()));
        	}
		}
		
	}
	
	//���ݷ����µ�Mouse�¼�����ת��Ϊͨ�õ�Mouse��������
	private int getMouseClick(int button){
		  if(button==MouseEvent.BUTTON1){
		      return InputEvent.BUTTON1_MASK;
		   } 
		  if(button==MouseEvent.BUTTON2){
			  return InputEvent.BUTTON2_MASK;
		 } 
		 if(button==MouseEvent.BUTTON3){
			  return InputEvent.BUTTON3_MASK;
		 }
		return -1;
	}
	
	
	@Override
	public void run() {
		//Ҳ���Զ�������������֣���һ�Σ�
		System.out.println("�¼��ط��߳����ӳɹ���");
		
			while(true){
				
					Object eventobj = null;
					try {
						eventobj = objins.readObject();
					} catch (ClassNotFoundException | IOException e1) {
						try {
							socket.close();
							objins.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						e1.printStackTrace();
					}
					Events events=(Events)eventobj;
					InputEvent e =  events.getEvent();
//				InputEvent e = (InputEvent) eventobj;
					//int i=objins.readInt();
					Map map=events.getMap();
					System.out.println(map);
					if(map.isEmpty()) {
						System.out.println("map is null");
					}else {
//						 imgWidth=0;
//						 imgHeight=0;
						 jlableWidth=0;
						 jlableHeight=0;
						 locationX=0;
						 locationYLast=0;
						
						if(map.get("jlableWidth")!=null) {
							
							int w=(int)map.get("jlableWidth");
							jlableWidth=(double)w;
							System.out.println(jlableWidth);
						}
						if(map.get("jlableHeight")!=null) {
							int h=(int)map.get("jlableHeight");
							jlableHeight=(double)h;
							System.out.println(jlableHeight);
						}
						if(map.get("locationX")!=null) {
							locationX=(double)map.get("locationX");
						}
						if(map.get("locationYLast")!=null) {
							locationYLast=(double)map.get("locationYLast");
						}
						
						
						System.out.println(jlableWidth);
						System.out.println(jlableHeight);
						System.out.println(locationX);
						System.out.println(locationYLast);
					}
					System.out.println("over");
					actionEvent(e);//�ط��¼�
					
				
			}
		
	}
	
		
			


	

}
