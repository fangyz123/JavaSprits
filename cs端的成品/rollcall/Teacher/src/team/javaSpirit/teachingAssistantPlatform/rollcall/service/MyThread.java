package team.javaSpirit.teachingAssistantPlatform.rollcall.service;

import java.util.List;
import java.util.ResourceBundle.Control;

import javax.swing.JLabel;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;

public class MyThread extends Thread {
	public Thread T;
	private String threadName;
	private Boolean re = false;
	private List<Students> list;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public MyThread(List<Students> list, JLabel lblNewLabel_1, JLabel lblNewLabel_2) {
		super();
		this.list = list;
		this.lblNewLabel_1 = lblNewLabel_1;
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public void setSuspend(Boolean re) {
		if(!re) {
			synchronized (re) {
				threadName.notifyAll();
			}
		}
		this.re = re;
	}

	@Override
	public void run() {
		while (true) {
			for (Students s : list) {
				lblNewLabel_2.setText(s.getName());
				lblNewLabel_1.setText(s.getSid());
				try {
					Thread.sleep(100);
					if(this.isInterrupted()) {
						this.notify();
					}
				} catch (InterruptedException e) {
					Thread curr = Thread.currentThread();
				}
			}
		}
		
	}

	
}
