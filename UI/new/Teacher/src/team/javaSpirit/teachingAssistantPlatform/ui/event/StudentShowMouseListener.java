package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

/**
 * <p>
 * Title: StudentShowMouseListener
 * </p>
 * <p>
 * Description: 为学生演示的按钮和图片域添加鼠标点击事件。 实现页面的实现和跳转。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月25日
 */
public class StudentShowMouseListener implements MouseListener {
	/* 监听页面的对象 */
	private Index index;

	public StudentShowMouseListener(Index index) {
		this.index = index;
	}

	/**
	 * 点击实现页面的跳转
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// 跳转到学生演示界面，显示每个学生的小电脑和名字
		this.index.jumpSelectstu();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
