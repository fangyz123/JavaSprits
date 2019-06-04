package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

public class DistributionWorkMouseListener implements MouseListener {
	/* 监听页面的对象 */
	private Index index;

	public DistributionWorkMouseListener(Index index) {
		this.index = index;
	}

	/**
	 * 点击实现页面的跳转
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// 跳转到学生演示界面，显示每个学生的小电脑和名字
		this.index.jumpDistributionWork();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	

}
