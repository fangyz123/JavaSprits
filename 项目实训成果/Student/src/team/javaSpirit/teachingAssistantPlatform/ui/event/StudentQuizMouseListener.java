package team.javaSpirit.teachingAssistantPlatform.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import team.javaSpirit.teachingAssistantPlatform.entity.StudentQuiz;
import team.javaSpirit.teachingAssistantPlatform.quiz.service.QuizService;
import team.javaSpirit.teachingAssistantPlatform.ui.view.Index;

public class StudentQuizMouseListener implements MouseListener {

	private Index index;
	private StudentQuiz studentQuiz;
	public StudentQuizMouseListener(Index index,StudentQuiz studentQuiz) {
		this.index=index;
		this.studentQuiz=studentQuiz;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		String cont=new QuizService().getStudentQuiz(studentQuiz);
		this.index.jumpStudentQuiz(cont, studentQuiz);
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
