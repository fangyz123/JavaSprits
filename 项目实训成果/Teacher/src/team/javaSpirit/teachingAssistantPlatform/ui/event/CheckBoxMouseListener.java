package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;

import team.javaSpirit.teachingAssistantPlatform.entity.FeedBack;
import team.javaSpirit.teachingAssistantPlatform.feedback.dao.FeedBackDaoImpl;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

public class CheckBoxMouseListener implements MouseListener{

	private FeedBackDaoImpl fbd;
	private Index index;
	private FeedBack fb;
	public CheckBoxMouseListener(Index index,FeedBack fb) {
		this.index=index;
		this.fb=fb;
		this.fbd=new FeedBackDaoImpl();
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// 获取事件源（即复选框本身）
		
        JCheckBox checkBox = (JCheckBox) e.getSource();
        if (checkBox.isSelected()) {
        	checkBox.setBackground(new Color(165,218,191));
        	System.out.println(fb.getId());
        	fbd.changeStatus(fb);
	      } else{
	    	  checkBox.setBackground(new Color(202,226,254));
	    	 fbd.changeStatusTozero(fb);
	      }
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
