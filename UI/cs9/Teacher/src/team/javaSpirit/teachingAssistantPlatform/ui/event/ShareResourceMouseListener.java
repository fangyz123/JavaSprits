package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
/**
 * 
* <p>Title: ShareResourceMouseListener</p>
* <p>Description:为资源共享菜单提供鼠标事件 </p>
* @author renyuyuan
* @date 2018年12月20日
 */
public class ShareResourceMouseListener implements MouseListener {
	private Index index;
	public ShareResourceMouseListener(Index index) {
		this.index=index;
	}
	//点击资源共享时调用此业务逻辑
	@Override
	public void mouseClicked(MouseEvent e) {
		this.index.jumpShareResource();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//鼠标进入共享资源菜单时改变鼠标形状
	@Override
	public void mouseEntered(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	//鼠标离开共享资源菜单时恢复鼠标形状
	@Override
	public void mouseExited(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
