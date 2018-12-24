package team.javaSpirit.teachingAssistantPlatform.rollcall.service;

import java.util.List;

import javax.swing.JLabel;

import team.javaSpirit.teachingAssistantPlatform.entity.Students;

public class RollCallThread extends Thread {
	private Boolean re = true;
	private List<Students> list;
	private JLabel lblNewLabel_1;

	public RollCallThread(JLabel lblNewLabel_1) {
		super();
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public void setList(List<Students> list) {
		this.list = list;
	}

	public void setRe(Boolean re) {
		this.re = re;
	}

	@Override
	public void run() {
		for (int i = 0; i < list.size();) {
			String s1 = list.get(i).getSid() + " " + list.get(i).getName();
			lblNewLabel_1.setText(s1);
			i++;
			if (i == list.size()) {
				i = 0;
			}
			if (re == false) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
