package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

public class QuizMouseListener implements MouseListener {
	private Index index;
	public QuizMouseListener(Index index) {
		this.index=index;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.index.jumpQuiz();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//鼠标进入菜单时改变鼠标形状
		@Override
		public void mouseEntered(MouseEvent e) {
			this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		//鼠标离开菜单时恢复鼠标形状
		@Override
		public void mouseExited(MouseEvent e) {
			this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}

}
