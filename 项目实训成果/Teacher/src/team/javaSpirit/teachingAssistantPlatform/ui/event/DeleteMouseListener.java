package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.feedback.dao.FeedBackDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

public class DeleteMouseListener implements MouseListener {
	private Index index;
	private FeedBackDaoImpl fbd;
	private CheckBoxMouseListener cb;
	
	public DeleteMouseListener(Index index) {
		this.index=index;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.index.jumpTeachBack();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
