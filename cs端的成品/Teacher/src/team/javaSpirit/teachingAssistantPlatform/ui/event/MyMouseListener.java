package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.Modify;

/**
* <p>Title: MyMouseListener</p>
* <p>Description: 监听鼠标的操作事件。在相关的方法里实现对应的操作。</p>
* @author Fang Yuzhen
* @date 2018年12月6日
 */
public class MyMouseListener implements MouseListener {

	public MyMouseListener() {
	
	}

	/**
	 * 鼠标点击事件，实现修改密码
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Modify modify=new Modify();
		modify.init();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
