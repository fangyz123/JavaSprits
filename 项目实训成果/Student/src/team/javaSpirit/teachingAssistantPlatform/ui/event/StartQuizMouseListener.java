package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;
import team.javaSpirit.teachingAssistantPlatform.ui.view.QuizTest;

public class StartQuizMouseListener implements MouseListener {
	
	private Index index;
	private StudentQuiz studentQuiz;
	public StartQuizMouseListener(Index index,StudentQuiz studentQuiz) {
		this.index=index;this.studentQuiz=studentQuiz;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		QuizTest quizTest=new QuizTest(this.studentQuiz,this.index);
		quizTest.init();
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
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(new Color(70, 130, 180));
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(new Color(105, 105, 105));
		this.index.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
