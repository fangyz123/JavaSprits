package com.hhx.client;

import java.awt.event.InputEvent;
import java.io.IOException;
import java.io.ObjectInputStream;

public class VarReadThread extends Thread{
	private  ObjectInputStream objins;

	public  VarReadThread(ObjectInputStream objins) {
		this.objins = objins;
	}
	@Override
	public void run() {
		String str="";
		while(true){
			try {
				System.out.println("�ߴ��߳����ӳɹ���");
				int width = objins.readInt();
				str=str+","+width;
				System.out.println("str:"+str);
				
				
			} catch (IOException e) {
				System.out.println("ޒ���¼�ʧ��");
				try {
					objins.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}

	

}
