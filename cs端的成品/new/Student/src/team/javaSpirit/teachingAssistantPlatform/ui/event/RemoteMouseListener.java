package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
/**
 * 
* <p>Title: RemoteMouseListener</p>
* <p>Description:为远程监控菜单添加鼠标事件监听 </p>
* @author renyuyuan
* @date 2018年12月19日
 */
public class RemoteMouseListener implements MouseListener {
	private Index index;
	public RemoteMouseListener(Index index) {
		this.index=index;
	}
	//点击远程监控菜单触发此业务逻辑
	@Override
	public void mouseClicked(MouseEvent e) {
		this.index.jumpRemote();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	//鼠标进入远程监控菜单触发此业务逻辑
	@Override
	public void mouseEntered(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	//鼠标离开远程监控菜单触发此业务逻辑
	@Override
	public void mouseExited(MouseEvent e) {
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
