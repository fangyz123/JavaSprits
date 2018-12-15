package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Modify;

/**
 * 
 * <p>
 * Title: LoginMouseActionListener
 * </p>
 * <p>
 * Description:为登录界面添加鼠标监听事件
 * </p>
 * 
 * @author renyuyuan
 * @date 2018年12月13日
 */
public class LoginMouseActionListener implements MouseListener {

	/**
	 * 
	 * <p>
	 * Title: mouseClicked
	 * </p>
	 * <p>
	 * Description:点击修改密码时触发此业务逻辑
	 * </p>
	 * 
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Modify modify = new Modify();
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
