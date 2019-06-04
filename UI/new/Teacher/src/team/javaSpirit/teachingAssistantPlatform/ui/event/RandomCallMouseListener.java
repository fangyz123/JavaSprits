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
 * Description: 为随机点名的按钮和图片域添加鼠标点击事件。 实现页面的实现和跳转。
 * </p>
 * 
 * @author Fang Yuzhen
 * @date 2018年12月25日
 */
public class RandomCallMouseListener implements MouseListener {

	private Index index;

	public RandomCallMouseListener(Index index) {
		this.index = index;
	}

	/**
	 * 点击实现页面的跳转
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// 跳转到随机点名界面，展示"学号 姓名"、开始和暂停的按钮
		this.index.jumpRandomcall();
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
