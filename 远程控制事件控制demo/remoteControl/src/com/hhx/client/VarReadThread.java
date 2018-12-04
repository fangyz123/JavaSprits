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
				System.out.println("尺寸线程连接成功！");
				int width = objins.readInt();
				str=str+","+width;
				System.out.println("str:"+str);
				
				
			} catch (IOException e) {
				System.out.println("迴放事件失敗");
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
