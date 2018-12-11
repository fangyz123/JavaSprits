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
 * Description:把鼠标变换比例所用到的参数利用事件传输过去
 * </p>
 * 
 * @author 何慧霞
 * @date 2018年12月4日
 */
public class VarSend {
	private ObjectOutputStream ous;// 输出流
	private MyJframe jf;

	public VarSend(ObjectOutputStream ous, MyJframe jf) {
		this.ous = ous;
		this.jf = jf;
	}

	public void sentMouseSet() throws IOException {

		int jlableWidth = jf.getjLabel().getWidth();
		int jlableHeight = jf.getContentPane().getHeight();// jlabel的高
		double locationX = jf.getjLabel().getLocationOnScreen().getX();
		double locationY = jf.getjLabel().getLocationOnScreen().getY();

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
