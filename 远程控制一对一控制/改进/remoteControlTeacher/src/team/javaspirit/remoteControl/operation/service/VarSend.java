package team.javaspirit.remoteControl.operation.service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import team.javaspirit.remoteControl.entity.Events;
import team.javaspirit.remoteControl.ui.MyJframe;

/**
 * 
 * <p>
 * Title: VarSend
 * </p>
 * <p>
 * Description:�����任�������õ��Ĳ��������¼������ȥ
 * </p>
 * 
 * @author �λ�ϼ
 * @date 2018��12��4��
 */
public class VarSend {
	private ObjectOutputStream ous;// �����
	private MyJframe jf;

	public VarSend(ObjectOutputStream ous, MyJframe jf) {
		this.ous = ous;
		this.jf = jf;
	}

	public void sentMouseSet() throws IOException {

		int jlableWidth = jf.getjLabel().getWidth();
		int jlableHeight = jf.getContentPane().getHeight();// jlabel�ĸ�
		double locationX = jf.getjLabel().getLocationOnScreen().getX();
		double locationY = jf.getjLabel().getLocationOnScreen().getY();
		// double locationYLast=locationY-((jf.getHeight()-jlableHeight)-locationY);

		System.out.println("jlableWidth" + jlableWidth);
		System.out.println("jlableHeight" + jlableHeight);
		System.out.println("locationX" + locationX);
		System.out.println("locationY" + locationY);
		System.out.println("locationYLast" + locationY);

		Events events = new Events();
		Map map = new HashMap<String, Object>();
		map.put("jlableWidth", jlableWidth);
		map.put("jlableHeight", jlableHeight);
		map.put("locationX", locationX);
		map.put("locationYLast", locationY);
		events.setMap(map);
		ous.writeObject(events);

	}

}
